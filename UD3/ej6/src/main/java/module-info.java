module org.example.ej6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.ej6 to javafx.fxml;
    exports org.example.ej6;
}