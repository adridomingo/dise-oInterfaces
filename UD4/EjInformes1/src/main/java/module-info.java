module org.example.ejinformes1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejinformes1 to javafx.fxml;
    exports org.example.ejinformes1;
}