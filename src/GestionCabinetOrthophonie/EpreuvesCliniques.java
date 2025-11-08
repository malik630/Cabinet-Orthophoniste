package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.Set;

public class EpreuvesCliniques implements Serializable{
	private String ObservationClinique;

	private Set<Test> listTests;

	public String getObservationClinique() {
		return ObservationClinique;
	}

	public void setObservationClinique(String observationClinique) {
		ObservationClinique = observationClinique;
	}

	public Set<Test> getListTests() {
		return listTests;
	}

	public void setListTests(Set<Test> listTests) {
		this.listTests = listTests;
	}

}
