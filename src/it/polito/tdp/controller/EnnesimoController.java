package it.polito.tdp.controller;
import java.net.URL;
//import java.util.LinkedList;
//import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class EnnesimoController {	
	
	private Model model = new Model();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private CheckBox ch1ParolaNonPresente;

    @FXML
    private CheckBox ch2ParolaAccettata;

    @FXML
    private CheckBox ch3ParolaNonLegata;

    @FXML
    private CheckBox ch4ParolaGiaInserita;

    @FXML
    private TextField txtTotale;
    
    public void setModel(Model model) {
		this.model = model;
	}
    
    public Model getModel() {
		return model;
	}

    @FXML
    void doInserisci(ActionEvent event) {
    	String s = txtParola.getText();
    	if(s.isEmpty()){
    		return ;
    	}
    	for(int i =0; i<s.length(); i++){
    		if(!Character.isLetter(s.charAt(i))){
    			return;
    		}
    	}
   
    	if(model.parolaAccettata(s)){                         //se la parola s è accettata
    		model.aggiungiParola(s);                              //allora la aggiunge (il metodo nel model controlla nuovamente se non è presente il lista
    		                                                //in teoria questo controllo non servirebbe xke fa gia tutto parolaAccettata(s)
    		                                               //ma non dovrebbe causare problemi, giusto?
    
    		int totaleParole = model.totale();                   //ritorna il numero di elementi presenti in lista
    		txtTotale.setText(String.valueOf(totaleParole));
    		ch2ParolaAccettata.setSelected(true);	
    		ch3ParolaNonLegata.setSelected(false);
    		ch4ParolaGiaInserita.setSelected(false);
    		ch1ParolaNonPresente.setSelected(false);	
    	}
    	if(model.parolaNonLegata(s)){                            //pero se metto una parola con piu di 2 lettere uguali, non la accetta
    		ch3ParolaNonLegata.setSelected(true);
            ch2ParolaAccettata.setSelected(false);
    		ch4ParolaGiaInserita.setSelected(false);
    		ch1ParolaNonPresente.setSelected(false);
    	}
    	if(model.parolaPresente(s)){
    		ch4ParolaGiaInserita.setSelected(true);
            ch3ParolaNonLegata.setSelected(false);
            ch2ParolaAccettata.setSelected(false);
    		ch1ParolaNonPresente.setSelected(false);
    	}
    	/*if(model.parolaDB(s)){                   
    		ch1ParolaNonPresente.setSelected(false);      
    		ch4ParolaGiaInserita.setSelected(false);
            ch3ParolaNonLegata.setSelected(false);
            ch2ParolaAccettata.setSelected(false); 		
    	}*/
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Ennesimo.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Ennesimo.fxml'.";
        assert ch1ParolaNonPresente != null : "fx:id=\"ch1ParolaNonPresente\" was not injected: check your FXML file 'Ennesimo.fxml'.";
        assert ch2ParolaAccettata != null : "fx:id=\"ch2ParolaAccettata\" was not injected: check your FXML file 'Ennesimo.fxml'.";
        assert ch3ParolaNonLegata != null : "fx:id=\"ch3ParolaNonLegata\" was not injected: check your FXML file 'Ennesimo.fxml'.";
        assert ch4ParolaGiaInserita != null : "fx:id=\"ch4ParolaGiaInserita\" was not injected: check your FXML file 'Ennesimo.fxml'.";
        assert txtTotale != null : "fx:id=\"txtTotale\" was not injected: check your FXML file 'Ennesimo.fxml'.";
    }
}