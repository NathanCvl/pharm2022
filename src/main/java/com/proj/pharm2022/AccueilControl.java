package com.proj.pharm2022;

import com.proj.pharm2022.personne.Client;
import com.proj.pharm2022.personne.Medicament;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class AccueilControl implements Initializable {

    @FXML TabPane medicamentParametre1;
    @FXML private Button supprimer1;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button modifier1;
    @FXML
    private Button goToAdd;
    @FXML
    private Button annuler1;
    @FXML
    private TextField idMedicamentMod;
    @FXML
    private TextField nomMedicamentMod;
    @FXML
    private TextField marqueMedicamentMod;
    @FXML
    private TextField stockMedicamentMod;
    @FXML
    private TextField prixMedicamentMod;
    @FXML
    private DatePicker dateMedicamentMod;
    @FXML
    private Button ajtMed;
    @FXML private Button imprimer;
    @FXML
    private TextField nomC;
    @FXML
    private TextField prenomC;
    @FXML
    private TextField telC;
    @FXML
    private TextField adresseC;
    @FXML
    private AnchorPane root;
    @FXML
    private Button valider, annuler, modifClient;
    @FXML
    private TableView<Client> tableClient;
    @FXML
    private TableColumn<Client, Integer> idClient;
    @FXML
    private TableColumn<Client, String> nomClient;
    @FXML
    private TableColumn<Client, String> prenomClient;
    @FXML
    private TableColumn<Client, String> adresseClient;
    @FXML
    private TableColumn<Client, String> telClient;
    @FXML
    TableColumn<Medicament, Integer> idMedicamentTab;
    @FXML
    TableColumn<Medicament, Integer> prixMedicamentTab;
    @FXML
    TableColumn<Medicament, Integer> stockMedicamentTab;
    @FXML
    private TableColumn<Medicament, String> marqueMedicamentTab;
    @FXML
    private TableColumn<Medicament,String>nomMedicamentTab;
    @FXML
    private TableColumn<Medicament, java.util.Date> dateMedTab;
    Statement listeClient;
    Statement listeMedicament;
    @FXML
    Button rafraichir;
    @FXML
    private ComboBox comboBox;
    @FXML
    private TabPane clientParametre;
    @FXML
    private TabPane medicamentParametre;
    @FXML
    private Tab modifierClientTab;
    @FXML
    private Tab modifierMedicamentTab;
    @FXML
    private Tab ajouterClient;
    @FXML
    private Tab ajouterMedicament;
    @FXML
    private TextField idC1, nomC1, prenomC1, telC1, adresseC1;
    @FXML
    private TextField nomMed;
    @FXML
    private TextField marqueMed;
    @FXML
    private TextField quantiteMed;
    @FXML
    private TextField prixMed;
    @FXML
    private DatePicker dateMed;
    @FXML
    private TableView<Medicament> tableMedicament;
    public String nom;
    public String prenom;
    public String adresse;
    public String tel;
    public Integer id;

    public Integer idMedicament;
    public String nomMedicament;
    public String marqueMedicament;
    public Integer quantiteMedicament;
    public Integer prixMedicament;
    public LocalDate dateExpMedicament;
    ObservableList<Client> obListeClient = FXCollections.observableArrayList();
    ObservableList<Medicament> obListeMedicament = FXCollections.observableArrayList();
    public void getinfoClient(ActionEvent event) {
        Client client = tableClient.getSelectionModel().getSelectedItem();
        SingleSelectionModel<Tab> selectionModel = clientParametre.getSelectionModel();
        selectionModel.select(modifierClientTab);
        idC1.setText(client.id.toString());
        idC1.setEditable(false);
        nomC1.setText(client.nom);
        prenomC1.setText(client.prenom);
        telC1.setText(client.tel);
        adresseC1.setText(client.adresse);
    }
    public void btnAjouterClient(ActionEvent event) {
        SingleSelectionModel<Tab> selectionModel = clientParametre.getSelectionModel();
        selectionModel.select(ajouterClient);

    }
    public void getinfoMedicament(SortEvent<TableView> event){
        Medicament medicament = tableMedicament.getSelectionModel().getSelectedItem();
        SingleSelectionModel<Tab> selectionModel = medicamentParametre.getSelectionModel();
        selectionModel.select(modifierMedicamentTab);
        idMedicamentMod.setEditable(false);
        idMedicamentMod.setText(medicament.getId().toString());
        nomMedicamentMod.setText(medicament.getNom());
        marqueMedicamentMod.setText(medicament.getMarque());
        stockMedicamentMod.setText(medicament.getQuantite().toString());
        dateMedicamentMod.getEditor().setText(medicament.getDate().toString());


    }

    public void supprimerClient(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Souhaitez-vous vraiment supprimer ce client ?");
        Optional<ButtonType> result = alert.showAndWait();
        if ( result.isPresent() ) {
            if ( result.get() == ButtonType.OK ) {
                Client client = tableClient.getSelectionModel().getSelectedItem();
                client.supprimerClientBDD();
            }
        }
    }
    public void supprimerMedicament(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Souhaitez-vous vraiment supprimer ce médicament ?");
        Optional<ButtonType> result = alert.showAndWait();
        if ( result.isPresent() ) {
            if ( result.get() == ButtonType.OK ) {
                Medicament medicament = tableMedicament.getSelectionModel().getSelectedItem();
                medicament.supprimerMedicamentBDD();
            }
        }
    }

    public void modifierClient(ActionEvent event) throws SQLException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Souhaitez-vous vraiment modifier ce client ?");
        Optional<ButtonType> result = alert.showAndWait();
        if ( result.isPresent() ) {
            if ( result.get() == ButtonType.OK )
                nom = nomC1.getText();
                prenom = prenomC1.getText();
                tel = telC1.getText();
                adresse = adresseC1.getText();
                id = Integer.valueOf(idC1.getText());
                Client client = new Client(id, nom, prenom, tel, adresse);
                client.modifierClientBDD();
        }


    }
    public void afficherBox(ActionEvent event){
        System.out.println(comboBox.getEditor().getText());

    }
    public void modifierMedicament(ActionEvent event) throws SQLException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Souhaitez-vous vraiment modifier ce médicament ?");
        Optional<ButtonType> result = alert.showAndWait();
        if ( result.isPresent() ) {
            if ( result.get() == ButtonType.OK )
                idMedicamentMod.setEditable(false);
                nomMedicament = nomMedicamentMod.getText();
                marqueMedicament = marqueMedicamentMod.getText();
                quantiteMedicament = Integer.parseInt(stockMedicamentMod.getText());
                prixMedicament = Integer.parseInt(prixMedicamentMod.getText());
                dateExpMedicament = (dateMedicamentMod.getValue());
                Medicament medicament = new Medicament(Integer.parseInt(idMedicamentMod.getText()), nomMedicament, marqueMedicament, quantiteMedicament, prixMedicament, Date.valueOf(dateExpMedicament));
                medicament.modifierMedicamenttBDD();
        }
    }


