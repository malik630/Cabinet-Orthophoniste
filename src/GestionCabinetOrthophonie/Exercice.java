package GestionCabinetOrthophonie;

import java.io.Serializable;

public class Exercice implements Serializable {
	private String consigne;


	private int score;



	// Consturcteur d'un exercice nécessitant un matériel :


	// Recupérer la consigne :
	public String getConsigne() {
		return consigne;
	}

	// Initialiser la consigne :
	public void setConsigne(String consigne) {
		this.consigne = consigne;
	}

	// Recupérer l'exercice matériel :


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

}
