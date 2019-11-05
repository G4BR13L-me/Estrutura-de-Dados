package br.ufpi.ed;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

public class TabelaDeSimbolos {
	
	public static Set<Integer> criaNumeros(int num) {
		Random rd = new Random();
		Set<Integer> numeros = new HashSet<Integer>();
		int cont=0;
		while(cont<num*128) {
			if(numeros.add(rd.nextInt()))
				cont++;
		}
		return numeros;
	}
	
	public static boolean buscaBinaria(String a,int indice, String[] array) {
		int ini = 0, fim = array.length-1;
		int meio,flag=0;
		array[indice]="";
		
		do{
			meio=(ini+fim)/2;
			if(a.compareTo(array[meio])<0)
				fim=meio-1;
			else if(a.compareTo(array[meio])>0)
				ini=meio+1;
			else 
				flag=1;
		}while(flag!=1&&ini<fim);
		
		array[indice]=a;
		
		if(flag==1)
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		
		do {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n1 - Fazer experimento\n0 - Sair"));
			if(escolha!=1)
				break;
			int num = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero de chaves desejado:"));
			int busca = Integer.parseInt(JOptionPane.showInputDialog("Busca:\n1 - Sequencial\n2 - Binária"));
			switch (busca) {
			case 1:
				int[] numeros = criaNumeros
				break;
			case 2:
				
				break;	
			default:
				break;
			}
			
		}while(true);
	}
}
