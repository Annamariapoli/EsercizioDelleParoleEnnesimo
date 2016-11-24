package it.polito.tdp.model;
import java.util.LinkedList;
import java.util.List;

public class Model {
	private List<String> parole = new LinkedList<String>();
	
	public void addParola(String parolaNuova){
		if(!parole.contains(parolaNuova))                    
			parole.add(parolaNuova);
	}
	
	public boolean parolaPresente (String parolaNuova){
		if(parole.contains(parolaNuova)){
			return true;
		}
		else return false;
	}
	
	public boolean parolaAccettata(String parolaNuova){               //ok
		boolean presente = parolaPresente(parolaNuova);
		boolean nonLegata = parolaNonLegata(parolaNuova);
		if(!presente && !nonLegata ){
			parole.add(parolaNuova);
		                                          //se non è presente e se è legata
			System.out.println(true);
		    return true;
		}
		else 
			System.out.println(false);
		    return false;	
	}
	
	public boolean parolaNonLegata(String parolaNuova){                  //ok
	   if(!parole.isEmpty()){	                                  //se la lista non è vuota
		String ultimaParola = parole.get(parole.size()-1);                                                   //ultima parola      //ok
		String ultimeLettere =ultimaParola.substring(ultimaParola.length()-2, ultimaParola.length());       //ultime 2 lettere   //ok
		String primeLettere = parolaNuova.substring(0,2);                             //prime 2 lettere    //ok
	   //System.out.println(ultimaParola);
	   //System.out.println(ultimeLettere);
	   //System.out.println(primeLettere);	
		if(ultimeLettere.equals(primeLettere)){    //non sono legate
		//System.out.println(false);
			return false;
		   }
		
	   }
		
	return true;
	   	
	}
	
	/*public boolean parolaDB(String parolaNuova){
		return false;
	}
	*/
	
	
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
