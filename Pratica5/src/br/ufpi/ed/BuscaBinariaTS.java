package br.ufpi.ed;

import java.util.Random;

public class BuscaBinariaTS<Key extends Comparable<Key>, Value> {
	private static final int TAM_INICIAL = 2;
	
	private Value[] valores;
	private Key[] chaves;
	private int n = 0;
	
	public BuscaBinariaTS(int tamInicial) {
		valores = (Value[]) new Object[tamInicial];
		chaves = (Key[]) new Comparable[tamInicial];
	}
	
	public BuscaBinariaTS() {
		this(TAM_INICIAL);
	}
	
	public boolean isEmpty() {
		return n==0;
	}
	
	public int size() {
		return n;
	}
	
	private void resize(int capacidade) {
		Key[] tempChaves = (Key[]) new Comparable[capacidade];
		Value[] tempValores = (Value[]) new Object[capacidade];
		for(int i = 0; i<n; i++) {
			tempValores[i] = valores[i];
			tempChaves[i] = chaves[i];
		}
		chaves = tempChaves;
		valores = tempValores;
	}
	
	public void put(Key chave, Value valor) {
		if(n>=valores.length) resize(2*n);
		if(contem(chave)) {
			int i = bBinaria(chave);
			valores[i] = valor;
			return;
		}
		
		int i = n;
		while((i>0) && (chave.compareTo(chaves[i-1]) < 0)) {
			chaves[i] = chaves[i-1];
			valores[i] = valores[i-1];
			i--;
		}
		valores[i] = valor;
		chaves[i] = chave;
		n++;
	}
	
	public void remove(Key chave) {
		if(isEmpty()) return;
		int indice = -1;
		for(int i=0; i<n; i++) {
			if(chaves[i].compareTo(chave)==0) {
				indice = i;
			}
		}
		if(indice==-1) return;
		for(int j=indice; j<n-1; j++) {
			chaves[j] = chaves[j+1];
			valores[j] = valores[j+1];
		}
		n--;
		chaves[n] = null;
		valores[n] = null;
		
		if(n>0 && n==chaves.length/4) resize(chaves.length/2);
	}

	public boolean contem(Key chave) {
		int i = bBinaria(chave);
		return i >= 0;
	}
	
	public Value get(Key chave) {
		int i = bBinaria(chave);
		if(i == -1) return null;
		return valores[i];
	}
	
	private int bBinaria(Key chave) {
		int lo = 0;
		int hi = n-1;
		while(lo<=hi) {
			int mid = lo + (hi - lo)/2;
			int cmp = chave.compareTo(chaves[mid]);
			if(cmp<0) hi = mid-1;
			else if(cmp>0) lo = mid+1;
			else return mid;
		}
		return -1;
	}
	
	public BuscaBinariaTS<Integer, Integer> preencher(int n){
		Random rd = new Random();
		int chave;
		BuscaBinariaTS<Integer, Integer> ts = new BuscaBinariaTS<Integer, Integer>(n);
		for(int i=0; i<n; i++) {
			do {
				chave = rd.nextInt(n);
			}while(ts.contem(chave));
			ts.put(chave, i);
		}
		return ts;
	}

	public Key[] getChaves() {
		return chaves;
	}
}
