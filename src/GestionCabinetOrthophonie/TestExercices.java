package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.ArrayList;

public class TestExercices extends Test implements Serializable {
    private ArrayList<Exercice> exercices;
    public void creerListeExcercices(){
    	this.exercices = new ArrayList();
    }
	// Ajouter un exercice :
	public void ajouterExercice(Exercice exo) {
		this.exercices.add(exo);
	}

	// Supprimer un exercice :
	public void supprimerExercice(Exercice exo) {
		if(this.exercices.contains(exo)){
			this.exercices.remove(exo);
		}
	}

	// Initaliser la liste d'exercices :
	public void setExercices(ArrayList<Exercice> exercices) {
		this.exercices.clear();
		this.exercices.addAll(exercices);
	}

	// Constructeur :


	public ArrayList<Exercice> getExercices() {
		return exercices;
	}

}
