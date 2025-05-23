/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLEUR;

import DAO.DataBase;
import DAO.DbConnect;
import MODELE.Caisse;
import MODELE.Etudiant;
import MODELE.Paiement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class TraitementCaisse {
    
    public Etudiant rechercherEtudiant(String Matricule){
//        DbConnect db = new DbConnect();
//        DBC.connect();
        DataBase db = new DataBase();
        Connection conn=null;
        Etudiant e = null;

        try {
            db.connection();
            conn = db.getConnectBD();
            String req = "SELECT * FROM etudiant WHERE Matricule = ?";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setString(1, Matricule); // "Matricule" est ta variable Java contenant le matricule recherché
            ResultSet rs = pstmt.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    e = new Etudiant();
                    e.setMatricule(rs.getString("Matricule"));
                    e.setPrenom(rs.getString("Prenom"));
                    e.setNom(rs.getString("Nom"));
                    e.setFiliere(rs.getString("Filiere"));
                    e.setNiveau(rs.getString("Niveau"));
                }
            }
             return e;
        } catch (SQLException ex) {
            Logger.getLogger(TraitementCaisse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return e;
       
    }
    
    public int verifMoisPaiementEtudiant(String matricule, String mois, String objet){
        int response = 0;
        DataBase db = new DataBase();
        int count = 0;
        try {
            db.connection();
            Connection conn = db.getConnectBD();
            PreparedStatement prepare = conn.prepareStatement("SELECT COUNT(*) FROM paiement WHERE MatriculeEtudiant = ? AND Mois= ? AND Objet=? ");
            prepare.setString(1, matricule);
            prepare.setString(2, mois);
            prepare.setString(3, objet);
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
    
//    public String getMoisPrecedent(String moisCourant){
//        Map<Chaîne, Entier> map = new HashMap<Chaîne, Entier>();
//        map.put( "Janvier" , 1 );
//        map.put( "Février" , 2 );
//        carte.put( "Mars" , 3 );
//        map.put( "Avril" , 4 );
//        map.put( "Mai" , 5 );
//        map.put( "Juin" , 6 );
//        map.put( "Juillet" , 7 );
//        map.put( "Octobre" , 10 );
//        map.put( "Novembre" , 11 );
//        map.put( "Décembre" , 12 );
//        LocalDate dateCourant = LocalDate. de ( 2025 , map.get(moisCourant), 1 );
//        LocalDate moisPrecedent = dateCourant.minusMonths( 1 );
//        Chaîne moisAnglais = moisPrecedent.getMonth().name().toLowerCase();
//
//        Map<String, String> mapFrenc = new HashMap<String, String>();
//        mapFrenc.put( "janvier" , "janvier" );
//        mapFrenc.put( "février" , "Février" );
//        mapFrenc.put( "mars" , "Mars" );
//        mapFrenc.put( "avril" , "Avril" );
//        mapFrenc.put( "mai" , "Mai" );
//        mapFrenc.put( "juin" , "Juin" );
//        mapFrenc.put( "juillet" , "Juillet" );
//        mapFrenc.put( "octobre" , "octobre" );
//        mapFrenc.put( "novembre" , "novembre" );
//        mapFrenc.put( "décembre" , "décembre" );
//
//        return mapFrenc.get(moisAnglais); 
// }
    
    public String getPremierMoisNonPaye(String matricule, String objet) {
    String[] listeMois = { "Octobre", "Novembre", "Decembre", "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet" };

    for (String mois : listeMois) {
        int etatPaiement = verifMoisPaiementEtudiant(matricule, mois, objet);
        if (etatPaiement == 0) {
            return mois; // Retourne le premier mois non payé
        }
    }
    return null; // Tous les mois sont payés
}

    
    
    
    public void Ajouter(Caisse C){
        DbConnect DBC = new DbConnect();
        DBC.connect();
        
        String req = "INSERT INTO caisse (Matricule,Prenom,Nom,Filiere,Niveau,Montant,Objet,Date,Mois)VALUES('"
                +C.getMatricule()+"', '"+C.getPrenom()+"', '"+C.getNom()+"', '"+C.getFiliere()+"', '"
                +C.getNiveau()+"', '"+C.getMontant()+"', '"+C.getObjet()+"','"+C.getDate()+"', '"+C.getMois()+"')";
            
            try {
                DBC.Stat.executeUpdate(req);
            } catch (SQLException ex) {
                Logger.getLogger(TraitementCaisse.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
    
    
    public boolean ajouterPaiement ( String MatriculeEtudiant, String MatriculeCaissier, float Montant, String Statut, String Mois, String Objet ) {
         DataBase db = new DataBase();
        Connection conn=null;
        Paiement e = null;
        try  {
            db.connection();
            conn = db.getConnectBD();
            String sql = "INSERT INTO paiement (MatriculeEtudiant, MatriculeCaissier, Montant, Date, Statut, Mois, Objet) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,MatriculeEtudiant );
            pst.setString(2, MatriculeCaissier);
            pst.setFloat(3, Montant);
            pst.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            pst.setString(5, Statut);
            pst.setString(6, Mois);
            pst.setString(7, Objet);
            
            return pst.executeUpdate() > 0;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
    
//    public List<Caisse> getPaiementsParEtudiant(String matricule) {
//    // Implémentation avec requête SQL par exemple :
//    // SELECT * FROM caisse WHERE matricule = ?
//        return null;
//    // Implémentation avec requête SQL par exemple :
//    // SELECT * FROM caisse WHERE matricule = ?
//    }
//    
//    public boolean estEtudiantAJour(String matricule, String objet) {
//    String moisNonPaye = getPremierMoisNonPaye(matricule, objet);
//    return moisNonPaye == null;
//}



        
}
