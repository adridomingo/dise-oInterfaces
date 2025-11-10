module org.example.pruebajavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.pruebajavafx to javafx.fxml;
    exports org.example.pruebajavafx;
}