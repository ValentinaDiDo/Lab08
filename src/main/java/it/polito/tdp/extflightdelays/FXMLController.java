/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.extflightdelays.model.Connessioni;
import it.polito.tdp.extflightdelays.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="distanzaMinima"
    private TextField distanzaMinima; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizza"
    private Button btnAnalizza; // Value injected by FXMLLoader

    @FXML
    void doAnalizzaAeroporti(ActionEvent event) {
    	model.attivaModel();
    	String s = distanzaMinima.getText();
    	int dMin = Integer.parseInt(s);
    
    	model.creaGrafo(dMin);
    	
    	int vertici = model.numeroVerticiGrafo();
    	int archi = model.numeroArchiGrafo();
    	List<Connessioni> connessioni = model.getAllConnessioni();
    	
    	txtResult.setText("NUMERO VERTICI: "+vertici+"\nNUMERO ARCHI: "+archi);
    	
    	txtResult.appendText("\nCOPPIE DI AEROPORTI E RISPETTIVE DISTANZE: ");
    			
    	for(Connessioni c : connessioni) {
    		txtResult.appendText(c.getAeroportoPartenza()+" "+c.getAeroportoArrivo()+" "+c.getDistanza()+"\n");
    	//	System.out.println(c.getAeroportoPartenza()+" "+c.getAeroportoArrivo()+" "+c.getDistanza());
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert distanzaMinima != null : "fx:id=\"distanzaMinima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
