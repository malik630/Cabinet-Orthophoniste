package TPGui.IU;

import java.io.IOException;
import java.net.URL ;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle ;
import java.util.Set;

import GestionCabinetOrthophonie.Compte;
import GestionCabinetOrthophonie.Consultation;
import GestionCabinetOrthophonie.Dossier;
import GestionCabinetOrthophonie.RendezVous;
import javafx.event.ActionEvent ;
import javafx.fxml.FXML ;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox ;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AgendaController implements Initializable{

	@FXML
	private AnchorPane atelier;

    @FXML
    private AnchorPane consultation;

    @FXML
    private AnchorPane seancesuivi;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField dureeField;

    @FXML
    private TextField heureField;

    @FXML
    private TextField nomPatient;

    @FXML
    private TextField prenomPatient;

	@FXML
    private TextField agePatient;

    @FXML
    private TextField numDossier;

    @FXML
    private TextField thematique;

    @FXML
    private TextField numDossierAtelier;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

	@FXML
	private ChoiceBox<String> typeRDV;

	@FXML
	private ChoiceBox<String> enLigne;

	@FXML
    private ChoiceBox<String> typepatient;

	private String[] type = {"Consultation", "Séance de suivi", "Atelier"};

	private String[] mode = {"En ligne", "Présentiel"};

	private String[] typeP = {"Adulte", "Enfant"};

	private String rdv;

	private Stage stage;

	private Scene scene;

	private Parent root;

	private boolean enligne;

	private boolean adulte;

	private Compte compte = Compte.getInstance();

	private Set<Integer> listeAtelier;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
    	typeRDV.getItems().addAll(type);
    	typeRDV.setOnAction(this::getTypeRDV);
    	enLigne.getItems().addAll(mode);
    	enLigne.setOnAction(this::getEnLigne);
    	typepatient.getItems().addAll(typeP);
    	typepatient.setOnAction(this::getTypePatient);
    }

    public void getTypeRDV(ActionEvent event){
    	label1.setVisible(false);
    	rdv = typeRDV.getValue();
    	if(rdv.equals("Consultation")){
    		seancesuivi.setVisible(false);
    		atelier.setVisible(false);
    		consultation.setVisible(true);
    	}
    	else{
    		consultation.setVisible(false);
    		if(rdv.equals("Séance de suivi")){
    			atelier.setVisible(false);
    			seancesuivi.setVisible(true);
    		}
    		else{
    			seancesuivi.setVisible(false);
    			atelier.setVisible(true);
    			listeAtelier = new HashSet<Integer>();
    		}
    	}
    }

    public void getEnLigne(ActionEvent event){
    	label2.setVisible(false);
    	String modeType = enLigne.getValue();
    	if(modeType.equals("En ligne")){
    		enligne = true;
    	}
    	else{
    		enligne = false;
    	}
    }

    public void getTypePatient(ActionEvent event){
    	label3.setVisible(false);
    	String pat = typepatient.getValue();
    	if(pat.equals("Adulte")){
    		adulte = true;
    	}
    	else{
    		adulte = false;
    	}
    }

    @FXML
    void ajouterPatient(ActionEvent event){
    	if(compte.rechercherNumDossier(Integer.parseInt(numDossierAtelier.getText()))){
    		listeAtelier.add(Integer.parseInt(numDossierAtelier.getText()));
    	}
    	else{
    		numDossierInexistant();
    	}
    }

    @FXML
    void programmerRDV(ActionEvent event){
    	label4.setVisible(false);
    	if(rdv.equals("Consultation")){
    		if(adulte){
    			if(dureeField.getText().equals("90")){
    				int age = Integer.parseInt(agePatient.getText());
        		    Consultation consultation = compte.getAgenda().programmerRendezVous(dateField.getValue().toString(), heureField.getText(), dureeField.getText(), nomPatient.getText(), prenomPatient.getText(), age);
        		    label4.setVisible(true);
    			}
    			else{
    				dureeEronee("90");
    			}
    		}
    		else{
    			if(dureeField.getText().equals("150")){
    				int age = Integer.parseInt(agePatient.getText());
        		    compte.getAgenda().programmerRendezVous(dateField.getValue().toString(), heureField.getText(), dureeField.getText(), nomPatient.getText(), prenomPatient.getText(), age);
        		    label4.setVisible(true);
    			}
    			else{
    			    dureeEronee("150");
    			}
    		}
    	}
    	else{
    		if(!(dureeField.getText().equals("60"))){
    			dureeEronee("60");
    		}
    		else{
    		    if(rdv.equals("Séance de suivi")){
    		    	int numdossier = Integer.parseInt(numDossier.getText());
    		    	if(compte.rechercherNumDossier(numdossier)){
    		    		compte.getAgenda().programmerRendezVous(dateField.getValue().toString(), heureField.getText(), dureeField.getText(), numdossier, enligne);
    		    		label4.setVisible(true);
    		    	}
    		    }
    		    else{ // Atelier
    		    	if(rechercheNumDossierAtelier() && !(listeAtelier.isEmpty())){
    		    		compte.getAgenda().programmerRendezVous(dateField.getValue().toString(), heureField.getText(), dureeField.getText(), thematique.getText(), listeAtelier);
    		    		label4.setVisible(true);
    		    	}
    		    	else{
    		    		numDossierInexistant();
    		    	}

    		    }
    		}
    	}
    }

    @FXML
    public void dureeEronee(String dureeRecommandee) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Durée de la séance invalide");
    	alert.setHeaderText(null);
    	alert.setContentText("la durée fournie est erronée ! "+ "Pour ce type de rendez-vous veuillez saisir la durée : "+ dureeRecommandee);
    	alert.showAndWait();
    }

    @FXML
    public void numDossierInexistant() {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Numéro de dossier inéxistant");
    	alert.setHeaderText(null);
    	alert.setContentText("le numéro de dossier fourni n'éxiste pas ! "+ "Veuillez consulter la liste des dossiers et saisir un numéro de dossier valide.");
    	alert.showAndWait();

    }

    public boolean rechercheNumDossierAtelier(){
    	boolean verif = true;
    	Iterator<Integer> iterator = listeAtelier.iterator();
    	while (iterator.hasNext() && verif) {
    		int num = iterator.next().intValue();
    		if(!(compte.rechercherNumDossier(num))){
    			verif = false;
    		}
    	}
    	return verif;
    }

    @FXML
    void switchToScene5(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ListeRDV.fxml"));
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