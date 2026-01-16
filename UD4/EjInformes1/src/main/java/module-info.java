module org.example.ejinformes1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.ejinformes1 to javafx.fxml;
    exports org.example.ejinformes1;
}