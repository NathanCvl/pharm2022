package com.proj.pharm2022.personne;
import java.sql.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compte {
    private static final AtomicInteger increm = new AtomicInteger(0);
    private final int id;
    private  String identifiant;
    private  String motDePasse;
    String nom;
    String prenom;
    Pharmacien pharmacien;

    public Compte(String identifiant,String motDePasse,Pharmacien pharmacien) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.pharmacien = pharmacien;
        id=increm.incrementAndGet();
        nom = pharmacien.getNom();
        prenom = pharmacien.getPrenom();

    }

    public Compte(String identifiant, String motDePasse) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        id=increm.incrementAndGet();
    }

    public Boolean verifCompte(Compte compte, String id, String mdp){
        return (Objects.equals(compte.identifiant, id) && Objects.equals(compte.motDePasse, mdp));
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Pharmacien getPharmacien() {
        return pharmacien;
    }

    public void setPharmacien(Pharmacien pharmacien) {
        this.pharmacien = pharmacien;
    }

    public void creeCompteBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "root", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("insert into compte values(idCompte,?,?)");
            preparedStatement.setString(1,identifiant);
            preparedStatement.setString(2, motDePasse);
            try {
                stmt = con.createStatement();
                int nbMaj = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
