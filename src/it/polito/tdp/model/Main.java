package it.polito.tdp.model;

public class Main {

	public static void main(String[] args) {
		Model m = new Model();		
		String s1 = "casa";
		String s2 = "home";
		String s3 = "light";
		String s4 = "abaco";
		String s5 = "prova";
		String s6 = "vapore";
		String s7 = "luppolo";
		String s8 = "love";		
		m.addParola(s1);
		m.addParola(s2);
		m.addParola(s3);
		m.addParola(s4);
		m.addParola(s5);
		m.addParola(s6);
		m.addParola(s7);
		
		m.stampaParole();	
		 //m.parolaNonLegata(s4);	
		//m.totale();
		m.parolaAccettata(s8);

	}

}
