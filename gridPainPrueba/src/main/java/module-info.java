module org.example.gridpainprueba {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gridpainprueba to javafx.fxml;
    exports org.example.gridpainprueba;
}