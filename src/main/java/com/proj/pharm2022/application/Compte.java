package com.proj.pharm2022.application;

import java.sql.*;
import java.util.Objects;

public class Compte{
    public int id;
    private  String identifiant;
    private  String motDePasse;
    String nom;
    String prenom;

    public Compte(String identifiant, String motDePasse) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }

    public Compte(int id, String identifiant, String motDePasse, String nom, String prenom) {
        this.id = id;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Compte() {

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


    public void creeCompteBDD() throws SQLException {
        String url = "jdbc:mysql://pharma.caem2tgou5ub.eu-west-3.rds.amazonaws.com/Projet2022";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "admin", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("insert into Compte values(id,?,?,null,null,null)");
            preparedStatement.setString(1,identifiant);
            preparedStatement.setString(2, motDePasse);
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
