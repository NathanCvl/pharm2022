package com.proj.pharm2022;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
public class PDFcreator {
    public PDFcreator() {
    }
    void creePDF_Client() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement listeClient = null;


        try {


            con = DriverManager.getConnection(url, "root", "NathanCvl");
            int resultats;
            System.out.println("Connexion réussi");
            String requeteClient = "select * from Client";
            listeClient = con.createStatement();
            Document my_pdf_report = new Document(PageSize.A4);
            PdfWriter.getInstance( my_pdf_report, new FileOutputStream("listeClient.pdf"));
            my_pdf_report.open();
            //we have four columns in our table
            Paragraph paragraph = new Paragraph("Liste Client");
            paragraph.setAlignment(1);
            paragraph.setSpacingAfter(10);
            my_pdf_report.add(paragraph);
            PdfPTable my_report_table = new PdfPTable(5);
            my_report_table.setSpacingAfter(30);
            //create a cell object
            PdfPCell table_cell;
            try (ResultSet rs = listeClient.executeQuery(requeteClient)) {
               table_cell = new PdfPCell(new Phrase("idClient"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("nom"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("prenom"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("adresse"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("tel"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);


                while (rs.next()) {
                    String idClient = rs.getString("idClient");
                    table_cell = new PdfPCell(new Phrase(idClient));
                    my_report_table.addCell(table_cell);
                    String nomClient = rs.getString("nom");
                    table_cell = new PdfPCell(new Phrase(nomClient));
                    my_report_table.addCell(table_cell);
                    String prenomClient = rs.getString("prenom");
                    table_cell = new PdfPCell(new Phrase(prenomClient));
                    my_report_table.addCell(table_cell);
                    String adresse = rs.getString("adresse");
                    table_cell = new PdfPCell(new Phrase(adresse));
                    my_report_table.addCell(table_cell);
                    String tel = rs.getString("tel");
                    table_cell = new PdfPCell(new Phrase(tel));
                    my_report_table.addCell(table_cell);
                }

                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);
                my_pdf_report.close();

                /* Close all DB related objects */
                rs.close();
                listeClient.close();
                con.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void creePDF_Medicament() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement listeMedicament = null;


        try {


            con = DriverManager.getConnection(url, "root", "NathanCvl");
            int resultats;
            System.out.println("Connexion réussi");
            String requeteClient = "select * from Medicament";
            listeMedicament= con.createStatement();
            Document my_pdf_report = new Document(PageSize.A4);
            PdfWriter.getInstance( my_pdf_report, new FileOutputStream("listeMédicament.pdf"));
            my_pdf_report.open();
            //we have four columns in our table
            Paragraph paragraph = new Paragraph("Liste Medicament");
            paragraph.setAlignment(1);
            paragraph.setSpacingAfter(10);
            my_pdf_report.add(paragraph);
            PdfPTable my_report_table = new PdfPTable(6);
            my_report_table.setSpacingAfter(50);

            //create a cell object
            PdfPCell table_cell;
            try (ResultSet rs = listeMedicament.executeQuery(requeteClient)) {
                table_cell = new PdfPCell(new Phrase("mID"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("nomMed"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("marqueMed"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("quantiteMed"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("prixMed"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("date Med"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);

                while (rs.next()) {
                    String mID = String.valueOf(rs.getInt("mID"));
                    table_cell = new PdfPCell(new Phrase(mID));
                    my_report_table.addCell(table_cell);
                    String nomMed = rs.getString("nom");
                    table_cell = new PdfPCell(new Phrase(nomMed));
                    my_report_table.addCell(table_cell);
                    String marqueMed = rs.getString("marque");
                    table_cell = new PdfPCell(new Phrase(marqueMed));
                    my_report_table.addCell(table_cell);
                    String quantiteMed = rs.getString("quantite");
                    table_cell = new PdfPCell(new Phrase(quantiteMed));
                    my_report_table.addCell(table_cell);
                    String prixMed = String.valueOf(rs.getInt("prix"));
                    table_cell = new PdfPCell(new Phrase(prixMed));
                    my_report_table.addCell(table_cell);
                    Date dateMed = rs.getDate("dateExp");
                    table_cell = new PdfPCell(new Phrase(String.valueOf(dateMed)));
                    my_report_table.addCell(table_cell);


                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);
                my_pdf_report.close();

                /* Close all DB related objects */
                rs.close();
                listeMedicament.close();
                con.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void creePDF_Vente() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;
        Statement listeMedicament = null;


        try {


            con = DriverManager.getConnection(url, "root", "NathanCvl");
            int resultats;
            System.out.println("Connexion réussi");
            String requeteClient = "select * from Vente";
            listeMedicament= con.createStatement();
            Document my_pdf_report = new Document(PageSize.A4);
            PdfWriter.getInstance( my_pdf_report, new FileOutputStream("listeVente.pdf"));
            my_pdf_report.open();
            //we have four columns in our table
            Paragraph paragraph = new Paragraph("Liste Vente");
            paragraph.setAlignment(1);
            paragraph.setSpacingAfter(10);
            my_pdf_report.add(paragraph);
            PdfPTable my_report_table = new PdfPTable(4);
            my_report_table.setSpacingAfter(50);

            //create a cell object
            PdfPCell table_cell;
            try (ResultSet rs = listeMedicament.executeQuery(requeteClient)) {
                table_cell = new PdfPCell(new Phrase("ID Vente"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("ID Client"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("date"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);
                table_cell = new PdfPCell(new Phrase("montant €"));
                table_cell.setBackgroundColor(new BaseColor(0, 173, 239));
                my_report_table.addCell(table_cell);

                while (rs.next()) {
                    String mID = String.valueOf(rs.getInt("idVente"));
                    table_cell = new PdfPCell(new Phrase(mID));
                    my_report_table.addCell(table_cell);
                    String nomMed = rs.getString("client_id");
                    table_cell = new PdfPCell(new Phrase(nomMed));
                    my_report_table.addCell(table_cell);
                    String marqueMed = rs.getString("date");
                    table_cell = new PdfPCell(new Phrase(marqueMed));
                    my_report_table.addCell(table_cell);
                    String quantiteMed = rs.getString("montant");



                }
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);
                my_pdf_report.close();

                /* Close all DB related objects */
                rs.close();
                listeMedicament.close();
                con.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
