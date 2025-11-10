module org.example.probarcosas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.example.probarcosas to javafx.fxml;
    exports org.example.probarcosas;
}