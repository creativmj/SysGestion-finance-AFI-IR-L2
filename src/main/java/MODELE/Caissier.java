/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELE;

/**
 *
 * @author HP
 */
public class Caissier {
    private String Matricule;
    private String Prenom;
    private String Nom;
    private String Password;
   
    public Caissier(){

    }
    
    //Constructeur avec parametre

    public Caissier(String Matricule, String Prenom, String Nom, String Password) {
        this.Matricule = Matricule;
        this.Prenom = Prenom;
        this.Nom = Nom;
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

    public void setPassword(String Filiere) {
        this.Password = Password;
    }

    
}
