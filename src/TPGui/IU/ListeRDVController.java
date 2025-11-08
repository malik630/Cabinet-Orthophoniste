package TPGui.IU;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import GestionCabinetOrthophonie.Compte;
import GestionCabinetOrthophonie.Consultation;
import GestionCabinetOrthophonie.RendezVous;
import GestionCabinetOrthophonie.SeanceDeSuivi;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ListeRDVController implements Initializable{

    @FXML
    private Button annulerButton;

    @FXML
    private Button confirmerButton;

	@FXML
    private ListView<String> listRdv;

	@FXML
	private DatePicker dateSupp;

    @FXML
    private TextField heureSupp;

    @FXML
    private Button supprimer;

	private Compte compte = Compte.getInstance();

	private ArrayList<String> listeInfo;

	private String rdv;

	private Stage stage;

	private Scene scene;

	private Parent root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		initialiserListe();
		listRdv.getItems().addAll(listeInfo);
	}

	public void initialiserListe(){
		listeInfo = new ArrayList<String>();
		listeInfo.add("Date                Heure      Durée     Type");
		Iterator<RendezVous> iterator = compte.getAgenda().getListRdv().iterator();
    	while (iterator.hasNext()) {
    		RendezVous info = iterator.next();
    		String str = info.getDate()+"     "+info.getHeure()+"            "+info.getDuree();
    		if(info instanceof Consultation){
    			str = str + "         Consultation";
    		}
    		else{
    			if(info instanceof SeanceDeSuivi){
    				str = str + "        Séance de suivi";
    			}
    			else{
    				str = str + "        Atelier";
    			}
    		}
    		this.listeInfo.add(str);
    	}
	}

	@FXML
	void switchToScene4(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Agenda.fxml"));
	   	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	scene = new Scene(root,700,400);
	   	stage.setScene(scene);
	   	stage.show();
	}

	@FXML
	void supprimer(ActionEvent event){
		supprimer.setVisible(false);
		dateSupp.setVisible(true);
		heureSupp.setVisible(true);
		annulerButton.setVisible(true);
		confirmerButton.setVisible(true);

	}

	@FXML
	void annuler(ActionEvent event){
		supprimer.setVisible(true);
		dateSupp.setVisible(false);
		heureSupp.setVisible(false);
		annulerButton.setVisible(false);
		confirmerButton.setVisible(false);
	}

	@FXML
	 void confirmer(ActionEvent event){
	      Iterator<RendezVous> iterator = compte.getAgenda().getListRdv().iterator();
	      while (iterator.hasNext()) {
	          RendezVous info = iterator.next();
	          if(info.getDate().equals(dateSupp.getValue().toString()) && info.getHeure().equals(heureSupp.getText())){
	        	  compte.getAgenda().supprimerRendezVous(info);
	          }
	      }
	      initialiserListe();
	      listRdv.getItems().clear();
	      listRdv.getItems().addAll(listeInfo);
	 }

}
