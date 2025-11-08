package GestionCabinetOrthophonie;

import java.io.Serializable;

public class PatientAdulte extends Patient implements Serializable{
 private String diplome;
 private String profession;
 private String numeroPersonnel;
public void setDiplome(String diplome) {
	this.diplome = diplome;
}
public void setProfession(String profession) {
	this.profession = profession;
}
public void setNumeroPersonnel(String numeroPersonnel) {
	this.numeroPersonnel = numeroPersonnel;
}
}
