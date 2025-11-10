module org.example.ej12libreria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires java.sql;

    opens org.example.ej12libreria to javafx.fxml;
    exports org.example.ej12libreria;
}