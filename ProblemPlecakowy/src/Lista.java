import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Lista {

	List<List<Integer>> listaDanych = new ArrayList<List<Integer>>();
	public List<List<Integer>> getListaDanych() {
		return listaDanych;
	}

	public void setListaDanych(List<List<Integer>> listaDanych) {
		this.listaDanych = listaDanych;
	}
	//ArrayList<Dana> listaDanych = new ArrayList<>();
	int pojemnoscPlecaka;
	int liczbaPrzedmiotow = 0;

	public Lista(String path) throws IOException {
		
		int iteracja = 1;
		
		BufferedReader reader = new BufferedReader(new FileReader(path));
		pojemnoscPlecaka = Integer.parseInt(reader.readLine()); 
		 String[] dane = null;
		 String line1=null;
		 while ((line1 = reader.readLine()) != null){
			 List<Integer> list = new ArrayList<>();
			 liczbaPrzedmiotow++;
			 int wartosc;
				int wagaPrzedmiotu;
				dane = line1.split(" ");
				list.add(Integer.parseInt(dane[1]));		
				list.add(Integer.parseInt(dane[0]));
				listaDanych.add(list);
			
				iteracja++;
		 }
		 
		 reader.close();
		 

	}
	
	public int getLiczbaPrzedmiotow() {
		return liczbaPrzedmiotow;
	}
	public void setLiczbaPrzedmiotow(int liczbaPrzedmiotow) {
		this.liczbaPrzedmiotow = liczbaPrzedmiotow;
	}
	public int getPojemnoscPlecaka() {
		return pojemnoscPlecaka;
	}
	public void setPojemnoscPlecaka(int pojemnoscPlecaka) {
		this.pojemnoscPlecaka = pojemnoscPlecaka;
	}
//	public String toString() {
//		System.out.println("pojemnosc plecaka: "+ getPojemnoscPlecaka());
//		System.out.println("liczba przedmiotow: "+ getLiczbaPrzedmiotow());
//		for(int r = 0; r<listaDanych.size();r++) {
//			System.out.println(listaDanych.get(r).wartosc + " " + listaDanych.get(r).wagaPrzedmiotu);
//		}
//		return null;
//	}
}
