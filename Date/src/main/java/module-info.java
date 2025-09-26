module org.example.date {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.date to javafx.fxml;
    exports org.example.date;
}