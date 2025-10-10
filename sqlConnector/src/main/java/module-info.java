module org.example.sqlconnector {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.sqlconnector to javafx.fxml;
    exports org.example.sqlconnector;
}