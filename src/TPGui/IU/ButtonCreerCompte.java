package TPGui.IU;

import java.io.IOException;

import GestionCabinetOrthophonie.Compte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ButtonCreerCompte {
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Compte compte = Compte.getInstance();

    @FXML
    private TextField adresseEmailField;

    @FXML
    private TextField adresseField;

    @FXML
    private Button bouttonCreerNewCompte;

    @FXML
    private TextField motDePasseField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField numTelField;

    @FXML
    private TextField prenomField;

    @FXML
    void creerNewCompte(ActionEvent event) {
    	compte.creerCompte(nomField.getText(), prenomField.getText(), adresseField.getText(),
    			numTelField.getText(), adresseEmailField.getText(), motDePasseField.getText());
    	System.out.println(compte.getNom());
    	System.out.println(compte.getPrenom());
    	System.out.println(compte.getAdresse());
    	System.out.println(compte.getNumeroDeTelephone());
    	System.out.println(compte.getAdresseEmail());
    	System.out.println(compte.getMotDePasse());
    	compte.enregistrerDansFichier("InfoOrthophoniste.txt");
    	compte.creerAgenda();
        compte.creerListeDossiers();
    }

    @FXML
    void switchToScene1(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("InterfaceTP.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,600,400);
   	    stage.setScene(scene);
   	    stage.show();

    }

}
