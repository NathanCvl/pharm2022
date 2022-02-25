package com.proj.pharm2022;

import com.proj.pharm2022.personne.Compte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class InscriptionControl {
    @FXML private TextField id;
    @FXML private PasswordField mdp;
    @FXML private Button confirmer;
    @FXML private Button button1;
    @FXML private Button annuler;

    String motDePasse;
    String identfiant;

   @FXML public void inscription(ActionEvent event) throws SQLException, IOException, InterruptedException {
        identfiant = id.getText();
        motDePasse =mdp.getText();
        if ( event.getSource() == confirmer ) {
            Compte nouveau = new Compte(identfiant, motDePasse);
            nouveau.creeCompteBDD();
            Stage stage = (Stage)  confirmer.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Connexion.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Stage stage = (Stage)  annuler.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Connexion.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }



}
