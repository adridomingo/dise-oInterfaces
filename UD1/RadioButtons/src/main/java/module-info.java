module org.example.radiobuttons {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.radiobuttons to javafx.fxml;
    exports org.example.radiobuttons;
}