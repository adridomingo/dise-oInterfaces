module org.example.ej10audios {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires java.desktop;
    requires javafx.media;

    opens org.example.ej10audios to javafx.fxml;
    exports org.example.ej10audios;
}