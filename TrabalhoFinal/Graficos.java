package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



public class Graficos extends JFrame {
	
	public Graficos(String[] arquivo, int ID) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Grafico");
		setSize(700, 500);
		setLocationRelativeTo(null);
		
		setTempos(arquivo);
		if(ID==1) criarInsercao();
		else if(ID==2) criarBusca();
		else criarRemocao();
		setVisible(true);
	}
	
	private double[] tempoBusca = new double[9];
	private double[] tempoInser = new double[9];
	private double[] tempoRemo = new double[9];
	
	private void setTempos(String[] arquivo) {
		// <palavras> guarda o conjunto de palavras utilizado para o experimento
		List<String> palavras = new LinkedList<>();
		palavras.add("Lisbon");
		palavras.add("NASA");
		palavras.add("Kyunghee");
		palavras.add("Konkuk");
		palavras.add("Sogang");
		palavras.add("momentarily");
		palavras.add("rubella");
		palavras.add("vaccinations");
		palavras.add("government");
		palavras.add("Authorities");
		
		//inicialização das estruturas de dados
		Vector<String> v = new Vector<String>();
		LinkedList<String> l = new LinkedList<String>();
		ArrayList<String> a = new ArrayList<String>();
		HashSet<String> hS = new HashSet<String>();
		LinkedHashSet<String> lS = new LinkedHashSet<String>();
		TreeSet<String> tS = new TreeSet<String>();
		HashMap<String,Integer> hM = new HashMap<String,Integer>();
		LinkedHashMap<String,Integer> lM = new LinkedHashMap<String,Integer>();
		TreeMap<String,Integer> tM = new TreeMap<String,Integer>();
		
		
		/*
		 * Preenche todas as estruturas de dados com 
		 *             o <arquivo>
		 *             (Inserção) 
		 */
		long timer = System.nanoTime();
		for (String palavra : palavras) {
			v.add(palavra);
		}
		tempoInser[0] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			l.add(palavra);
		}
		tempoInser[1] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			a.add(palavra);
		}
		tempoInser[2] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			hS.add(palavra);
		}
		tempoInser[3] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			lS.add(palavra);
		}
		tempoInser[4] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			tS.add(palavra);
		}
		tempoInser[5] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			hM.put(palavra,0);
		}
		tempoInser[6] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			lM.put(palavra,0);
		}
		tempoInser[7] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			tM.put(palavra,0);
		}
		tempoInser[8] = System.nanoTime() - timer;
		
		//
		//>>Conjuntos de for para calcular o tempo de busca
		//
		for (String palavra : palavras) {
			v.contains(palavra);
		}
		tempoBusca[0] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			l.contains(palavra);
		}
		tempoBusca[1] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			a.contains(palavra);
		}
		tempoBusca[2] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			hS.contains(palavra);
		}
		tempoBusca[3] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			lS.contains(palavra);
		}
		tempoBusca[4] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			tS.contains(palavra);
		}
		tempoBusca[5] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			hM.containsKey(palavra);
		}
		tempoBusca[6] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			lM.containsKey(palavra);
		}
		tempoBusca[7] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			tM.containsKey(palavra);
		}
		tempoBusca[8] = System.nanoTime() - timer;
		
		//
		//>>Conjuntos de for para calcular o tempo de remocao
		//
		for (String palavra : palavras) {
			v.remove(palavra);
		}
		tempoRemo[0] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			l.remove(palavra);
		}
		tempoRemo[1] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			a.remove(palavra);
		}
		tempoRemo[2] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			hS.remove(palavra);
		}
		tempoRemo[3] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			lS.remove(palavra);
		}
		tempoRemo[4] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			tS.remove(palavra);
		}
		tempoRemo[5] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			hM.remove(palavra);
		}
		tempoRemo[6] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			lM.remove(palavra);
		}
		tempoRemo[7] = System.nanoTime() - timer;
		
		timer = System.nanoTime();
		for (String palavra : palavras) {
			tM.remove(palavra);
		}
		tempoRemo[8] = System.nanoTime() - timer;
		
	}
	
	private void criarBusca() {//>Cria grafico para busca
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		String[] collections = {"Vector","LinkedList","ArrayList"
				,"HashSet","LinkedHashSet","TreeSet"
				,"HashMap","LinkedHashMap","TreeMap"};
		for(int i=0; i<tempoBusca.length; i++) {
			//o valor é convertido de nanosegundos para milisegundos
			//por meio da divisão por 1000000
			barra.setValue(tempoBusca[i]/1000000, collections[i], "");
		}
		JFreeChart grafico = ChartFactory.createBarChart3D("Busca","Valor de N","Tempo de Execução (milisegundos)",barra,PlotOrientation.VERTICAL,true,true,false);
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}
	
	private void criarRemocao() {//>Cria grafico para remocao
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		String[] collections = {"Vector","LinkedList","ArrayList"
				,"HashSet","LinkedHashSet","TreeSet"
				,"HashMap","LinkedHashMap","TreeMap"};
		for(int i=0; i<tempoRemo.length; i++) {
			barra.setValue(tempoRemo[i]/1000000, collections[i], "");
		}
		JFreeChart grafico = ChartFactory.createBarChart3D("Remoção","Valor de N","Tempo de Execução (milisegundos)",barra,PlotOrientation.VERTICAL,true,true,false);
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}

	private void criarInsercao() {//>Cria grafico para insercao
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		String[] collections = {"Vector","LinkedList","ArrayList"
				,"HashSet","LinkedHashSet","TreeSet"
				,"HashMap","LinkedHashMap","TreeMap"};
		for(int i=0; i<tempoInser.length; i++) {
			barra.setValue(tempoInser[i]/1000000,collections[i] , "");
		}
		JFreeChart grafico = ChartFactory.createBarChart3D("Inserção","Valor de N","Tempo de Execução (milisegundos)",barra,PlotOrientation.VERTICAL,true,true,false);
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}
	
}
