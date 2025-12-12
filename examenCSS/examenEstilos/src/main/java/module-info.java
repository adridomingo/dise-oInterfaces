module org.example.examenestilos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires java.desktop;

    opens org.example.examenestilos to javafx.fxml;
    exports org.example.examenestilos;
}