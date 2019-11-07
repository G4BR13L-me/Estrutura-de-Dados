package br.ufpi.ed;

import java.util.Random;

public class BuscaSequencialTS<Key, Value> {
	private int n;
	private Node inicio;
	
	private class Node{
		private Key chave;
		private Value valor;
		private Node prox;
		
		public Node(Key chave, Value valor, Node prox) {
			this.chave = chave;
			this.valor = valor;
			this.prox = prox;
		}
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean contem(Key chave) {
		for(Node x=inicio; x!=null; x=x.prox)
			if(chave.equals(x.chave)) return true;
		return false;
	}
	
	public void put(Key chave, Value valor) {
		if(chave==null) return;
		if(valor==null) {
			remove(chave);
			return;
		}
		for(Node x=inicio; x!=null; x=x.prox) {
			if(chave.equals(x.chave)) {
				x.valor = valor;
				return;
			}
		}
		inicio = new Node(chave, valor, inicio);
		n++;
	}
	
	public Value remove(Key chave) {
		if(inicio==null) return null;
		if(chave.equals(inicio.chave)) {
			Value val = inicio.valor;
			inicio = inicio.prox;
			n--;
			return val;
		}
		for(Node x=inicio; x.prox!=null; x=x.prox) {
			if(chave.equals(x.prox.chave)) {
				Value val = x.prox.valor;
				x.prox = x.prox.prox;
				n--;
				return val;
			}
		}
		return null;
	}
	
	public Value get(Key chave) {
		for(Node x=inicio; x!=null; x=x.prox) {
			if(chave.equals(x.chave)) return x.valor;
		}
		return null;
	}
	
	public BuscaSequencialTS<Integer, Integer> preencher(int n) {
		Random rd = new Random();
		int chave;
		BuscaSequencialTS<Integer, Integer> ts = new BuscaSequencialTS<Integer, Integer>();
		for(int i=0; i<n; i++) {
			do {
				chave = rd.nextInt(n);
			}while(ts.contem(chave));
			ts.put(chave, i);
		}
		return ts;
	}
	
	public Key[] retornaVetor() {
		Key[] novo = (Key[]) new Comparable[n];
		Node x = inicio;
		for(int i=0; i<n; i++) {
			novo[i] = x.chave;
			x=x.prox;
		}
		return novo;
	}
	
}
