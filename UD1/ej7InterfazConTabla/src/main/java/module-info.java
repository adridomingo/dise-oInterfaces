module org.example.ej7interfazcontabla {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.ej7interfazcontabla to javafx.fxml;
    exports org.example.ej7interfazcontabla;
}