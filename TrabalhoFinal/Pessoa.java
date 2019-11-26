package collections;

public class Pessoa implements Comparable {
	private String nome;
	private int prioridade;
	public Pessoa(String nome, int prioridade) {
		this.nome = nome;
		this.prioridade = prioridade;
	}
	public String getNome() {
		return nome;
	}

	public int getPrioridade() {
		return prioridade;
	}
	
	@Override
	public int compareTo(Object o) {
		return prioridade - ((Pessoa) o).prioridade;
	}
}
