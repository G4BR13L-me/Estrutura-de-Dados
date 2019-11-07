package br.ufpi.ed;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Principal extends JFrame{

	public Principal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Grafico");
		setSize(700, 500);
		setLocationRelativeTo(null);
		
		if(tempoBinaria != null) criarBinaria();
		else criarSequencial();
		setVisible(true);
	}

	public static void experimentoBS(int num) {
		BuscaSequencialTS<Integer, Integer> tsBS = new BuscaSequencialTS<Integer, Integer>();
		tsBS.preencher(num);
		Integer[] chavesBS = tsBS.retornaVetor();
		Integer aux;
		for(int i=0; i<10; i++) {
			for(int j=0; j<num; j++) {
				aux = tsBS.get(chavesBS[j]);
			}
		}
		for(int i=0; i<10; i++) {
			aux = tsBS.get(chavesBS[num]);
		}
	}
	
	public static void experimentoBB(int num) {
		BuscaBinariaTS<Integer, Integer> tsBB = new BuscaBinariaTS<Integer, Integer>(num);
		tsBB.preencher(num);
		Integer[] chavesBB = tsBB.getChaves();
		Integer aux;
		for(int i=0; i<10; i++) {
			for(int j=0; j<num; j++) {
				aux = tsBB.get(chavesBB[j]);
			}
		}
		for(int i=0; i<10; i++) {
			aux = tsBB.get(chavesBB[num]);
		}
	}
	
	public static int n, nInicial,  rep;
	private static double[] tempoBinaria,tempoSequencial;
	
	public void criarBinaria() {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		n = nInicial;
		for(int i=0; i<rep; i++) {
			barra.setValue(tempoBinaria[i], "N ="+n, "");
			n = n*2;
		}
		JFreeChart grafico = ChartFactory.createBarChart3D("Teste de Desempenho","Valor de N","Tempo de Execução (segundos)",barra,PlotOrientation.VERTICAL,true,true,false);
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}
	
	public void criarSequencial() {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		n = nInicial;
		for(int i=0; i<rep; i++) {
			barra.setValue(tempoSequencial[i], "N ="+n, "");
			n = n*2;
		}
		JFreeChart grafico = ChartFactory.createBarChart3D("Teste de Desempenho","Valor de N","Tempo de Execução (segundos)",barra,PlotOrientation.VERTICAL,true,true,false);
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}
	
	public static void main(String[] args) {
		String op1 = JOptionPane.showInputDialog("Quantas chaves devem ser inseridas na tabela?");
		nInicial = Integer.parseInt(op1);
		String op2 = JOptionPane.showInputDialog("Quantas vezes o experimento deve se repetir?");
		rep = Integer.parseInt(op2);
		tempoBinaria = new double[rep];
		tempoSequencial = new double[rep];
		String[] options = new String[] {"Busca Binaria", "Busca Sequencial"};
		int resposta = JOptionPane.showOptionDialog(null, "Selecione um dos tipos de busca a ser usado na tabela", "MENU",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		
		boolean flag = true;
		
		switch(resposta) {
		case 0:
			n = nInicial;
			for(int i=0; i<rep; i++) {
				Stopwatch tempo = new Stopwatch();
				experimentoBB(n);
				tempoBinaria[i] = tempo.elapsedTime();
				n=2*n;
			}
			break;
		case 1:
			n = nInicial;
			for(int i=0; i<rep; i++) {
				Stopwatch tempo = new Stopwatch();
				experimentoBB(n);
				tempoSequencial[i] = tempo.elapsedTime();
				n=2*n;
			}
			break;
		default:
			flag = false;
			break;
		}
		if(flag)
			new Principal();
	}
}
