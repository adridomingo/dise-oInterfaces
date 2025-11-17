module org.example.ej14 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires java.sql;

    opens org.example.ej14 to javafx.fxml;
    exports org.example.ej14;
}