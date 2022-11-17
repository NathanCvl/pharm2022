package com.proj.pharm2022;

import com.proj.pharm2022.application.Compte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ConnexionControl {
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private TextField id;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button btn1;
    @FXML
    Label l;
    @FXML
    private Button btn2;
    String identifiant;
    String password;
    public void connexion(ActionEvent event) throws IOException, SQLException, InterruptedException {
        Stage stage;
        Parent root;
        if(event.getSource()==btn1) {
            identifiant=id.getText();
            password=mdp.getText();

            if ( verifCompteBDD() ) {

                stage = (Stage) btn1.getScene().getWindow();
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/Accueil.fxml")));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            }


        }
        else {
            stage = (Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/Inscription.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
     l.setText("Mauvais mot de passe");


    }



    public boolean verifCompteBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java";
        Connection con = null;


        try {


            con = DriverManager.getConnection(url, "root", "NathanCvl");
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT identifiant,motDePasse FROM Compte");

                while (rs.next()){
                    if ( rs.getString(1).equals(identifiant) && rs.getString(2).equals(password) ){
                        l.setText("Connexion en cours...");
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

        void verifCompte(){
        Compte compte = new Compte(identifiant,password);
    }
    public TextField getId() {
        return id;
    }

    public void setId(TextField id) {
        this.id = id;
    }

    public PasswordField getMdp() {
        return mdp;
    }

    public void setMdp(PasswordField mdp) {
        this.mdp = mdp;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


