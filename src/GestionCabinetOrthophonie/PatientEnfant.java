package GestionCabinetOrthophonie;

import java.io.Serializable;

public class PatientEnfant extends Patient implements Serializable{
 private  String classeEtude;
 private String numTelParents;
 public void setClasseEtude(String classeEtude) {
	this.classeEtude = classeEtude;
 }
 public void setNumTelParents(String numTelParents) {
	this.numTelParents = numTelParents;
 }
 
}
