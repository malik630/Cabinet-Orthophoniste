package TPGui.IU;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import GestionCabinetOrthophonie.FicheSuivi;
import GestionCabinetOrthophonie.Objectif;
import GestionCabinetOrthophonie.TypeObjectif;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FicheController implements Initializable{

	 @FXML
	 private Label label1;

	 @FXML
	 private Label label2;

	 @FXML
	 private TextField nomObjectif;

	 @FXML
	 private ChoiceBox<String> noteObjectifs;

	 @FXML
	 private ChoiceBox<String> typeObjectif;

	 private String[] typeO = {"Court", "Moyen", "Long"};

	 private String[] note = {"1", "2", "3", "4", "5"};

	 private String type;

	 private String not;

	 private Stage stage;

	 private Scene scene;

	 private Parent root;

	 private boolean atteint;

	 private TypeObjectif typ;

	 private FicheSuivi fiche = new FicheSuivi();

	 private Set<Objectif> listObjectifs = new HashSet<>();


	 @Override
	 public void initialize(URL arg0, ResourceBundle arg1){
		    typeObjectif.getItems().addAll(typeO);
	    	typeObjectif.setOnAction(this::getTypeObjectif);
	    	noteObjectifs.getItems().addAll(note);
	    	noteObjectifs.setOnAction(this::getNote);
	 }

	 @FXML
	 void switchToScene6(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Seance.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	scene = new Scene(root,700,400);
	   	stage.setScene(scene);
	   	stage.show();
	 }

	 public void getNote(ActionEvent event){
		 not = noteObjectifs.getValue();
		 label2.setVisible(false);
	 }

	 public void getTypeObjectif(ActionEvent event){
		 type = typeObjectif.getValue();
		 label1.setVisible(false);

	 }

	 @FXML
	 public void objectifAtteint(ActionEvent event){
		 atteint = true;
	 }

	 @FXML
	 public void annuler(ActionEvent event){
		 atteint = false;
	 }

	 @FXML
	 public void ajouterObjectif(ActionEvent event){
		 if(type.equals("Court")){
			 typ = TypeObjectif.COURT;
		 }
		 Objectif objectif = new Objectif(nomObjectif.getText(), typ);
		 listObjectifs.add(objectif);
		 fiche.ajouterObjectif(objectif);
	 }

	 @FXML
	public void confirmer(ActionEvent event){
		fiche.setScore(not);
		if(atteint){
			fiche.setObjectifAtteint(atteint);
			fiche = new FicheSuivi();
		}

	}

}
