/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLEUR;

import DAO.DataBase;
import DAO.DbConnect;
import MODELE.Caisse;
import MODELE.Caissier;
import MODELE.Etudiant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class TraitementLogin {
    public Etudiant LoginEtudiant(String Matricule, String Password){
//        DbConnect DBC = new DbConnect();
//        DBC.connect();
        DataBase db = new DataBase();
        Connection conn=null;
        Etudiant e =null;
//        boolean L = false;
        try {
            db.connection();
            conn = db.getConnectBD();
            String req = "SELECT * FROM etudiant WHERE Matricule = ? AND Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1, Matricule); // "Matricule" est ta variable Java contenant le matricule recherché
            pstmt.setString(2, Password);
            ResultSet rs = pstmt.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    e = new Etudiant();
                    e.setMatricule(rs.getString("Matricule"));
                    e.setPrenom(rs.getString("Prenom"));
                }
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(TraitementLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;

    }

    public Caissier LoginCaissier(String Matricule, String Password){
//        DbConnect DBC = new DbConnect();
//        DBC.connect();
        DataBase db = new DataBase();
        Connection conn=null;
        Caissier c =null;
//        boolean L = false;
        try {
            db.connection();
            conn = db.getConnectBD();
            String req = "SELECT * FROM caissier WHERE Matricule = ? AND Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1, Matricule); // "Matricule" est ta variable Java contenant le matricule recherché
            pstmt.setString(2, Password);
            ResultSet rs = pstmt.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    c = new Caissier();
                    c.setMatricule(rs.getString("Matricule"));
                    c.setPrenom(rs.getString("Prenom"));
                }
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(TraitementLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;

    }
}
