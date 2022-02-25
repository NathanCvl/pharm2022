package com.proj.pharm2022.personne;

import com.proj.pharm2022.personne.Personne;

import java.sql.*;

public class Client extends Personne {

    public Integer id;
    public Client(Integer id ,String nom, String prenom, String tel, String adresse) {
        super(nom, prenom, tel, adresse);
        this.id=id;
    }
    @SuppressWarnings("RedundantThrows")
    public void creeClientBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "root", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("insert into Client values(idClient,?,?,?,?)");
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
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "root", "nathancvl");
            int resultats;
            System.out.println("Connexion réussi");
            PreparedStatement preparedStatement = con.prepareStatement("update Client SET NomClient=?,PrenomClient=?,tel=?,adresse=? where idClient=?");
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
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM Client where idClient=?");

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
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client(String nom, String prenom, String tel, String adresse) {
        super(nom, prenom, tel, adresse);
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

    @Override
    public String getAdresse() {
        return super.getAdresse();
    }

    @Override
    public void setAdresse(String adresse) {
        super.setAdresse(adresse);
    }

    @Override
    public String getTel() {
        return super.getTel();
    }

    @Override
    public void setTel(String tel) {
        super.setTel(tel);
    }
}
