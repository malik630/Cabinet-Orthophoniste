package GestionCabinetOrthophonie;

import java.io.Serializable;

public class Consultation extends RendezVous implements Serializable{
    private String nomPatient;
    private String prenomPatient;
    private int agePatient;

    public Consultation(String date, String heure, String duree, String nomPatient, String prenomPatient, int agePatient) {
	    super(date, heure, duree);
	    this.nomPatient = nomPatient;
	    this.prenomPatient = prenomPatient;
	    this.agePatient = agePatient;
    }

	public String getNomPatient() {
	    return nomPatient;
    }

    public String getPrenomPatient() {
	    return prenomPatient;
    }

    public int getAgePatient() {
	    return agePatient;
    }

}
