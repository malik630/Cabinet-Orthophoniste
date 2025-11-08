package GestionCabinetOrthophonie;

import java.io.Serializable;

public class Patient implements Serializable{
  private String nom;
  private String prenom;
  private String dateDeNaissance;
  private String lieuDeNaissance;
  private String adresse;
  private int age;
  private int nbConsult;
  
  public int getNbConsult() {
	return nbConsult;
  }

  public String getNom(){
	  return this.nom;
  }
  public void setNom(String nom) {
	this.nom = nom;
  }
  public String getPrenom(){
	  return this.prenom;
  }
  public void setPrenom(String prenom) {
	this.prenom = prenom;
  }
  public void setDateDeNaissance(String dateDeNaissance) {
	this.dateDeNaissance = dateDeNaissance;
  }
  public void setLieuDeNaissance(String lieuDeNaissance) {
	this.lieuDeNaissance = lieuDeNaissance;
  }
  public void setAdresse(String adresse) {
	this.adresse = adresse;
  }
  public int getAge(){
	  return this.age;
  }
  public void setAge(int age) {
	this.age = age;
  }
  public void setNbConsult(int nbConsult) {
	this.nbConsult = nbConsult;
  }
  

}
