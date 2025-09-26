module org.example.imagenes {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.imagenes to javafx.fxml;
    exports org.example.imagenes;
}