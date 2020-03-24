package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

/**
 * Contiene tutte le parole in lingua italiana e inglese
 * @author lupog
 *
 */
	public class Dizionario {		

		List<String> dizionario = new LinkedList<String>(); 
		
		//List<Parola>parole = new LinkedList<Parola>();				
		
		
		String tempo="";
	
		public void loadDictionary (String language) {
			//this.dizionario.clear();
			
				try {
					FileReader fr = new FileReader("src/main/resources/"+language+".txt");
					BufferedReader br = new BufferedReader(fr);
					String word;
					while((word = br.readLine()) != null){
						this.dizionario.add(word);
					}
					br.close();
				}catch(IOException e) {
				System.out.println("Errore nella lettura del file");
				}	
			}
				
		public List<String> ordineInput (String stringa){
			List<String> paroleInput = new LinkedList<String>();
			stringa.replaceAll("[.,\\/#!$&\\*;:{}-\\-'=()\\[\\]\"]", "");
			String[] array = stringa.split(" ");
			for(int i=0; i<array.length; i++) {
				paroleInput.add(array[i]);
			}
			return paroleInput;
		}
		
		
		/**
		 * cerca la parola nel dizionario 
		 * @param parola
		 * @return restituisce la parola se trovata, quindi corretta
		 */
		public String cercaParola(String parola) {
			for (String si : this.dizionario) {
				if(si.compareTo(parola)==0) 
					return si;				
			}
			return null;
		}
		
		
		public List<String> spellCheckText(List<String> nuova){
			
			double start= System.nanoTime();
			List<String> sbagliate = new LinkedList<String>();
									
			for(String s : nuova) {	
				if(!this.dizionario.contains(s)) {
						sbagliate.add(s);
						}							
			}
			double stop= System.nanoTime();
	    	tempo = ""+(stop-start)+"\n";
			return sbagliate;			
		}
		
		
		public String tempo() {
			return "Spell check completed in "+this.tempo+" seconds";
		}
		
	
		
		

}