public void imprimerListeMed(ActionEvent event) throws SQLException {
        PDFcreator pdFcreator = new PDFcreator();
        pdFcreator.creePDF_Medicament();
}
    public void ajouterClient(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ajout du client effectué !");
        obListeClient.clear();
        Optional<ButtonType> result = alert.showAndWait();
        if ( result.isPresent() ) {
            if ( result.get() == ButtonType.OK ) {
                nom = nomC.getText();
                prenom = prenomC.getText();
                tel = telC.getText();
                adresse = adresseC.getText();

                Client client = new Client(0, nom, prenom, tel, adresse);
                client.creeClientBDD();
                String url = "jdbc:mysql://localhost:3306/java";
                Connection con;
                try {
                    con = DriverManager.getConnection(url, "root", "nathancvl");
                    String requeteListeMusiques = "select *from Client";
                    listeClient = con.createStatement();
                    try (ResultSet rs = listeClient.executeQuery(requeteListeMusiques)) {

                        while (rs.next()) {
                            obListeClient.add(new Client(rs.getInt("idClient"), rs.getString("NomClient"), rs.getString("PrenomClient"), rs.getString("tel"), rs.getString("adresse")));
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                idClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));
                nomClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
                prenomClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrenom()));
                telClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTel()));
                adresseClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getAdresse()));
                tableClient.setItems(obListeClient);
            }
        }
    }

    public void annulerClient(ActionEvent event) {
        nomC.clear();
        prenomC.clear();
        telC.clear();
        adresseC.clear();

        nomC1.clear();
        prenomC1.clear();
        telC1.clear();
        adresseC1.clear();
    }
    public void annulerMedicament(ActionEvent event) {
        nomMed.clear();
        marqueMed.clear();
        quantiteMed.clear();
        prixMed.clear();

        nomMedicamentMod.clear();
        marqueMedicamentMod.clear();
        stockMedicamentMod.clear();
        prixMedicamentMod.clear();



    }

    public void ajouterMed(ActionEvent event) throws SQLException {
        nomMedicament = nomMed.getText();
        marqueMedicament = marqueMed.getText();
        quantiteMedicament = Integer.valueOf(quantiteMed.getText());
        prixMedicament = Integer.valueOf(prixMed.getText());
        dateExpMedicament = (dateMed.getValue());
        Medicament medicament = new Medicament(nomMedicament, marqueMedicament, quantiteMedicament, prixMedicament, Date.valueOf(dateExpMedicament));
        medicament.ajoutMedicamentBDD();
        obListeMedicament.clear();
        String url2 = "jdbc:mysql://localhost:3306/java";
        Connection con;
            con = DriverManager.getConnection(url2, "root", "nathancvl");
            String requeteClient = "select * from Client";
            String requeteMedicament = "select * from medicament";
            listeMedicament = con.createStatement();
            try (ResultSet medSet = listeMedicament.executeQuery(requeteMedicament)) {
                while (medSet.next()) {
                    obListeMedicament.add(new Medicament(medSet.getInt(1), medSet.getString(2), medSet.getString(3), medSet.getInt(4), medSet.getInt(5), medSet.getDate(6)));
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }

        idMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));
        nomMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
        marqueMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMarque()));
        stockMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getQuantite()));
        prixMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrix()));
        dateMedTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDate()));
        tableMedicament.setItems(obListeMedicament);


    }

    public void imprimerListeClient(ActionEvent event) throws SQLException {
        PDFcreator pdFcreator = new PDFcreator();
        pdFcreator.creePDF_Client();
        File file;
        /* Création de la WebView et du moteur */
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        /*
         * Le chemin absolu du viewer de pdfjs Vous pouvez télécharger pdfjs et le
         * viewer sur https://mozilla.github.io/pdf.js/getting_started
         */
        String pdfjsViewerPath = "file:/Users/nathan/IdeaProjects/pharm2022/src/main/pdfjs-2/web/viewer.html";

        /* Le chemin absolu du fichier PDF à ouvrir */
        String pdfFilePath = "file:/Users/nathan/IdeaProjects/pharm2022/listeClient.pdf";

        /* Concaténation des chemins absolus avec l'argument ?file= */
        String pdfjsAndFileConcat = pdfjsViewerPath + "?file=" + pdfFilePath;

        /* Charge le contenu HTML */
        webEngine.loadContent("<!DOCTYPE html>\n"
                + "<html lang=\"fr\">\n"
                + "\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Document PDF</title>\n"
                + "\n"
                + "    <style>\n"
                + "        html,\n"
                + "        body {\n"
                + "            /* reset */\n"
                + "            margin: 0;\n"
                + "            height: 100%;\n"
                + "            /* important pour enlever la barre de défilement verticale */\n"
                + "            overflow: hidden;\n"
                + "        }\n"
                + "\n"
                + "        #pdf-viewer {\n"
                + "            /* Plein écran */\n"
                + "            width: 100%;\n"
                + "            height: 100%;\n"
                + "            /* important pour enlever la barre de défilement verticale */\n"
                + "            border: none;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "\n"
                + "    <!--\n"
                + "    vous pouvez télécharger pdfjs et le viewer sur https://mozilla.github.io/pdf.js/getting_started/\n"
                + "    -->\n"
                + "    <iframe id=\"pdf-viewer\" src=\""+ pdfjsAndFileConcat  +"\"></iframe>\n"
                + "\n"
                + "</body>\n"
                + "\n"
                + "</html>");


        Scene scene = new Scene(webView, 1280, 720);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();


    }

