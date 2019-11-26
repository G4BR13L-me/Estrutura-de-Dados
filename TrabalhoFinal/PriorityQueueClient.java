package collections;

import java.util.List;

import javax.swing.JOptionPane;
import java.util.PriorityQueue;

public class PriorityQueueClient {
	public static void main(String[] args) {
		PriorityQueue<Pessoa> fila = new PriorityQueue<Pessoa>();
		int contador=0;
		
		int escolha;
		boolean flag=true;
		do {
			escolha = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n1 - Entrar na fila normal"
					+ "\n2 - Entrar na fila com prioridade"
					+ "\n3 - Listar fila"
					+ "\n4 - Atender pedido"
					+ "\n0 - Sair"));
			switch (escolha) {
			case 1:
				String nome = JOptionPane.showInputDialog("Insira o nome:");
				fila.add(new Pessoa(nome,++contador));
				break;
			case 2:
				String nomePrioridade = JOptionPane.showInputDialog("Insira o nome:");
				fila.add(new Pessoa(nomePrioridade,0));
				break;
			case 3:
				if(fila.size()==0)
					JOptionPane.showMessageDialog(null, "Não há clientes na fila!");
				else {
					String pessoas="";
					for (Pessoa pessoa : fila) {
						pessoas += pessoa.getNome()+" - ";
					}
					JOptionPane.showMessageDialog(null,"Lista: "+pessoas);
				}
				break;
			case 4:
				if(fila.size()==0)
					JOptionPane.showMessageDialog(null, "Não há mais clientes na fila!");
				else {
					Pessoa p = fila.remove();
					JOptionPane.showMessageDialog(null, "Cliente "+p.getNome()+" atendido!");
				}
				break;
			default:
				if(fila.size()!=0)
					JOptionPane.showMessageDialog(null, "Demanda ainda não completamente atendida!");
				else
					flag = false
					;
			}
		}while(flag);
	}
}
