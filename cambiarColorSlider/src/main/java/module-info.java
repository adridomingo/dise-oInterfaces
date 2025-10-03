module org.example.cambiarcolorslider {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cambiarcolorslider to javafx.fxml;
    exports org.example.cambiarcolorslider;
}