module org.example.adrian_examen_ud4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.adrian_examen_ud4 to javafx.fxml;
    exports org.example.adrian_examen_ud4;
}