/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELE;

/**
 *
 * @author HP
 */
public class Etudiant {

    public Etudiant() {
    }
    private String Matricule;
    private String Prenom;
    private String Nom;
    private String Filiere;
    private String Niveau;
    private String Password;
    
    
    
    //Constructeur avec parametre
    public Etudiant(String Matricule, String Prenom, String Nom, String Filiere, String Niveau, String Password) {
        this.Matricule = Matricule;
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Filiere = Filiere;
        this.Niveau = Niveau;
        this.Password = Password;
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

    public String getPassword() {
        return Password;
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

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
