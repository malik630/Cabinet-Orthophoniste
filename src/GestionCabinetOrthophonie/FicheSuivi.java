package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.ArrayList;

public class FicheSuivi implements Serializable{

    private String score;
	private boolean objectifAtteint;
	private ArrayList<Objectif> listeObjectifs;

	public void ajouterObjectif(Objectif objectif)
	{
		this.listeObjectifs.add(objectif);
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public boolean isObjectifAtteint() {
		return objectifAtteint;
	}
	public void setObjectifAtteint(boolean objectifAtteint) {
		this.objectifAtteint = objectifAtteint;
	}
	public ArrayList<Objectif> getListeObjectifs() {
		return listeObjectifs;
	}
	public void setListeObjectifs(ArrayList<Objectif> listeObjectifs) {
		this.listeObjectifs = listeObjectifs;
	}

}
