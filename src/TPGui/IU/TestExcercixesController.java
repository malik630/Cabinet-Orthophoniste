package TPGui.IU;

import java.io.IOException;
import java.util.ArrayList;

import GestionCabinetOrthophonie.Compte;
import GestionCabinetOrthophonie.Exercice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
public class TestExcercixesController {
	private Stage stage;
	private Scene scene;
	private Parent root;
    private Compte compte = Compte.getInstance();
    GestionCabinetOrthophonie.Exercice excercice = new GestionCabinetOrthophonie.Exercice();
    GestionCabinetOrthophonie.ExerciceMateriel exomat = new GestionCabinetOrthophonie.ExerciceMateriel();
     ArrayList<Exercice> exercices = new ArrayList<Exercice>();
     GestionCabinetOrthophonie.TestExercices test = new GestionCabinetOrthophonie.TestExercices();



	  @FXML
	    private RadioButton Exo;

	    @FXML
	    private RadioButton ExoMateriel;

	    @FXML
	    private Button SauvegardeExo;

	    @FXML
	    private ToggleGroup TypeExo;

	    @FXML
	    private Button ajoutExo;
	    @FXML
	    private TextField Capacite;

	    @FXML
	    private TextField Consigne;

	    @FXML
	    private TextField NomTest;

	    @FXML
	    private TextField materiel;
	    @FXML
	    private Button SauvegardTest;

	    @FXML
	    void getType(ActionEvent event) {
	    	if(Exo.isSelected()) {
                Consigne.setVisible(true);
                SauvegardeExo.setVisible(true);
                materiel.setVisible(false);
	    	  }
	    	  else if(ExoMateriel.isSelected()) {
	    		  Consigne.setVisible(true);
	    		  materiel.setVisible(true);
	                SauvegardeExo.setVisible(true);

	    	  }


	    }

	    @FXML
	    void hideExo(ActionEvent event) {
	    	if(Exo.isSelected()) {
                excercice.setConsigne(Consigne.getText());
                exercices.add(excercice);
	    	  }
	    	  else if(ExoMateriel.isSelected()) {
	    		 exomat.setConsigne(Consigne.getText());
	    		 exomat.setNomMateriel(materiel.getText());
	    		 exercices.add(exomat);


	    	  }

	    	  Consigne.setVisible(false);
	    	  Consigne.clear();
  		      materiel.setVisible(false);
              materiel.clear();
              SauvegardeExo.setVisible(false);
              Exo.setVisible(false);
              ExoMateriel.setVisible(false);
              Exo.setSelected(false);
      	      ExoMateriel.setSelected(false);



	    }

	    @FXML
	    void hideTest(ActionEvent event) throws IOException {
            test.setNomTest(NomTest.getText());
            test.setCapacite(Capacite.getText());
            test.creerListeExcercices();
            for (Exercice element : exercices) {
                test.ajouterExercice(element);

            }
            compte.ajouterElementDansTestMap(test.getNomTest(), test);



	    	Exo.setVisible(false);
		    ExoMateriel.setVisible(false);
            NomTest.setVisible(false);
            Capacite.setVisible(false);
            switchtotest(event);
	    }

	    @FXML
	    void showExo(ActionEvent event) {

	    Exo.setVisible(true);
	    ExoMateriel.setVisible(true);


	    }
	    @FXML
	    void switchtotest(ActionEvent event)throws IOException {

	    	Parent root = FXMLLoader.load(getClass().getResource("Bo.fxml"));
	   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	    scene = new Scene(root,600,400);
	   	    stage.setScene(scene);
	   	    stage.show();
	}
}
