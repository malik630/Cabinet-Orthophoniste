package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.Set;

public class Atelier extends RendezVous implements Serializable{
    private String thematique;
    private Set<Integer> listpatients; //on utilisera HashSet

    public Atelier(String date, String heure, String duree, String thematique, Set<Integer> listpatients) {
	   super(date, heure, duree);
	   this.thematique = thematique;
	   this.listpatients = listpatients;
    }

	public String getThematique() {
		return thematique;
	}

	public Set<Integer> getListpatients() {
		return listpatients;
	}
}
