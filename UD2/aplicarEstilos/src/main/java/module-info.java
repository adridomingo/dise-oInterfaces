module org.example.aplicarestilos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.aplicarestilos to javafx.fxml;
    exports org.example.aplicarestilos;
}