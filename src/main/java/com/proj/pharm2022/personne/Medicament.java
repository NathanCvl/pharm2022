package com.proj.pharm2022.personne;

import com.mysql.cj.result.SqlDateValueFactory;
import javafx.scene.control.DatePicker;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class Medicament {
    Integer id;
    String nom;
    String marque;
    Integer quantite;
    Integer prix;
    Date date;

    public Medicament(String nom, String marque, Integer quantite, Integer prix, Date date) {
        this.nom = nom;
        this.marque = marque;
        this.quantite = quantite;
        this.prix = prix;
        this.date = date;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Medicament(Integer id, String nom, String marque, Integer quantite, Integer prix, Date date) {
        DateTimeFormatter.ofPattern("dd-MM-yyyy");

        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.quantite = quantite;
        this.prix = prix;
        this.date = date;
    }

    public void ajoutMedicamentBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "root", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("insert into medicament values(mID,?,?,?,?,?)");
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2,marque);
            preparedStatement.setInt(3, quantite);
            preparedStatement.setInt(4,prix);
            preparedStatement.setDate(5, date);

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
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "root", "nathancvl");
            int resultats;
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM medicament  where mID=?");

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
    public void modifierMedicamenttBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "root", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("update medicament SET nomMed=?,marqueMed=?,quantiteMed=? ,prixMed=?,dateMed=?where mID=?");
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2, marque);
            preparedStatement.setInt(3,quantite);
            preparedStatement.setInt(4, prix);
            preparedStatement.setDate(5, date);
            preparedStatement.setInt(6, id);
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

