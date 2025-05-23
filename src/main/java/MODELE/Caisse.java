/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELE;

/**
 *
 * @author HP
 */
public class Caisse {
    private String Matricule;
    private String Prenom;
    private String Nom;
    private String Filiere;
    private String Niveau;
    private int Montant;
    private String Objet;
    private String Date;
    private String Mois;
    
    //Constructeur avec parametre

    public Caisse(String Matricule, String Prenom, String Nom, String Filiere, String Niveau, int Montant, String Objet, String Date, String Mois) {
        this.Matricule = Matricule;
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Filiere = Filiere;
        this.Niveau = Niveau;
        this.Montant = Montant;
        this.Objet = Objet;
        this.Date = Date;
        this.Mois = Mois;
    }
    
    
    //Méthode getter

    public String getMatricule() {
        return Matricule;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getNom() {
        return Nom;
    }

    public String getFiliere() {
        return Filiere;
    }

    public String getNiveau() {
        return Niveau;
    }

    public int getMontant() {
        return Montant;
    }

    public String getObjet() {
        return Objet;
    }

    public String getDate() {
        return Date;
    }

    public String getMois() {
        return Mois;
    }
    
    //Méthode setter

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setFiliere(String Filiere) {
        this.Filiere = Filiere;
    }

    public void setNiveau(String Niveau) {
        this.Niveau = Niveau;
    }

    public void setMontant(int Montant) {
        this.Montant = Montant;
    }

    public void setObjet(String Object) {
        this.Objet = Objet;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setMois(String Mois) {
        this.Mois = Mois;
    }
   
}
