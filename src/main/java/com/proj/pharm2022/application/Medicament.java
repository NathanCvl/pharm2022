package com.proj.pharm2022.application;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class Medicament {


    public int mId;
    public String nom;

    public String marque;
    public Integer quantite;
    public Integer prix;
    public  Date dateExp;

    public Medicament(String nom, String marque, Integer quantite, Integer prix, Date date) {
        this.nom = nom;
        this.marque = marque;
        this.quantite = quantite;
        this.prix = prix;
        this.dateExp = date;

    }

    public Medicament(int id, String nom, String marque, Integer quantite, Integer prix, Date date) {
        DateTimeFormatter.ofPattern("dd-MM-yyyy");

        this.mId = id;
        this.nom = nom;
        this.marque = marque;
        this.quantite = quantite;
        this.prix = prix;
        this.dateExp = date;
    }

    public Medicament() {

    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateExp() {
        return dateExp;
    }

    public void setDateExp(Date dateExp) {
        this.dateExp = dateExp;
    }

    public void ajoutMedicamentBDD() throws SQLException {
        String url = "jdbc:mysql://pharma.caem2tgou5ub.eu-west-3.rds.amazonaws.com/Projet2022";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "admin", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("insert into Medicament values(mId,?,?,?,?,?)");
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2,marque);
            preparedStatement.setInt(3, quantite);
            preparedStatement.setInt(4,prix);
            preparedStatement.setDate(5, dateExp);

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

    public void supprimerMedicamentBDD() throws SQLException {
        String url = "jdbc:mysql://pharma.caem2tgou5ub.eu-west-3.rds.amazonaws.com/Projet2022";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "admin", "nathancvl");
            int resultats;
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM Medicament  where mId=?");

            preparedStatement.setInt(1,mId);
            try {
                con.createStatement();
                int nbMaj = preparedStatement.executeUpdate();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierMedicamenttBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Projet2022";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "admin", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("update Medicament SET nom=?,marque=?,quantite=? ,prix=?,dateExp =? where mId=?");
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2, marque);
            preparedStatement.setInt(3,quantite);
            preparedStatement.setInt(4, prix);
            preparedStatement.setDate(5, dateExp);
            preparedStatement.setInt(6, (Integer) mId);
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


}

