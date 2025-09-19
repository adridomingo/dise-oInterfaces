module org.example.saludojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.saludojavafx to javafx.fxml;
    exports org.example.saludojavafx;
}