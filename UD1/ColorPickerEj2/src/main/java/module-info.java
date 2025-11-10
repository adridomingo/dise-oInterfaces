module org.example.colorpickerej2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.colorpickerej2 to javafx.fxml;
    exports org.example.colorpickerej2;
}