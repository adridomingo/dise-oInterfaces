module org.example.ejinformesempresa {
    requires javafx.controls;
    requires javafx.fxml;
    requires net.sf.jasperreports.core;
    requires java.sql;


    opens org.example.ejinformesempresa to javafx.fxml;
    exports org.example.ejinformesempresa;
}