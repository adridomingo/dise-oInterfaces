module org.example.ej2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires java.desktop;

    opens org.example.ej2 to javafx.fxml;
    exports org.example.ej2;
}