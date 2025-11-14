module org.example.ejercicio1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.example.ejercicio1 to javafx.fxml;
    exports org.example.ejercicio1;
}