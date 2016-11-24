package it.polito.tdp.model;
import java.util.LinkedList;
import java.util.List;

public class Model {
	private List<String> parole = new LinkedList<String>();
	
/*	public void addParola(String parolaNuova){
		if(!parole.contains(parolaNuova))                    
			parole.add(parolaNuova);
	}
	*/
	
	/*public boolean parolaPresente (String parolaNuova){
		if(parole.contains(parolaNuova)){
			return true;
		}
		else return false;
	}*/
	
	public void aggiungiParola(String parolaNuova){
		if(parolaAccettata(parolaNuova)){
			parole.add(parolaNuova);
		}
	}
	
	public boolean parolaAccettata(String parolaNuova){               //ok
		boolean presente = parolaPresente(parolaNuova);
		boolean nonLegata = parolaNonLegata(parolaNuova);
		if(!presente && !nonLegata ){                          //se non è presente e se è legata                     
			System.out.println(true);
		    return true;
		}
		else 
			System.out.println(false);
		    return false;	
	}
	
	//pero non accetta una parola ke ha piu di 2 lettere uguali
	
	public boolean parolaNonLegata(String parolaNuova){                  //ok
	  if(!parole.isEmpty()){	                                                     //se la lista non è vuota
	     String ultimaParola = parole.get(parole.size()-1);                         //ultima parola      //ok
	     String ultimeLettere =ultimaParola.substring(ultimaParola.length()-2, ultimaParola.length());         //ultime 2 lettere   //ok
	     String primeLettere = parolaNuova.substring(0,2);                                                    //prime 2 lettere    //ok
	       if(ultimeLettere.equals(primeLettere)){   
			     System.out.println(false);                   //sono legate
				    return  false;
			       }
			        else{
				             System.out.println(true);           //non sono legate
			                 return true;
		                 }
		   }
	   if(parole.isEmpty())                      //se la lista è vuota 
		   System.out.println(false);	        //xke la devo accettare
		   return false;
		   
	}
	
	/*public boolean parolaDB(String parolaNuova){
		return false;
	}
	*/
	
	public boolean parolaPresente(String parolaNuova){      //ok
		if(!parole.isEmpty()){
			if(parole.contains(parolaNuova)){
				System.out.println(true);
				return true;
				}
			else 
				System.out.println(false);
				return false;
		}
		System.out.println(false);
		return false;
	}
	
	public int totale(){
		int tot=0;
		tot= parole.size();
		System.out.println(tot);
		return tot;
	}
	
	public void stampaParole(){
		System.out.println(parole);
	}
}
