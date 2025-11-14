module org.example.ejercicio2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.example.ejercicio2 to javafx.fxml;
    exports org.example.ejercicio2;
}