package TPGui.IU;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BilanController implements Initializable{

	 @FXML
	 private TextField nomTrouble;

	 @FXML
	 private ChoiceBox<String> troubleCat;

	 private String[] troubles = {"Déglutition", "Neuro-Développement", "Cognitif"};

	 private Stage stage;

	private Scene scene;

	private Parent root;

	 @Override
	 public void initialize(URL arg0, ResourceBundle arg1){
	      troubleCat.getItems().addAll(troubles);
	      troubleCat.setOnAction(this::getTrouble);
	 }

	 @FXML
	 public void getTrouble(ActionEvent event){

	 }

	 @FXML
	 void switchToScene(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("Seance.fxml"));
	   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	    scene = new Scene(root,700,400);
	   	    stage.setScene(scene);
	   	    stage.show();
	 }

}
