module org.example.slidertamanoimg {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.slidertamanoimg to javafx.fxml;
    exports org.example.slidertamanoimg;
}