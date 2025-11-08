package TPGui.IU;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import GestionCabinetOrthophonie.Compte;
import GestionCabinetOrthophonie.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestExcercieController {
	private Stage stage;
	private Scene scene;
	private Parent root;
    private Compte compte = Compte.getInstance();
    private String enonce;
	 Set<String> listeReponse =  new HashSet<String>();

     GestionCabinetOrthophonie.Question QST = new GestionCabinetOrthophonie.Question();

     GestionCabinetOrthophonie.QCM qcm = new GestionCabinetOrthophonie.QCM();
     GestionCabinetOrthophonie.QCU qcu = new GestionCabinetOrthophonie.QCU();
     Set<Question> listeQuestions = new HashSet();
     GestionCabinetOrthophonie.TestQuestions test = new GestionCabinetOrthophonie.TestQuestions();


    @FXML
    private Button AjouterQuestion;

    @FXML
    private Button AjouterReponse;

    @FXML
    private RadioButton Libre;

    @FXML
    private RadioButton QCM;

    @FXML
    private RadioButton QCU;

    @FXML
    private Button SauvegarderReponse;

    @FXML
    private TextField capacite;

    @FXML
    private AnchorPane mmmm;

    @FXML
    private TextField nomTest;

    @FXML
    private Button sauvegarderQst;

    @FXML
    private TextField Enonce;

    @FXML
    private TextField SaisirReponse;

    @FXML
    private TextField NbReponses;
    @FXML
    private Button SauvegarderTest;

    @FXML
    void showType(ActionEvent event) {
      Libre.setVisible(true);
      QCM.setVisible(true);
      QCU.setVisible(true);
    }
    @FXML
    void cacherSaisieQuest(ActionEvent event) {
    	if(QCM.isSelected()) {
    		for (String element : listeReponse) {
                qcm.ajouterReponse(element);
            }
    		qcm.setEnonce(Enonce.getText());
    		int n = Integer.parseInt(NbReponses.getText());
    		qcm.setNbRep(n);
    		listeQuestions.add(qcm);
  	  }
  	  else if(QCU.isSelected()) {
  		for (String element : listeReponse) {
            qcu.ajouterReponse(element);
            listeQuestions.add(qcu);
        }
  		qcu.setEnonce(Enonce.getText());
  	  }
  	  else if(Libre.isSelected()) {
  		QST.setEnonce(Enonce.getText());
  		listeQuestions.add(QST);
  	  }
    	NbReponses.setVisible(false);
    	NbReponses.clear();
    	Enonce.setVisible(false);
    	Enonce.clear();
    	NbReponses.setVisible(false);
        sauvegarderQst.setVisible(false);
        AjouterReponse.setVisible(false);
        Libre.setVisible(false);
        QCM.setVisible(false);
        QCU.setVisible(false);
        QCM.setSelected(false);
        QCU.setSelected(false);
        Libre.setSelected(false);
        listeReponse.clear();
        for (String element : qcm.getListeReponse()) {
            System.out.println(element);
        }
        for (Question question : listeQuestions) {
            if (question instanceof GestionCabinetOrthophonie.QCM) {
                System.out.println("C'est un QCM.");
                System.out.println(((GestionCabinetOrthophonie.QCM) question).getNbRep());


            } else if (question instanceof GestionCabinetOrthophonie.QCU) {
                System.out.println("C'est un QCU.");
            } else {
                System.out.println("C'est une autre question.");
            }
    }
    }

    @FXML
    void hideSaisieRep(ActionEvent event) {
          listeReponse.add(SaisirReponse.getText());
          SaisirReponse.clear();
          SaisirReponse.setVisible(false);

          SauvegarderReponse.setVisible(false);
    }

  /*  @FXML
    void showLibre(ActionEvent event) {
      Enonc�.setVisible(true);
      sauvegarderQst.setVisible(true);
    }

    @FXML
    void showQCM(ActionEvent event) {
    	 Enonc�.setVisible(true);
         AjouterReponse.setVisible(true);
         sauvegarderQst.setVisible(true);
    }

    @FXML
    void showQCU(ActionEvent event) {
    	Enonc�.setVisible(true);
        AjouterReponse.setVisible(true);
        sauvegarderQst.setVisible(true);
    }
*/
    public void getFood(ActionEvent event) {

    	  if(QCM.isSelected()) {
    		  Enonce.setVisible(true);
    	         AjouterReponse.setVisible(true);
    	         sauvegarderQst.setVisible(true);
    	         NbReponses.setVisible(true);
    	  }
    	  else if(QCU.isSelected()) {
    		  Enonce.setVisible(true);
    	        AjouterReponse.setVisible(true);
    	        sauvegarderQst.setVisible(true);
    	  }
    	  else if(Libre.isSelected()) {
    		  Enonce.setVisible(true);
  	        AjouterReponse.setVisible(false);

    	      sauvegarderQst.setVisible(true);

    	  }

    	 }
    @FXML
    void showSaisieRep(ActionEvent event) {
    	SaisirReponse.setVisible(true);
        SauvegarderReponse.setVisible(true);



    }

    @FXML
    void Sauvegarderetcacher(ActionEvent event) throws IOException {
          test.setNomTest(nomTest.getText());
          test.setCapacite(capacite.getText());
          test.creerListeQuestions();
          for (Question question : listeQuestions) {
              test.ajouterQuestion(question);
      }
       compte.ajouterElementDansTestMap(test.getNomTest(), test);
       switchtotestqst(event);





    }
    @FXML
    void switchtotestqst(ActionEvent event)throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("Bo.fxml"));
   	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	    scene = new Scene(root,600,400);
   	    stage.setScene(scene);
   	    stage.show();
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


