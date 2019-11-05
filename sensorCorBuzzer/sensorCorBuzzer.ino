int s0 = 8;
int s1 = 9;
int s2 = 12;
int s3 = 11;
int out = 10;

//Pinos do leds
int pinoledverm = 2;
int pinoledamarelo = 3;
int pinoledverde = 4;
 
//Variaveis cores
int red = 0;
int green = 0;
int blue = 0;

//buzzer
int buzzer = 6;
 
void setup()
{
  //S0 e S1 determinam a frequência de saída
  pinMode(s0, OUTPUT);
  pinMode(s1, OUTPUT);
  //S2 e S3 determinam qual nível de cor será detectado no momento
  pinMode(s2, OUTPUT);
  pinMode(s3, OUTPUT);
  //64 fotodiodos geram informação e passam para o pino out que envia para o arduino
  pinMode(out, INPUT);
  //leds
  pinMode(pinoledverm, OUTPUT);
  pinMode(pinoledverde, OUTPUT);
  pinMode(pinoledamarelo, OUTPUT);
  //buzzer
  pinMode(buzzer, OUTPUT);
  
  Serial.begin(9600);
  //setando a frequência da saida para 20%
  digitalWrite(s0, HIGH);
  digitalWrite(s1, LOW);
}
 
void loop()
{
  //Detecta a cor
  detecta();
  //Printando os valores
  Serial.print("Vermelho :");
  Serial.print(red, DEC);
  Serial.print(" Verde : ");
  Serial.print(green, DEC);
  Serial.print(" Azul : ");
  Serial.print(blue, DEC);
  Serial.println();

  //detecta amarelo
  if(red < green && red < blue && (red > 33 && red < 160) && (green > 40 &&green < 185)){
    Serial.println("Amarelo");
    digitalWrite(pinoledverm, LOW); 
    digitalWrite(pinoledverde, LOW);
    digitalWrite(pinoledamarelo, HIGH); //Acende o led amarelo
    //parametros da funcao tone: (pinoBuzzer,frequencia,duracaoms);
    tone(buzzer,294,300); //RE
    delay(500);
  }
  
  //detecta vermelho
  else if (red < blue && red < green && red >= 45)
  {
    Serial.println("Vermelho");
    digitalWrite(pinoledverm, HIGH); //Acende o led vermelho
    digitalWrite(pinoledverde, LOW);
    digitalWrite(pinoledamarelo, LOW);
    //ligando buzzer
 
    tone(buzzer,330,300); //MI 
  }

  //detecta verde
  else if (green < red && green < blue)
  {
    Serial.println("Verde");
    digitalWrite(pinoledverm, LOW);
    digitalWrite(pinoledverde, HIGH); //Acende o led verde
    digitalWrite(pinoledamarelo, LOW);
    //ligando buzzer
    tone(buzzer,262,200); //DO
    delay(700);
  }
  Serial.println();
 
  //Delay para apagar os leds e reiniciar o processo
  delay(300);
  digitalWrite(pinoledverm, LOW);
  digitalWrite(pinoledverde, LOW);
  digitalWrite(pinoledamarelo, LOW);
}
 
void detecta()
{
  //seta o filtro para vermelho s2-LOW|s3-LOW
  digitalWrite(s2, LOW);
  digitalWrite(s3, LOW);
  //recebe o valor de vermelho
  if(digitalRead(out) == HIGH){
    red = pulseIn(out, LOW); //função pulseIn retorna o tamanho do pulso em microssegundos
  }else{
    red = pulseIn(out, HIGH);
  }
  // muda s3 para HIGH, alterando o filtro para azul s2-LOW|s3-HIGH
  digitalWrite(s3, HIGH); 
  // recebe o valor de azul
  if(digitalRead(out) == HIGH){
    blue = pulseIn(out, LOW);
  }else{
    blue = pulseIn(out, HIGH);
  }
  // muda s2 para HIGH, alterando o filtro para verde s2-HIGH|s3-HIGH
  digitalWrite(s2, HIGH);
  //recebe o valor de verde
  if(digitalRead(out) == HIGH){
    green = pulseIn(out, LOW);
  }else{
    green = pulseIn(out, HIGH);
  }
}
