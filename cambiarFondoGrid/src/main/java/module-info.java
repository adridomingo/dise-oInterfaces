module org.example.cambiarfondogrid {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cambiarfondogrid to javafx.fxml;
    exports org.example.cambiarfondogrid;
}