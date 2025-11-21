module org.example.examenud1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires java.sql;

    opens org.example.examenud1 to javafx.fxml;
    exports org.example.examenud1;
}