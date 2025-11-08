package GestionCabinetOrthophonie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Compte implements Serializable {
   private String nom;
   private String prenom;
   private String adresse;
   private String numeroDeTelephone;
   private String adresseEmail;
   private String motDePasse;
   private Agenda agenda;
   private Set<Dossier> listeDossiersPatients;
   private Set<Patient> listePatientsAtelier;
   private static Compte compte = null;
   private HashMap<String, Test> testMap;

   // Déclaration de compte comme singleton :
   private Compte(){
	   this.testMap = new HashMap<>();

   }

   // Méthode publique pour obtenir l'instance unique
   public static Compte getInstance() {
       if (compte == null) {
           synchronized (Compte.class) {
               if (compte == null) {
                   compte = new Compte();
               }
           }
       }
       return compte;
   }

   // Création du compte au compte :

   public String getNom() {
	return nom;
}

public String getPrenom() {
	return prenom;
}

public String getAdresse() {
	return adresse;
}

public String getNumeroDeTelephone() {
	return numeroDeTelephone;
}

public String getAdresseEmail() {
	return adresseEmail;
}

public String getMotDePasse() {
	return motDePasse;
}

public Agenda getAgenda() {
	return agenda;
}

public Set<Dossier> getListeDossiersPatients() {
	return listeDossiersPatients;
}

public Set<Patient> getListePatientsAtelier() {
	return listePatientsAtelier;
}

// Entrer le nom :
   public void setNom(String nom) {
	   this.nom = nom;
   }

   // Entrer le prenom :
   public void setPrenom(String prenom) {
	   this.prenom = prenom;
   }

   // Entrer l'adresse :
   public void setAdresse(String adresse) {
	   this.adresse = adresse;
   }

   // Entrer le numéro de télephone :
   public void setNumeroDeTelephone(String numeroDeTelephone) {
	   this.numeroDeTelephone = numeroDeTelephone;
   }

   // Entrer l'adresse Email :
   public void setAdresseEmail(String adresseEmail) {
	   this.adresseEmail = adresseEmail;
   }

   // Entrer le mot de passe :
   public void setMotDePasse(String motDePasse) {
	   this.motDePasse = motDePasse;
   }

   // Création d'un agenda :
   public void creerAgenda(){
	   this.agenda = new Agenda();
   }

   // Création d'une liste de dossier des patients :
   public void creerListeDossiers(){
	   listeDossiersPatients = new HashSet<Dossier>();
   }

   public void ajouterDossier(Dossier dossier){
	   listeDossiersPatients.add(dossier);
   }

   public void supprimerDossier(Dossier dossier){
	   listeDossiersPatients.remove(dossier);
   }

   // Fonction de hachage SHA-256 du mot de passe :
   public static String hash(String input) {
       try {
           // Créer une instance de MessageDigest avec SHA-256
           MessageDigest digest = MessageDigest.getInstance("SHA-256");

           // Appliquer le hachage sur les bytes de l'input
           byte[] encodedhash = digest.digest(input.getBytes("UTF-8"));

           // Convertir le résultat en format hexadécimal
           return bytesToHex(encodedhash);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   public void ajouterElementDansTestMap(String cle, Test valeur) {
	    this.testMap.put(cle, valeur);
	}

   public void setListeDossiersPatients(Set<Dossier> listeDossiersPatients) {
	this.listeDossiersPatients = listeDossiersPatients;
}

// Fonction de conversion d'un byte[] en String hexadécimal (pour rendre le haché du mot de passe String) :
   private static String bytesToHex(byte[] hash) {
       StringBuilder hexString = new StringBuilder(2 * hash.length);
       for (int i = 0; i < hash.length; i++) {
           String hex = Integer.toHexString(0xff & hash[i]);
           if (hex.length() == 1) {
               hexString.append('0');
           }
           hexString.append(hex);
       }
       return hexString.toString();
   }

   //Création d'un compte :
   public void creerCompte(String nom, String prenom, String adresse, String numeroDeTelephone, String adresseEmail, String motDePasse){
	   setNom(nom);
	   setPrenom(prenom);
	   setAdresse(adresse);
	   setNumeroDeTelephone(numeroDeTelephone);
	   setAdresseEmail(adresseEmail);
	   String motDePasseHache = hash(motDePasse);
	   setMotDePasse(motDePasseHache);
	   creerAgenda();
	   creerListeDossiers();
   }

   // Connexion au compte :
   public boolean seConnecter(String adresseMail, String motDePasse){
	   boolean verif = false;
	   String motDePasseHache = hash(motDePasse);
	   if(adresseMail.equals(this.adresseEmail) && motDePasseHache.equals(this.motDePasse)){
		   verif = true;
	   }
	   return verif;
   }

   // Méthode pour recherche un patient dans la liste des dossiers :
   // Obtenir un itérateur pour le Set

   public int rechercherPatient(Patient patient){
       Iterator<Dossier> iterator = listeDossiersPatients.iterator();

       // Parcourir le Set à l'aide de l'itérateur
       int numDossier = -1;
       while (iterator.hasNext()) {
       Dossier dossier = iterator.next();
       Patient patientCourant = dossier.getPatient();
       if((patientCourant.getNom() == patient.getNom()) && (patientCourant.getPrenom() == patient.getPrenom())){
             numDossier = dossier.getNumDossier();
             break;
         }
      }
       return numDossier;
   }

   public boolean rechercherNumDossier(int numDossier){
       Iterator<Dossier> iterator = listeDossiersPatients.iterator();

       // Parcourir le Set à l'aide de l'itérateur
       boolean verif = false;
       while (iterator.hasNext() && !verif) {
       Dossier dossier = iterator.next();
       int numDossierCourant = dossier.getNumDossier();
       if(numDossierCourant == numDossier){
             numDossier = dossier.getNumDossier();
             verif = true;
         }
      }
       return verif;
   }
   // Etape 1 : Rendez-Vous :

   // Méthode pour créer la liste de patients participant à un atelier
   public void creerListeAtelier(){
	   listePatientsAtelier = new HashSet<Patient>();
   }

   // Ajouter un patient à la liste :
   public void ajouterPatient(Patient patient){
	   listePatientsAtelier.add(patient);
   }

   // Supprimer un patient de la liste :
   public boolean supprimerPatient(Patient patient){
	   boolean verif = false;
	   if(listePatientsAtelier.contains(patient)){
		   verif = listePatientsAtelier.remove(patient);
	   }
	   return verif;
   }

   //Etape 2 : BO

   // Saisi des information lors du premier rendez-vous :

   // Patient enfant :
   public void saisieInfoEnfant ( PatientEnfant enfant,String nom,String prenom,String dateDeNaissance,String lieuDeNaissance,String adresse,int age,String classeEtude,String numTelParents)
   {
	   if ( enfant.getNbConsult() == 0){
		   enfant.setNom(nom);
		   enfant.setPrenom(prenom);
		   enfant.setDateDeNaissance(dateDeNaissance);
		   enfant.setLieuDeNaissance(lieuDeNaissance);
		   enfant.setAdresse(adresse);
		   enfant.setAge(age);
		   enfant.setClasseEtude(classeEtude);
		   enfant.setNumTelParents(numTelParents);
	   }
   }

   // Patient adulte :
   public void saisieInfoAdulte ( PatientAdulte adulte,String nom,String prenom,String dateDeNaissance,String lieuDeNaissance,String adresse,int age,String diplome,String profession,String numeroPersonnel)
   {
	   if ( adulte.getNbConsult() == 0){
		   adulte.setNom(nom);
		   adulte.setPrenom(prenom);
		   adulte.setDateDeNaissance(dateDeNaissance);
		   adulte.setLieuDeNaissance(lieuDeNaissance);
		   adulte.setAdresse(adresse);
		   adulte.setAge(age);
		   adulte.setDiplome(diplome);
		   adulte.setProfession(profession);
		   adulte.setNumeroPersonnel(numeroPersonnel);
	   }
    }

   // Méthode qui retourne le BO du patient ayant déja consulté :
   public ArrayList<BO> getBO(int numDossier){
	   Iterator<Dossier> iterator = listeDossiersPatients.iterator();

       // Parcourir le Set à l'aide de l'itérateur
       ArrayList<BO> BOpatient = new ArrayList<BO>();
       while (iterator.hasNext()) {
       Dossier dossier = iterator.next();
       int numDossierPatient = dossier.getNumDossier();
       if(numDossierPatient == numDossier){
             BOpatient = dossier.getListBO();
             break;
         }
      }
       return BOpatient;
   }
   public void enregistrerDansFichier(String nomFichier) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
           writer.write(nom);
           writer.newLine();
           writer.write(prenom);
           writer.newLine();
           writer.write(adresse);
           writer.newLine();
           writer.write(numeroDeTelephone);
           writer.newLine();
           writer.write(adresseEmail);
           writer.newLine();
           writer.write(motDePasse);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   //Méthode pour enregistrer les informations du compte dans un fichier
   public void recupererDepuisFichier(String nomFichier) {
       try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
           this.nom = reader.readLine();
           this.prenom = reader.readLine();
           this.adresse = reader.readLine();
           this.numeroDeTelephone = reader.readLine();
           this.adresseEmail = reader.readLine();
           this.motDePasse = reader.readLine();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}

