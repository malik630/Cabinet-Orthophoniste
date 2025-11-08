package TPGui.IU;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import GestionCabinetOrthophonie.*;
import GestionCabinetOrthophonie.Dossier;
import GestionCabinetOrthophonie.Patient;
import GestionCabinetOrthophonie.PatientAdulte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.stage.Stage;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
    private Compte compte = Compte.getInstance();

    @FXML
    private Button BouttonSeConnecter;

    @FXML
    private TextField adresseEmailField;

    @FXML
    private Button bouttonCreerCompte;

    @FXML
    private TextField motDePasseField;

    @FXML
    void seConnecter(ActionEvent event) throws IOException {
    	compte.recupererDepuisFichier("InfoOrthophoniste.txt");
    	compte.creerAgenda();
    	compte.creerListeDossiers();
        boolean verif = compte.seConnecter(adresseEmailField.getText(), motDePasseField.getText());
    	if(verif){
    		switchToScene3(event);
    	}
    	else{
    		motDePasseIncorrect();
    	}
    }

    @FXML
    void switchToScene3(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,600,400);
   	    stage.setScene(scene);
   	    stage.show();
    }

    @FXML
    void switchToScene2(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("TP_POO.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,600,400);
   	    stage.setScene(scene);
   	    stage.show();
    }

    @FXML
    public void motDePasseIncorrect() {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Mot de passe ou adresse E-mail incorrect");
    	alert.setHeaderText(null);
    	alert.setContentText("le mot de passe ou l'adresse E-mail fourni est erroné ! "+ "Veuillez introduire les bonnes informations");
    	alert.showAndWait();

    }

}

