package com.proj.pharm2022;


import com.proj.pharm2022.application.Client;
import com.proj.pharm2022.application.Medicament;
import com.proj.pharm2022.application.Panier;
import com.proj.pharm2022.application.Vente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class AccueilControl implements Initializable {
    @FXML
    private TableColumn<Vente,Integer> idVente;
    @FXML
    private TableColumn<Vente,Integer> clientVente;
    @FXML
    private TableColumn<Vente,Date> dateVente;
    @FXML
    private TableColumn<Vente,Integer> montantVente;
    int quantiteArticleVar;


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
    @FXML
    private TextField adresseC;

    @FXML
    private TextField adresseC1;
    @FXML
    private Label prixTotal;
    @FXML
    private TableColumn<Client, String> adresseClient;

    @FXML
    private TableColumn<Client, String> adresseClient1;

    @FXML
    private TextField adresseClientVente;

    @FXML
    private Tab ajouterClient;

    @FXML
    private Tab ajouterMedicament;

    @FXML
    private Button ajtMed;

    @FXML
    private Button annuler;

    @FXML
    private Button annuler1;

    @FXML
    private TabPane clientParametre;

    @FXML
    private DatePicker dateMed;

    @FXML
    private TableColumn<Medicament, java.util.Date> dateMedTab;

    @FXML
    private TableColumn<Medicament, Date> dateMedTab1;

    @FXML
    private DatePicker dateMedicamentMod;

    @FXML
    private Button goToAdd;

    @FXML
    private TableColumn<Panier,Integer> idArticle;

    @FXML
    private TextField idC1;

    @FXML
    private TableColumn<Client, Integer> idClient;

    @FXML
    private TableColumn<Client, Integer> idClient1;
@FXML
private TabPane panePrincipal;
    @FXML
    private TextField idClientVente;

    @FXML
    private TextField idMedicamentMod;

    @FXML
    private TableColumn<Medicament, Integer> idMedicamentTab;

    @FXML
    private TableColumn<Medicament, Integer> idMedicamentTab1;

    @FXML
    private TableColumn<Panier, String> marqueArticle;

    @FXML
    private TextField marqueMed;

    @FXML
    private TextField marqueMedicamentMod;

    @FXML
    private TableColumn<Medicament, String> marqueMedicamentTab;

    @FXML
    private TableColumn<Medicament, String> marqueMedicamentTab1;

    @FXML
    private TextField mediFiltre;

    @FXML
    private TabPane medicamentParametre;

    @FXML
    private Button modifClient;

    @FXML
    private Button modifier;

    @FXML
    private Button modifier1;

    @FXML
    private Tab modifierClientTab;

    @FXML
    private Tab modifierMedicamentTab;

    @FXML
    private TableColumn<Panier, String> nomArticle;

    @FXML
    private TextField nomC;

    @FXML
    private TextField nomC1;

    @FXML
    private TableColumn<Client,String> nomClient;

    @FXML
    private TableColumn<Client, String> nomClient1;

    @FXML
    private TextField nomClientVente;

    @FXML
    private TextField nomMed;
    @FXML
    private Tab tabMed;
    @FXML
    private TextField nomMedicamentMod;

    @FXML
    private TableColumn<Medicament, String> nomMedicamentTab;

    @FXML
    private TableColumn<Medicament, String > nomMedicamentTab1;

    @FXML
    private Pane paneAfficheClient;
    @FXML
    private Tab ajouterVente;
    @FXML
    private Pane paneChoixClient;

    @FXML
    private TextField prenomC;

    @FXML
    private TextField prenomC1;

    @FXML
    private TableColumn<Client, String> prenomClient;

    @FXML
    private TableColumn<Client, String> prenomClient1;

    @FXML
    private TextField prenomClientVente;

    @FXML
    private TableColumn<Panier, Integer> prixArticle;

    @FXML
    private TableColumn<Panier, Integer> quantiteArticle;

    @FXML
    private TextField prixMed;

    @FXML
    private TextField prixMedicamentMod;

    @FXML
    private TableColumn<Medicament, Integer > prixMedicamentTab;

    @FXML
    private TableColumn<Medicament, Integer> prixMedicamentTab1;

    @FXML
    private TextField quantiteMed;

    @FXML
    private Button rafraichir;

    @FXML
    private TextField stockMedicamentMod;

    @FXML
    private TableColumn<Medicament, Integer> stockMedicamentTab;

    @FXML
    private TableColumn<Medicament, Integer> stockMedicamentTab1;

    @FXML
    private Button supprimer;

    @FXML
    private Button supprimer1;

    @FXML
    private TableView<Client> tableClient;

    @FXML
    private TableView<Client> tableClient1;

    @FXML
    private TableView<Medicament> tableMedicament;
    Spinner<Integer> spinner = null;

    @FXML
    private TableView<Medicament> tableMedicament1;

    @FXML
    private TableView<Panier> tablePanier;
@FXML
    private Tab tabVente,tabClient;
    @FXML
    private TextField telC;

    @FXML
    private TextField telC1;

    @FXML
    private TableColumn<Client, String> telClient;

    @FXML
    private TableColumn<Client, String> telClient1;

    @FXML
    private TextField telClientVente;

    @FXML
    private Button valider;

    @FXML
    private Button validerChoixMed;

    @FXML
            private TableView<Vente> tableVente;
    ObservableList<Panier> obListeMedicamentAchat = FXCollections.observableArrayList();


@FXML
    public void getinfoClient(ActionEvent event) {
        if (!(tableClient.getSelectionModel().isEmpty())) {
            Client client = tableClient.getSelectionModel().getSelectedItem();
            SingleSelectionModel<Tab> selectionModel = clientParametre.getSelectionModel();
            selectionModel.select(modifierClientTab);
            idC1.setText(String.valueOf(client.id));
            idC1.setEditable(false);
            nomC1.setText(client.nom);
            prenomC1.setText(client.prenom);
            telC1.setText(client.tel);
            adresseC1.setText(client.adresse);
        }
    }
    @FXML
    public void btnAjouterClient(ActionEvent event) {
        SingleSelectionModel<Tab> selectionModels = panePrincipal.getSelectionModel();
        selectionModels.select(tabClient);
        SingleSelectionModel<Tab> selectionModel = clientParametre.getSelectionModel();
        selectionModel.select(ajouterClient);

    }
    @FXML
    public void btnAjouterMedicament(ActionEvent event) {

        SingleSelectionModel<Tab> selectionModels = panePrincipal.getSelectionModel();
        selectionModels.select(tabMed);
        SingleSelectionModel<Tab> selectionModel = medicamentParametre.getSelectionModel();
        selectionModel.select(ajouterMedicament);

    }
    public void btnAjouterVente(ActionEvent event) {

        SingleSelectionModel<Tab> selectionModels = panePrincipal.getSelectionModel();
        selectionModels.select(tabVente);
        SingleSelectionModel<Tab> selectionModel = medicamentParametre.getSelectionModel();
        selectionModel.select(ajouterVente);

    }
    @FXML
    public void getinfoMedicament(ActionEvent event){
        Medicament medicament = tableMedicament.getSelectionModel().getSelectedItem();
        SingleSelectionModel<Tab> selectionModel = medicamentParametre.getSelectionModel();
        selectionModel.select(modifierMedicamentTab);
        idMedicamentMod.setEditable(false);
        idMedicamentMod.setText(String.valueOf(medicament.mId));
        nomMedicamentMod.setText(medicament.getNom());
        marqueMedicamentMod.setText(medicament.getMarque());
        stockMedicamentMod.setText(medicament.getQuantite().toString());
        dateMedicamentMod.getEditor().setText(medicament.getDateExp().toString());


    }









    ///////////////////////////////VENTE/////////////////
    @FXML void supprimerVente(ActionEvent event) throws SQLException {
        Vente vente = tableVente.getSelectionModel().getSelectedItem();
        vente.supprimerVenteBDD();
    }
    @FXML
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
        refreshTable();

    }
    @FXML
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
        refreshTable();

    }

