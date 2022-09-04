package com.proj.pharm2022.application;

import java.sql.*;
public class Client  {
    public int id;
    public String nom;
    public String prenom;
    public String adresse;
    public String tel;

    public Client(int id, String nom, String prenom, String adresse, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Client() {

    }

    public Client(String nom, String prenom, String tel, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
    }

    public void creeClientBDD() throws SQLException {
        String url = "jdbc:mysql://pharma.caem2tgou5ub.eu-west-3.rds.amazonaws.com/Projet2022";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "admin", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("insert into Client values(id,?,?,?,?)");
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3,tel);
            preparedStatement.setString(4, adresse);
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
    public void modifierClientBDD() throws SQLException {
        String url = "jdbc:mysql://pharma.caem2tgou5ub.eu-west-3.rds.amazonaws.com/";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "admin", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("update Client SET nom=?,prenom=?,tel=?,adresse=? where id=?");
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3,tel);
            preparedStatement.setString(4, adresse);
            preparedStatement.setInt(5, id);
            try {
                stmt = con.createStatement();
                int nbMaj = preparedStatement.executeUpdate();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void supprimerClientBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "root", "nathancvl");
            int resultats;
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM Client where id=?");

            preparedStatement.setInt(1, id);
            try {
                stmt = con.createStatement();
                int nbMaj = preparedStatement.executeUpdate();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
