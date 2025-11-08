package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.Set;

public class BO implements Serializable{
   private EpreuvesCliniques [] epreuves;
   private Set<Trouble> troubles; // On utilisera HashSet.
   private String ProjetTherapeutique;
public EpreuvesCliniques[] getEpreuves() {
	return epreuves;
}
public void setEpreuves(EpreuvesCliniques[] epreuves) {
	this.epreuves = epreuves;
}
public Set<Trouble> getTroubles() {
	return troubles;
}
public void setTroubles(Set<Trouble> troubles) {
	this.troubles = troubles;
}
public String getProjetTherapeutique() {
	return ProjetTherapeutique;
}
public void setProjetTherapeutique(String projetTherapeutique) {
	ProjetTherapeutique = projetTherapeutique;
}
}
