package it.polito.tdp.spellchecker;

import javafx.application.Application;
import static javafx.application.Application.launch;


import it.polito.tdp.spellchecker.model.Dizionario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	Dizionario dizionario = new Dizionario();
    	FXMLController controller; //variabile definita ma non valorizzata. Devo recuperare un riferimento al Controller
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
    	
    	Parent root = loader.load(); //FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));        		
        Scene scene = new Scene(root);
       // scene.getStylesheets().add("/styles/Styles.css"); POSSO CANCELLARLO
    	
    	controller = loader.getController(); //dal loader recupero il controller, FXML vede qual è il controller associato al file FXML
    	controller.setDizionario(dizionario);    	
    	
        
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
