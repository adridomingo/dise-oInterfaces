module org.example.ejcontrolsfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens org.example.ejcontrolsfx to javafx.fxml;
    exports org.example.ejcontrolsfx;
}