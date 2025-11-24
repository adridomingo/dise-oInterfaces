module org.example.ejercicio5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.ejercicio5 to javafx.fxml;
    exports org.example.ejercicio5;
}