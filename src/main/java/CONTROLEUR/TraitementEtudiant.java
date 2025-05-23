/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLEUR;

import DAO.DataBase;
import DAO.DbConnect;
import MODELE.Etudiant;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class TraitementEtudiant {
    public int verifMatriculeEtudiant(String matricule){
        int response = 0;
        DataBase db = new DataBase();
        int count = 0;
        try {
            db.connection();
            Connection conn = db.getConnectBD();
            PreparedStatement prepare = conn.prepareStatement("SELECT COUNT(*) FROM etudiant WHERE Matricule = ?;");
            prepare.setString(1, matricule);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
            response = count;

            rs.close();
            conn.close();
            db.close();
        } catch (SQLException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

    public String addEtudiant(String matricule, String prenom, String nom, String filiere, String niveau, String password){
        String response = null;
        DataBase db = new DataBase();
        try {
            db.connection();
            Connection conn = db.getConnectBD();
            int count = verifMatriculeEtudiant(matricule);
            if(count==0) {
                PreparedStatement prepare = conn.prepareStatement("INSERT INTO etudiant(Matricule,Prenom,Nom,Filiere,Niveau, Password, dateInscription) VALUES (?, ?, ?, ?, ?, ?, ?);");
                prepare.setString(1, matricule);
                prepare.setString(2, prenom);
                prepare.setString(3, nom);
                prepare.setString(4, filiere);
                prepare.setString(5, niveau);
                prepare.setString(6, password);
                prepare.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                int result = prepare.executeUpdate();
                if (result == 1)
                    response = "ok";
                conn.close();
                db.close();
                System.out.println("insert succeed");
            }else{
                response = "already_exist";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }
    
    public String consulterInfosEtudiant(String matricule) throws SQLException, IOException {
    DataBase db = new DataBase();
    db.connection();
    Connection conn = db.getConnectBD();
    //Connection conn = connexion.getConnectBD(); // Adapte selon ta méthode de connexion
    StringBuilder infos = new StringBuilder();

    try {
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM etudiant WHERE Matricule = ?");
        pst.setString(1, matricule);
        ResultSet rs = pst.executeQuery();
        System.out.println("Matricule utilisé pour la requête : [" + matricule + "]");

//         if (rs.next()) {
//        // retourne des informations formatées
//        return "Nom: " + rs.getString("nom") + "\nPrénom: " + rs.getString("prenom");
//    } else {
//        return null; // étudiant non trouvé
//    }

        if (rs.next()) {
            String Matricule = rs.getString("matricule");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String filiere = rs.getString("filiere");
            String niveau = rs.getString("niveau");

            infos.append("Nom: ").append(nom).append(" ").append(prenom).append("\n");
            infos.append("Filière: ").append(filiere).append("\n");
            infos.append("Niveau: ").append(niveau).append("\n");

            // Paiements
            PreparedStatement pst2 = conn.prepareStatement("SELECT SUM(montant) AS total FROM paiement WHERE MatriculeEtudiant = ?");
            pst2.setString(1, matricule);
            ResultSet rs2 = pst2.executeQuery();

            double totalPaye = 0;
            if (rs2.next()) {
                totalPaye = rs2.getDouble("total");
            }

            double montantAttendu = 800000; // tu peux le rendre dynamique
            infos.append("Total payé: ").append(totalPaye).append(" FCFA\n");

            if (totalPaye >= montantAttendu) {
                infos.append("✅ Paiement à jour\n");
            } else {
                infos.append("⚠️ Il reste à payer: ").append(montantAttendu - totalPaye).append(" FCFA\n");
            }

            return infos.toString();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

}
