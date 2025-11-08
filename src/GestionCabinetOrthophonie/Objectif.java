package GestionCabinetOrthophonie;

import java.io.Serializable;

public class Objectif implements Serializable{
	private String nomObjectif;
	private TypeObjectif typeObjectif;
	private boolean atteint;
	public Objectif(String nomObjectif, TypeObjectif typeObjectif) {
		this.nomObjectif = nomObjectif;
		this.typeObjectif = typeObjectif;
	}
	public String getNomObjectif() {
		return nomObjectif;
	}
	public String getTypeObjectif() {
		return typeObjectif.name();
	}
	public boolean isAtteint() {
		return atteint;
	}
	public void setAtteint(boolean atteint) {
		this.atteint = atteint;
	}

}
