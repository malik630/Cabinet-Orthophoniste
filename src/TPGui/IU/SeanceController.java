package TPGui.IU;

import java.io.IOException;
import java.util.Iterator;

import GestionCabinetOrthophonie.Compte;
import GestionCabinetOrthophonie.Consultation;
import GestionCabinetOrthophonie.Dossier;
import GestionCabinetOrthophonie.Patient;
import GestionCabinetOrthophonie.PatientAdulte;
import GestionCabinetOrthophonie.PatientEnfant;
import GestionCabinetOrthophonie.RendezVous;
import GestionCabinetOrthophonie.SeanceDeSuivi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SeanceController {

	    @FXML
        private Button ajouterPatient;

	    @FXML
	    private DatePicker dateField;

	    @FXML
	    private Button ficheSuiviButton;

	    @FXML
	    private TextField heureField;

	    @FXML
	    private AnchorPane pane1;

	    @FXML
	    private AnchorPane pane2;

	    @FXML
	    private AnchorPane pane3;

	    @FXML
	    private AnchorPane pane4;

	    @FXML
	    private AnchorPane pane5;

	    @FXML
	    private TextField adresseField;

	    @FXML
	    private TextField classeEtudeField;

	    @FXML
	    private TextField dateDeNaissanceField;

	    @FXML
	    private TextField diplomeField;

	    @FXML
	    private TextField lieuNaissanceField;

	    @FXML
	    private TextField numParentField;

	    @FXML
	    private TextField numPersonnelField;

	    @FXML
	    private TextField professionField;

	    @FXML
	    private TextArea observationField;

	    @FXML
	    private Dossier dossier;

	    private String duree;

	    Compte compte = Compte.getInstance();

	    private Stage stage;

		private Scene scene;

		private Parent root;

		private Consultation consultation;

		private Patient patient;

	    @FXML
	    public void rechercherRDV(ActionEvent event){
	    	boolean verif = false;
	    	Iterator<RendezVous> iterator = compte.getAgenda().getListRdv().iterator();
		      while (iterator.hasNext()) {
		          RendezVous info = iterator.next();
		          if(info.getDate().equals(dateField.getValue().toString()) && info.getHeure().equals(heureField.getText())){
		        	  consultation = (Consultation) info;
		        	  verif = true;
		        	  pane4.setVisible(true);
		        	  pane5.setVisible(true);
		        	  ficheSuiviButton.setVisible(true);
		        	  duree = info.getDuree();
		        	  if(info.getDuree().equals("90") || info.getDuree().equals("150")){
		        		  pane1.setVisible(true);
		        		  ajouterPatient.setVisible(true);
		        		  if(info.getDuree().equals("90")){
		        			  pane2.setVisible(true);
		        		  }
		        		  else{
		        			  pane3.setVisible(true);
		        		  }
		        	  }
		          }
		      }
		      if(!verif){
                 rdvInexistant();
		      }
	    }

	    @FXML
	    public void annuler(ActionEvent event){
	    	pane1.setVisible(false);
	    	pane2.setVisible(false);
	    	pane3.setVisible(false);
	    	ajouterPatient.setVisible(false);
	    	pane4.setVisible(false);
	    	pane5.setVisible(false);
	    	ficheSuiviButton.setVisible(false);
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
	    public void rdvInexistant() {
	    	Alert alert=new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Rendez-vous inexistant");
	    	alert.setHeaderText(null);
	    	alert.setContentText("le rendez-vous fourni n'existe pas ! "+ "Veuillez consulter votre agenda pour insérer un rendez-vous valide ou bien en programmer un nouveau");
	    	alert.showAndWait();
	    }

	    @FXML
	    public void ajouterPatient(ActionEvent event){
	    	if(consultation.getDuree().equals("90")){
	    		patient = new PatientAdulte();
	    		compte.saisieInfoAdulte((PatientAdulte)patient, consultation.getNomPatient(),
	    				consultation.getPrenomPatient(), dateDeNaissanceField.getText(), lieuNaissanceField.getText(), adresseField.getText(),
	    				consultation.getAgePatient(), diplomeField.getText(), professionField.getText(), numPersonnelField.getText());
	    	}
	    	else{
	    		patient = new PatientEnfant();
	    		compte.saisieInfoEnfant((PatientEnfant)patient, consultation.getNomPatient(),
	    				consultation.getPrenomPatient(), dateDeNaissanceField.getText(), lieuNaissanceField.getText(), adresseField.getText(),
	    				consultation.getAgePatient(), classeEtudeField.getText(), numParentField.getText());
	    	}
	    	patient.setNbConsult(1);;
	    }

	    @FXML
	    public void terminerSeance(ActionEvent event) throws IOException{
	    	dossier = new Dossier(patient);
	    	consultation.setObservation(observationField.getText());
	    	dossier.ajouterRendezVous(consultation);
	    	compte.ajouterDossier(dossier);
	    	Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
	   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	    scene = new Scene(root,600,400);
	   	    stage.setScene(scene);
	   	    stage.show();
	    }

	    @FXML
	    void switchToScene7(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("FicheSuivi.fxml"));
	   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	    scene = new Scene(root,532,400);
	   	    stage.setScene(scene);
	   	    stage.show();
	    }

	    @FXML
	    void switchToScene9(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("BilanOrtho.fxml"));
	   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	    scene = new Scene(root,600,400);
	   	    stage.setScene(scene);
	   	    stage.show();
	    }
}
