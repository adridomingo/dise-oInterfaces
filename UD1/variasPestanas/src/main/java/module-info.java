module org.example.variaspestanas {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.variaspestanas to javafx.fxml;
    exports org.example.variaspestanas;
}