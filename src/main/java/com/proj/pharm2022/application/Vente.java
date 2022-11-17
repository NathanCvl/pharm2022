package com.proj.pharm2022.application;

import java.io.Serializable;
import java.sql.*;
import java.time.LocalDate;


public class Vente implements Serializable {

    private int idVente;
    private int idClient;
    private LocalDate date;
    private int montant;

    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
    }

    public Date getDate() {
        return Date.valueOf(date);
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Vente(int idVente, int idClient, LocalDate date, int montant) {
        this.idVente = idVente;
        this.idClient = idClient;
        this.date = date;
        this.montant = montant;
    }

    public Vente(int idClient, LocalDate date) {
        this.idClient = idClient;
        this.date = date;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void supprimerVenteBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement stmt = null;


        try {


            con = DriverManager.getConnection(url, "admin", "NathanCvl");
            int resultats;
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM Vente where idVente=?");

            preparedStatement.setInt(1, idVente);
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

    public void finVente(int montant){
        String url = "jdbc:mysql://localhost:3306/java";
            Connection con;


        try {


                con = DriverManager.getConnection(url, "root", "NathanCvl");
                System.out.println("Connexion réussi");
                PreparedStatement preparedStatement = con.prepareStatement("insert into Vente values(idVente,?,?,?)");
                preparedStatement.setInt(1,idClient);
                preparedStatement.setDate(2, Date.valueOf(date));
                preparedStatement.setInt(3,montant);
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
