package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dizionario;
import it.polito.tdp.spellchecker.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	

	List<String> lista = new LinkedList<String>();
	private Dizionario diz;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> language;

    @FXML
    private TextField txtResult;

    @FXML
    private Button btnCheck;

    @FXML
    private TextArea txtControl;

    @FXML
    private Label lblError;

    @FXML
    private Button btnReset;

    @FXML
    private Label lblTempo;
    
    public void insertLanguage() {
    	lista.removeAll(lista);    	
    	lista.add(new String("Italian"));
    	lista.add(new String("English"));
    	language.getItems().addAll(lista);
    }

    @FXML
    void doControl(ActionEvent event) {
    	diz.loadDictionary(language.getSelectionModel().getSelectedItem()); //Carico il dizionario corretto
    	
    	String s = this.txtResult.getText().toLowerCase();    	    	
    	List<String> correzione = this.diz.ordineInput(s);
    	List<String> definitiva = this.diz.spellCheckText(correzione);
    	
    	if(definitiva != null) {
    		String elencoErrori = "";
    		for(String si : definitiva) {
    			elencoErrori += si+"\n";
    		}
    		this.txtControl.setText(elencoErrori);
        	this.lblError.setText("The text conteins"+definitiva.size()+" errors");
        	this.lblTempo.setText(this.diz.tempo());
        	return;
    	}
    	else {
        	this.lblError.setText("The text conteins 0 errors");
    	}   	
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtControl.clear();
    	txtResult.clear();
    }

    @FXML
    void initialize() {
        assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtControl != null : "fx:id=\"txtControl\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblError != null : "fx:id=\"lblError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblTempo != null : "fx:id=\"lblTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        insertLanguage();
    }

	public void setDizionario(Dizionario dizionario) {
		this.diz = dizionario;
		
	}
}