@FXML
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
                Client client = new Client(nom, prenom, tel, adresse);
                client.modifierClientBDD();
        }
    refreshTable();



}

    @FXML
    public void modifierMedicament(ActionEvent event) throws SQLException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Souhaitez-vous vraiment modifier ce médicament ?");
        Optional<ButtonType> result = alert.showAndWait();
        if ( result.isPresent() ) {
            if ( result.get() == ButtonType.OK ) {
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
        refreshTable();

    }



@FXML
    public void ajouterClient(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ajout du client effectué !");
        Optional<ButtonType> result = alert.showAndWait();
        if ( result.isPresent() ) {
            if ( result.get() == ButtonType.OK ) {
                nom = nomC.getText();
                prenom = prenomC.getText();
                tel = telC.getText();
                adresse = adresseC.getText();

                Client client = new Client(nom, prenom, tel, adresse);
                client.creeClientBDD();
            }
        }
    refreshTable();

}
@FXML
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
    @FXML
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
@FXML
    public void ajouterMed(ActionEvent event) throws SQLException {
        nomMedicament = nomMed.getText();
        marqueMedicament = marqueMed.getText();
        quantiteMedicament = Integer.valueOf(quantiteMed.getText());
        prixMedicament = Integer.valueOf(prixMed.getText());
        dateExpMedicament = (dateMed.getValue());
        Medicament medicament = new Medicament(nomMedicament, marqueMedicament, quantiteMedicament, prixMedicament, Date.valueOf(dateExpMedicament));
        medicament.ajoutMedicamentBDD();
        refreshTable();




    }
@FXML
    public void imprimerListeClient(ActionEvent event) throws SQLException, IOException {
    PDFcreator pdFcreator = new PDFcreator();
    pdFcreator.creePDF_Client();
    File file = new File("listeClient.pdf");

    //Vérifier si le système prend en charge la classe Desktop ou non
    Desktop Desktop = null;
    if(!java.awt.Desktop.isDesktopSupported()){
        System.out.println("Desktop n'est pas prise en charge");
        return;
    }

    Desktop d = java.awt.Desktop.getDesktop();
    if(file.exists())
        d.open(file);

    }
    @FXML
    public void imprimerListeMedicament(ActionEvent event) throws SQLException, IOException {
        PDFcreator pdFcreator = new PDFcreator();
        pdFcreator.creePDF_Medicament();
        File file = new File("listeMedicament.pdf");

        //Vérifier si le système prend en charge la classe Desktop ou non
        if(!java.awt.Desktop.isDesktopSupported()){
            System.out.println("Desktop n'est pas prise en charge");
            return;
        }

        Desktop d = java.awt.Desktop.getDesktop();
        if(file.exists())
            d.open(file);
    }


    @FXML
    public void imprimerListeVente(ActionEvent event) throws SQLException, IOException {
        PDFcreator pdFcreator = new PDFcreator();
        pdFcreator.creePDF_Vente();

        File file = new File("listeVente.pdf");

        //Vérifier si le système prend en charge la classe Desktop ou non
        Desktop Desktop = null;
        if(!java.awt.Desktop.isDesktopSupported()){
            System.out.println("Desktop n'est pas prise en charge");
            return;
        }

        Desktop d = java.awt.Desktop.getDesktop();
        if(file.exists())
            d.open(file);

    }






    ///////////////////////////////VENTE////////////////////////////////////////////////VENTE/////////////////




    @FXML
    void refreshTable(){
        ObservableList<Client> obListeClient = FXCollections.observableArrayList();
        ObservableList<Medicament> obListeMedicament = FXCollections.observableArrayList();
        ObservableList<Vente> obListeVente = FXCollections.observableArrayList();

        String url2 = "jdbc:mysql://localhost:3306/java";
        Connection con;
        try {
            con = DriverManager.getConnection(url2, "root", "NathanCvl");
            String requeteClient = "select * from Client";
            String requeteMedicament = "select * from Medicament";
            String requeteVente = "select * from Vente";
            Statement listeClient = con.createStatement();
            Statement listeMedicament = con.createStatement();
            Statement listeVente = con.createStatement();
            try (ResultSet rs = listeClient.executeQuery(requeteClient) ) {
                while (rs.next()) {
                    obListeClient.add(new Client(rs.getInt("idClient"),rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"), rs.getString("adresse")));
                }

            }
            try(ResultSet medSet = listeMedicament.executeQuery(requeteMedicament)) {
                while (medSet.next()){
                    obListeMedicament.add(new Medicament(medSet.getInt(1),medSet.getString(2),medSet.getString(3),medSet.getInt(4),medSet.getInt(5), medSet.getDate(6)));
                }
            }  try(ResultSet venteSet = listeVente.executeQuery(requeteVente)) {
                while (venteSet.next()){
                    obListeVente.add(new Vente(venteSet.getInt(1),venteSet.getInt(2),venteSet.getDate(3).toLocalDate(),venteSet.getInt(4)));
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

        idVente.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdVente()));
        clientVente.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getIdClient()));
        dateVente.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDate()));
        montantVente.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMontant()));

        idClient1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));
        nomClient1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
        prenomClient1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrenom()));
        telClient1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTel()));
        adresseClient1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getAdresse()));

        idMedicamentTab.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getmId()));
        nomMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
        marqueMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMarque()));
        stockMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getQuantite()));
        prixMedicamentTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrix()));
        dateMedTab.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDateExp()));
        idMedicamentTab1.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getmId()));
        nomMedicamentTab1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
        marqueMedicamentTab1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMarque()));
        stockMedicamentTab1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getQuantite()));
        prixMedicamentTab1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrix()));
        dateMedTab1.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDateExp()));
        tableVente.setItems(obListeVente);
        tableMedicament1.setItems(obListeMedicament);
        tableMedicament.setItems(obListeMedicament);
        tableClient.setItems(obListeClient);
        tableClient1.setItems(obListeClient);

    }
    @FXML
    void choixClientVente(ActionEvent event) {

            Client client = tableClient1.getSelectionModel().getSelectedItem();
            idClientVente.setText(String.valueOf(client.id));
            nomClientVente.setText(client.nom);
            prenomClientVente.setText(client.prenom);
            telClientVente.setText(client.tel);
            adresseClientVente.setText(client.adresse);
            paneChoixClient.setVisible(false);
            paneAfficheClient.setVisible(true);


        }
        @FXML
        void returnChoixClient(ActionEvent event){
            paneChoixClient.setVisible(true);
            paneAfficheClient.setVisible(false);
        }

        @FXML void finVente(ActionEvent event){

            Vente vente = new Vente(Integer.parseInt(idClientVente.getText()), LocalDate.now() );
            vente.finVente(calculPrix());
            returnChoixClient(event);
            obListeMedicamentAchat.clear();
            tablePanier.setItems(obListeMedicamentAchat);
            prixTotal.setText("0");
        }

        @FXML void medicamentVersPanier(ActionEvent event) {

            try {
                Label label = new Label("Nombre Article");
                spinner = new Spinner<>();
                final Button button = new Button("Valider");
                final int initialValue = 1;

                // Value factory.
                SpinnerValueFactory<Integer> valueFactory = //
                        new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 500, initialValue);

                spinner.setValueFactory(valueFactory);

                FlowPane root = new FlowPane();
                root.setHgap(10);
                root.setVgap(10);
                root.setPadding(new Insets(10));

                root.getChildren().addAll(label, spinner, button);

                Scene scene = new Scene(root, 200, 100);
                Stage stage = new Stage();
                stage.setTitle("Nombre Article");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
                stage.requestFocus();
                button.setOnAction(event1 -> {
                    stage.close();
                    venteParametre();
                });

            } catch (Exception e) {
                e.printStackTrace();
            }



                assert spinner != null;
                quantiteArticleVar = spinner.getValue();


        }
        int calculPrix() {
            int total = 0;
            String url = "jdbc:mysql://localhost:3306/java";
            for (int i = 0; i < tablePanier.getItems().size(); i++) {
                total+=tablePanier.getItems().get(i).getPrix()*tablePanier.getItems().get(i).getQuantite();
            }
            return total;
        }
        @FXML
        void annulerPanier(ActionEvent event){
            returnChoixClient(event);
            obListeMedicamentAchat.clear();
            tablePanier.setItems(obListeMedicamentAchat);
        }
        @FXML
        void supprimerArticle(){
            obListeMedicamentAchat.remove(tablePanier.getSelectionModel().getSelectedItem());
            tablePanier.setItems(obListeMedicamentAchat);
            refreshTable();
        }
        void venteParametre(){
            Medicament medicament = tableMedicament1.getSelectionModel().getSelectedItem();
            Panier panier=new Panier(medicament.mId,spinner.getValue(),medicament.prix,medicament.nom,medicament.marque  );


            idArticle.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getmId()));
            nomArticle.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNom()));
            marqueArticle.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getMarque()));
            prixArticle.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrix()));
            quantiteArticle.setCellValueFactory(data -> new SimpleObjectProperty<>(spinner.getValue()));
            obListeMedicamentAchat.add(panier);
            tablePanier.setItems(obListeMedicamentAchat);
            prixTotal.setText(String.valueOf(calculPrix()));
        }

            @Override
            public void initialize (URL url, ResourceBundle resourceBundle){
                paneChoixClient.setVisible(true);
                paneAfficheClient.setVisible(false);
                mediFiltre.setText("");
                refreshTable();
                ObservableList<Medicament> obListeMedicament = FXCollections.observableArrayList();
                String url2 = "jdbc:mysql://localhost:3306/java";
                try {
                    Connection con = DriverManager.getConnection(url2, "root", "NathanCvl");
                    String requeteMedicament = "select * from Medicament";
                    Statement listeMedicament = con.createStatement();

                    try (ResultSet medSet = listeMedicament.executeQuery(requeteMedicament)) {
                        while (medSet.next()) {
                            obListeMedicament.add(new Medicament(medSet.getInt(1), medSet.getString(2), medSet.getString(3), medSet.getInt(4), medSet.getInt(5), medSet.getDate(6)));
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                FilteredList<Medicament> filteredData = new FilteredList<>(obListeMedicament, b -> true);

                // 2. Set the filter Predicate whenever the filter changes.
                mediFiltre.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(Medicament -> {
                    // If filter text is empty, display all persons.

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    // Does not match.
                    if (Medicament.getNom().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    } else return Medicament.getMarque().toLowerCase().contains(lowerCaseFilter); // Filter matches last name.
                }));

                // 3. Wrap the FilteredList in a SortedList.
                SortedList<Medicament> sortedData = new SortedList<>(filteredData);

                // 4. Bind the SortedList comparator to the TableView comparator.
                // 	  Otherwise, sorting the TableView would have no effect.
                sortedData.comparatorProperty().bind(tableMedicament1.comparatorProperty());

                // 5. Add sorted (and filtered) data to the table.
                tableMedicament1.setItems(sortedData);


            }

        }



