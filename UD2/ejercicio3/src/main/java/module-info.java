module org.example.ejercicio3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.example.ejercicio3 to javafx.fxml;
    exports org.example.ejercicio3;
}