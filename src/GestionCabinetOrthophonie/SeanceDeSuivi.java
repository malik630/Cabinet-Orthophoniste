package GestionCabinetOrthophonie;

import java.io.Serializable;

public class SeanceDeSuivi extends RendezVous implements Serializable{
  private int numDossier;
  private boolean enlinge;
public SeanceDeSuivi(String date, String heure, String duree,int numDossier, boolean enlinge) {
	super(date, heure, duree);
	this.numDossier = numDossier;
	this.enlinge = enlinge;
}

}
