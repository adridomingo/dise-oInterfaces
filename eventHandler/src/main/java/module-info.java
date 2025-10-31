module org.example.eventhandler {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.example.eventhandler to javafx.fxml;
    exports org.example.eventhandler;
}