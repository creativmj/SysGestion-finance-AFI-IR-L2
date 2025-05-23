/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELE;

import java.sql.Timestamp;

/**
 *
 * @author HP
 */
public class Paiement {
    
    private int id;
    private String idetudiant;
    private String idcaissier;
    private float Montant;
    private Timestamp Date;
    private String Statut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdEtudiant() {
        return idetudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idetudiant = idEtudiant;
    }

    public String getIdCaissier() {
        return idcaissier;
    }

    public void setIdCaissier(String idCaissier) {
        this.idcaissier = idCaissier;
    }

    public float getMontant() {
        return Montant;
    }

    public void setMontant(float montant) {
        this.Montant = montant;
    }

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(Timestamp date) {
        this.Date = date;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String statut) {
        this.Statut = statut;
    }
    
   
}
