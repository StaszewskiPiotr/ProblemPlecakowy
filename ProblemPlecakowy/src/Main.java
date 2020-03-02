import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		Lista lista = new Lista("11");
		knapSack(lista);
		long endTime   = System.nanoTime();
		long totalTime = TimeUnit.MINUTES.convert(endTime - startTime, TimeUnit.NANOSECONDS);
		System.out.println("Czas działania programu: " + totalTime + " minuty");
	}
	

	
	public static String intToBinary(int n)
	{
	    String s = "";
	    while (n > 0)
	    {
	        s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
	        n = n / 2;
	    }
	    return s;
	}
	
	public static void knapSack(Lista lista) {
			
		List<List<Integer>> list = lista.getListaDanych();
		List<String> listaPobranych = new ArrayList<>();
		
		String bin;
		int xx=(int) Math.pow(2,list.size());
		
		int iteracja = 0;
		
		int maxWartosc=0;		
		int maxWaga=0;
				
		for(int i=0;i<xx;i++) {
			int dana = 0;
			
			bin=intToBinary(i); 
			
			int itemsWartosc=0;
			int itemsWaga=0;
			
			int różnica=list.size()-bin.length();
			
			for(int j=bin.length()-1;j>=0;j--) {
				
				char b=bin.charAt(j);
				if(b=='1') {
					dana = j + różnica;
					itemsWartosc+=list.get(j + różnica).get(1);
					itemsWaga+=list.get(j + różnica).get(0);
				}
			}
			if(itemsWaga<=lista.getPojemnoscPlecaka()) {
				
				if(itemsWartosc>maxWartosc) {
					listaPobranych.clear();
					listaPobranych.add(bin);
					maxWartosc=itemsWartosc;
					maxWaga=itemsWaga;
				}
			}
			iteracja++;
		}

		System.out.println(listaPobranych.get(listaPobranych.size()-1).toString());
		System.out.println("Suma wartości = "+maxWartosc);
		System.out.println("Suma wag = "+maxWaga);
		
	}
}

