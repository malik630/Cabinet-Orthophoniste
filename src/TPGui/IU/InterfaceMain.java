package TPGui.IU;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import GestionCabinetOrthophonie.Compte;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class InterfaceMain extends Application{

	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("InterfaceTP.fxml"));
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
		Compte compte = Compte.getInstance(); // Obtenez l'instance du singleton
		   String fichierSerialisation = "compte.ser" ;  // Nom du fichier de sÃ©rialisation

		   try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fichierSerialisation))) {
		       outputStream.writeObject(compte);
		       System.out.println("Objet sérialisé avec succés.");
		   } catch (IOException e) {
		       e.printStackTrace();

		}
	}

}
