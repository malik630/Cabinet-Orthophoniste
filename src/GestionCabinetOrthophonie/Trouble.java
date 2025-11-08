package GestionCabinetOrthophonie;

import java.io.Serializable;

public class Trouble implements Serializable{
	String nomTrouble;
	TroublesCategories categorieTrouble;
	public Trouble(String nomTrouble, TroublesCategories categorieTrouble) {
		this.nomTrouble = nomTrouble;
		this.categorieTrouble = categorieTrouble;
	}
	public String getNomTrouble() {
		return nomTrouble;
	}
	public String getCategorieTrouble() {
		return categorieTrouble.name();
	}

}
