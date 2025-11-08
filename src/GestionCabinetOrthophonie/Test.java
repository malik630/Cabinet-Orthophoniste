package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.Set;

public class Test implements Serializable {
	private String nomTest;
	private String capacite;
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public void setNomTest(String nomTest) {
		this.nomTest = nomTest;
	}



	public String getNomTest() {
		return nomTest;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomTest == null) ? 0 : nomTest.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (nomTest == null) {
			if (other.nomTest != null)
				return false;
		} else if (!nomTest.equals(other.nomTest))
			return false;
		return true;
	}

}
