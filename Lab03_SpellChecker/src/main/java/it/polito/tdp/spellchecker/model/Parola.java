package it.polito.tdp.spellchecker.model;

import java.util.*;

public class Parola {

	private String parola;
	//private List<String> singola = new LinkedList<String>();
	private boolean corretta = false;
	
	
	public Parola(String parola, boolean corretta) {
		this.parola = parola;
		this.corretta = corretta;
	}


	/*public void addParola (String parola) {
		this.singola.add(parola);
	}*/


	public boolean isCorretta() {
		return corretta;
	}


	public String getParola() {
		return parola;
	}


	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}


	
	
	
	
	
}
