module com.proj.pharm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires mysql.connector.java;
    requires itextpdf;
    requires javafx.web;
    requires org.kordamp.ikonli.core;

    opens com.proj.pharm2022 to javafx.fxml;
    exports com.proj.pharm2022;
}