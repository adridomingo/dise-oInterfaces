module org.example.ejercicio1suma {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio1suma to javafx.fxml;
    exports org.example.ejercicio1suma;
}