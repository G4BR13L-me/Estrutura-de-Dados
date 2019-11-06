package br.ufpi.ed;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


import javax.swing.JOptionPane;

public class TabelaDeSimbolos {
	private List<Integer> key;
	private List<Integer> value;
	
	public TabelaDeSimbolos() {
		this.key = new LinkedList<Integer>();
		this.value = new LinkedList<Integer>();
	}
	
	public void adicionar(Integer key,Integer value) {
		int index = this.key.indexOf(key);
		if(index!=-1) {
			this.key.add(key);
			this.value.add(value);
		}else {
			this.value.add(index, value);
			this.value.remove(index+1);
		}
	}
	
	public boolean remove(Integer key) {
		int index = this.key.indexOf(key);
		if(index!=-1) {
			this.key.remove(index);
			this.value.remove(index);
			return true;
		}
		return false;
	}
	
	public static boolean buscaBinaria(Integer key) {
//		array[indice]="";
//		
//		do{
//			meio=(ini+fim)/2;
//			if(a.compareTo(array[meio])<0)
//				fim=meio-1;
//			else if(a.compareTo(array[meio])>0)
//				ini=meio+1;
//			else 
//				flag=1;
//		}while(flag!=1&&ini<fim);
//		
//		array[indice]=a;
//		
//		if(flag==1)
//			return true;
//		return false;
	}
	
	public static boolean buscaSequencial(Integer a) {
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
	
	@Override
	public String toString() {
		String str="";
		for (Integer n : key) {
			str+=n+" - ";
		}
		return str;
	}
	
	
	
	
	
	
//	public static List<Integer> criaNumeros(int num,int rep) {
//		Random rd = new Random();
//		List<Integer> numeros = new LinkedList<Integer>();
//		int cont=0;
//		double valor=num*Math.pow(2, rep);
//		while(cont<valor-1) {
//			Integer numero = rd.nextInt();
//			if(numeros.contains(numero)) {
//				numeros.add(numero);
//			}else {
//				numeros.add(numero);
//				cont++;
//			}
//		}
//		return numeros;
//	}
//	
//	public static boolean buscaBinaria(Integer a,  array) {
//		int ini = 0, fim = array.length-1;
//		int meio,flag=0;
//		array[indice]="";
//		
//		do{
//			meio=(ini+fim)/2;
//			if(a.compareTo(array[meio])<0)
//				fim=meio-1;
//			else if(a.compareTo(array[meio])>0)
//				ini=meio+1;
//			else 
//				flag=1;
//		}while(flag!=1&&ini<fim);
//		
//		array[indice]=a;
//		
//		if(flag==1)
//			return true;
//		return false;
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		
//		do {
//			int escolha = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n1 - Fazer experimento\n0 - Sair"));
//			if(escolha!=1)
//				break;
//			int num = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero de chaves desejado:"));
//			int repeticoes = Integer.parseInt(JOptionPane.showInputDialog("Quantas repetições você deseja realizar?"));
//			int busca = Integer.parseInt(JOptionPane.showInputDialog("Busca:\n1 - Sequencial\n2 - Binária"));
//			switch (busca) {
//			case 1:
//				List<Integer> numeros = criaNumeros(num,repeticoes);
//				
//				
//				break;
//			case 2:
//				
//				
//				break;	
//			default:
//				break;
//			}
//			
//		}while(true);
//	}
}
