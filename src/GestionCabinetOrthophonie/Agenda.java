package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Agenda implements Serializable{
    private Set<RendezVous> listRdv;

    public Agenda(){
    	listRdv = new HashSet<RendezVous>();
    }

    // Méthode pour initialiser la liste des rendez-vous :
    public void setListRdv(Set<RendezVous> listRdv) {
    	this.listRdv.clear();
	    this.listRdv.addAll(listRdv);
    }

    public Set<RendezVous> getListRdv() {
		return listRdv;
	}

	// Méthode pour ajouter un rendez-vous :
    public void ajouterRendezVous(RendezVous rdv) {
      this.listRdv.add(rdv);
    }

    // Méthode pour rechercher un rendez vous :
    public boolean rechercherRDV(RendezVous rdv){
    	if(listRdv.contains(rdv)){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    // Méthode pour supprimer un rendez-vous :
    public void supprimerRendezVous(RendezVous rdv) {
    	if(listRdv.contains(rdv)){
            this.listRdv.remove(rdv);
    	}
    }

    // Méthode pour programmer un rendez-vous (ajout à la liste)
    // Vérificaation au niveau de compte, si Patient.NBConsult == 0 executer 1 sinon on cherche son numéro de dossier
    public Consultation programmerRendezVous(String date, String heure, String duree, String nomPatient, String prenomPatient, int agePatient) {
    	Consultation consultation = new Consultation(date, heure, duree, nomPatient, prenomPatient, agePatient);
	    ajouterRendezVous(consultation);
	    return consultation;
    }

    // Programmer une séance suivi (atient.NBConsult == 1) :
    public SeanceDeSuivi programmerRendezVous(String date, String heure, String duree, int numDossier, boolean enligne) {
	    SeanceDeSuivi seanceSuivi = new SeanceDeSuivi(date, heure, duree, numDossier, enligne);
	    ajouterRendezVous(seanceSuivi);
	    return seanceSuivi;
    }

    // Programmer un atelier pour une liste de patients :
    public Atelier programmerRendezVous(String date, String heure, String duree, String thematique, Set<Integer> listePatients) {
	    Atelier atelier = new Atelier(date, heure, duree, thematique, listePatients);
	    ajouterRendezVous(atelier);
	    return atelier;
    }

}





