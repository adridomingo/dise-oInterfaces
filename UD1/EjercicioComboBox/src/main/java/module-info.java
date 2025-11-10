module org.example.ejerciciocombobox {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejerciciocombobox to javafx.fxml;
    exports org.example.ejerciciocombobox;
}