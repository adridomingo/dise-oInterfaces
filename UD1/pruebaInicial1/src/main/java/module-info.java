module org.example.pruebainicial1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.pruebainicial1 to javafx.fxml;
    exports org.example.pruebainicial1;
}