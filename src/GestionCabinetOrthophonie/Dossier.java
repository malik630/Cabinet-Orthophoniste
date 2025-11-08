package GestionCabinetOrthophonie;

import java.io.Serializable;
import java.util.ArrayList;

public class Dossier implements Serializable{
   private final int numDossier;
   private static int increment;
   private Patient patient;
   private ArrayList <RendezVous> listRdv ;
   private ArrayList<BO> listBO;
   private ArrayList<FicheSuivi> fiches;


   public Dossier(Patient patient) {
	   this.numDossier = increment + 1;
	   this.patient = patient;
	   Dossier.increment++;
	   listRdv = new ArrayList<>();
	   listBO = new ArrayList<>();
	   fiches = new ArrayList<>();
   }

   public ArrayList<FicheSuivi> getFiches() {
	return fiches;
}

public ArrayList<BO> getListBO() {
	   return listBO;
   }

   public void setListBO(ArrayList<BO> listBO) {
	   this.listBO = listBO;
   }

   public ArrayList<RendezVous> getListRdv() {
	   return listRdv;
   }

   public void setListRdv(ArrayList<RendezVous> listRdv) {
	   this.listRdv = listRdv;
   }

   public void ajouterRendezVous(RendezVous rdv) {
       this.listRdv.add(rdv);
   }

   public Patient getPatient() {
	   return patient;
   }

   public int getNumDossier() {
	   return numDossier;
   }


public void setFiches(ArrayList<FicheSuivi> fiches) {
	this.fiches = fiches;
}
public void ajouterFiche(FicheSuivi fiche) {
    this.fiches.add(fiche);
}

public int hashCode(){
	return numDossier;
}

}
