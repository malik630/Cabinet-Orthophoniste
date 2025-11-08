package GestionCabinetOrthophonie;

import java.io.Serializable;

public abstract class RendezVous implements Serializable{
	private String date;
	private String heure;
	private String observation;
	private String duree;
	public RendezVous(String date, String heure, String duree) {
		this.date = date;
		this.heure = heure;
		this.duree = duree;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getDate() {
		return date;
	}
	public String getHeure() {
		return heure;
	}
	public String getObservation() {
		return observation;
	}
	public String getDuree() {
		return duree;
	}


}
