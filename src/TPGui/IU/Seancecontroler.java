package TPGui.IU;
import java.io.IOException;

import GestionCabinetOrthophonie.Compte;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;


public class Seancecontroler {
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Compte compte = Compte.getInstance();

    @FXML
    private Button fairedestests;

    @FXML
    void switchtotestscene(ActionEvent event)throws IOException {

        	Parent root = FXMLLoader.load(getClass().getResource("TestExcercice.fxml"));
       	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       	    scene = new Scene(root,600,400);
       	    stage.setScene(scene);
       	    stage.show();
    }
    @FXML
    void switchToAnam(ActionEvent event) throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("CreationAnamneses.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,600,400);
   	    stage.setScene(scene);
   	    stage.show();
    }

    @FXML
    void switchToTestEx(ActionEvent event)throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("TestExcercices.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,600,400);
   	    stage.setScene(scene);
   	    stage.show();
    }

    @FXML
    void switchToTestQst(ActionEvent event)throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("TestExcercice.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,600,400);
   	    stage.setScene(scene);
   	    stage.show();
    }

    @FXML
    void switchToScene3(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,600,400);
   	    stage.setScene(scene);
   	    stage.show();
    }



}
