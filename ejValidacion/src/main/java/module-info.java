module org.example.ejvalidacion {
    requires javafx.controls;
    requires javafx.fxml;

    requires net.synedra.validatorfx;
    requires org.controlsfx.controls;

    opens org.example.ejvalidacion to javafx.fxml;
    exports org.example.ejvalidacion;
}