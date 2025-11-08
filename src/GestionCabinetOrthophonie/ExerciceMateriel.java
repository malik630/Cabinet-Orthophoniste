package GestionCabinetOrthophonie;

import java.io.Serializable;

public class ExerciceMateriel extends Exercice implements Serializable {


	private String nomMateriel;
	public String getNomMateriel() {
		return nomMateriel;
	}
	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}

}
