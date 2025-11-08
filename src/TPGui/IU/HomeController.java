package TPGui.IU;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import GestionCabinetOrthophonie.Compte;
import GestionCabinetOrthophonie.Dossier;
import GestionCabinetOrthophonie.Patient;
import GestionCabinetOrthophonie.PatientAdulte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class HomeController implements Initializable{
	private Stage stage;

	private Scene scene;

	private Parent root;

	private Compte compte = Compte.getInstance();

    @FXML
	private TreeView listDossiers;

    String fichierSerialisation = "compte.ser"; // Nom du fichier de s√©rialisation
    public void quitter(ActionEvent event){
    try (
    	ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fichierSerialisation))){


        Compte compte = (Compte) inputStream.readObject(); // D√©s√©rialiser l'objet
        System.out.println("Objet dÈsÈrialisÈ avec succÈs.");
        System.exit(0);
        // Utilisez l'objet compte d√©s√©rialis√© comme requis
    }

    catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		TreeItem<String> rootItem = new TreeItem<>("Dossiers patients");
		if(compte.getListeDossiersPatients() != null){
			int taille = compte.getListeDossiersPatients().size();
			int i = 0;
			Iterator<Dossier> iterator = compte.getListeDossiersPatients().iterator();
			while(i<taille && iterator.hasNext()){
				Dossier dossier = iterator.next();
				String str = "Dossier" + String.valueOf(i+1);
				TreeItem<String> branchItem = new TreeItem<>(str);
				TreeItem<String> branchItem2 = new TreeItem<>(dossier.getPatient().getNom());
				TreeItem<String> branchItem3 = new TreeItem<>(dossier.getPatient().getPrenom());
				TreeItem<String> branchItem4 = new TreeItem<>(String.valueOf(dossier.getPatient().getAge()));
				TreeItem<String> branchItem5 = new TreeItem<>(String.valueOf(dossier.getPatient().getNbConsult()));
				branchItem.getChildren().add(branchItem2);
				branchItem.getChildren().add(branchItem3);
				branchItem.getChildren().add(branchItem4);
				branchItem.getChildren().add(branchItem5);
				rootItem.getChildren().add(branchItem);

				i++;

			}
		}
        listDossiers.setRoot(rootItem);

	}

	@FXML
	public void SelectItems(){

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
	void switchToScene6(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Seance.fxml"));
	   	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	scene = new Scene(root,700,400);
	   	stage.setScene(scene);
	   	stage.show();

	}

	@FXML
	void switchToScene8(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Bo.fxml"));
	   	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	scene = new Scene(root,700,650);
	   	stage.setScene(scene);
	   	stage.show();

	}

    @FXML
    void consulterDossiers(){
    	listDossiers.setVisible(true);
    }
}