public void refreshTable(ActionEvent event){
        obListeMedicament.clear();
        obListeClient.clear();
        String url2 = "jdbc:mysql://localhost:3306/java";
        Connection con;
    try {
        con = DriverManager.getConnection(url2, "root", "nathancvl");
        String requeteClient = "select * from Client";
        String requeteMedicament = "select * from medicament";
        listeClient = con.createStatement();
        listeMedicament = con.createStatement();
        try (ResultSet rs = listeClient.executeQuery(requeteClient) ) {

            while (rs.next()) {
                obListeClient.add(new Client(rs.getInt("idClient"), rs.getString("NomClient"), rs.getString("PrenomClient"), rs.getString("tel"), rs.getString("adresse")));
            }
        }
        try(ResultSet medSet = listeMedicament.executeQuery(requeteMedicament)) {
            while (medSet.next()){
                obListeMedicament.add(new Medicament(medSet.getInt(1),medSet.getString(2),medSet.getString(3),medSet.getInt(4),medSet.getInt(5), medSet.getDate(6)));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    idMedicamentTab.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getId()));
    nomMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
    marqueMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMarque()));
    stockMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getQuantite()));
    prixMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrix()));
    dateMedTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDate()));



    idClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));
    nomClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
    prenomClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrenom()));
    telClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTel()));
    adresseClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getAdresse()));
    tableMedicament.setItems(obListeMedicament);
    tableClient.setItems(obListeClient);
}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String url2 = "jdbc:mysql://localhost:3306/java";
        Connection con;
        try {
            con = DriverManager.getConnection(url2, "root", "nathancvl");
            String requeteClient = "select * from Client";
            String requeteMedicament = "select * from medicament";
            listeClient = con.createStatement();
            listeMedicament = con.createStatement();
            try (ResultSet rs = listeClient.executeQuery(requeteClient) ) {

                while (rs.next()) {
                    obListeClient.add(new Client(rs.getInt("idClient"), rs.getString("NomClient"), rs.getString("PrenomClient"), rs.getString("tel"), rs.getString("adresse")));
                }
            }
            try(ResultSet medSet = listeMedicament.executeQuery(requeteMedicament)) {
                while (medSet.next()){
                    obListeMedicament.add(new Medicament(medSet.getInt(1),medSet.getString(2),medSet.getString(3),medSet.getInt(4),medSet.getInt(5), medSet.getDate(6)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        idMedicamentTab.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getId()));
        nomMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
        marqueMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMarque()));
        stockMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getQuantite()));
        prixMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrix()));
        dateMedTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDate()));



        idClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));
        nomClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
        prenomClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrenom()));
        telClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTel()));
        adresseClient.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getAdresse()));
        tableMedicament.setItems(obListeMedicament);
        tableClient.setItems(obListeClient);



    }



}
