package TPGui.IU;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import GestionCabinetOrthophonie.Compte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
public class creationAnamnesesController  {
	private Stage stage;
	private Scene scene;
	private Parent root;
    private Compte compte = Compte.getInstance();
    private String enonce;
    @FXML
    private RadioButton Adulte;

    @FXML
    private Button AjoutQST;

    @FXML
    private RadioButton Car;

    @FXML
    private RadioButton Comport;

    @FXML
    private RadioButton DevLang;

    @FXML
    private RadioButton DevPsy;

    @FXML
    private RadioButton Dynamique;

    @FXML
    private RadioButton Enfant;

    @FXML
    private TextField EnonAdulte;

    @FXML
    private TextField EnoncEnf;

    @FXML
    private RadioButton Histoire;

    @FXML
    private ToggleGroup PatientType;

    @FXML
    private Button SauvegardAnam;

    @FXML
    private Button Sauvegarderquestion;

    @FXML
    private RadioButton Structure;

    @FXML
    private RadioButton Suivi;

    @FXML
    private RadioButton antec;

    @FXML
    private RadioButton cond;

    @FXML
    void getPatientType(ActionEvent event) {

    }

    @FXML
    void showQst(ActionEvent event) {
      //    AjoutQST.setVisible(true);

    }
    @FXML
    void showAjout(ActionEvent event) {
      AjoutQST.setVisible(true);
      if(Adulte.isSelected()) {
        EnoncEnf.setVisible(false);
        Histoire.setVisible(true);
        Suivi.setVisible(true);
        EnonAdulte.setVisible(true);
        Structure.setVisible(false);;
        antec.setVisible(false);
        cond.setVisible(false);
         Car.setVisible(false);

       Comport.setVisible(false);

        DevLang.setVisible(false);

       DevPsy.setVisible(false);

       Dynamique.setVisible(false);



    	  	  }
  	  else if(Enfant.isSelected()) {


  		  EnonAdulte.setVisible(false);
         Structure.setVisible(true);;
         antec.setVisible(true);
         cond.setVisible(true);
          Car.setVisible(true);

        Comport.setVisible(true);

         DevLang.setVisible(true);

        DevPsy.setVisible(true);

        Dynamique.setVisible(true);
        EnoncEnf.setVisible(true);
        Histoire.setVisible(false);
        Suivi.setVisible(false);






  	  }

    }
    @FXML
    void SauvegardQst(ActionEvent event) {
    	EnonAdulte.setVisible(false);
        Structure.setVisible(false);;
        antec.setVisible(false);
        cond.setVisible(false);
         Car.setVisible(false);

       Comport.setVisible(false);

        DevLang.setVisible(false);

       DevPsy.setVisible(false);

       Dynamique.setVisible(false);

    }
    @FXML
    void switchToTest(ActionEvent event) {

    }

    @FXML
    void switchToScene8(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Bo.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,532,400);
   	    stage.setScene(scene);
   	    stage.show();
    }









}
