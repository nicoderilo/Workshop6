module com.example.workshop6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.mail;
    requires java.desktop;


    opens com.example.workshop6 to javafx.fxml;
    exports com.example.workshop6;
}