module org.example.indifcadoresdeprogreso {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.indifcadoresdeprogreso to javafx.fxml;
    exports org.example.indifcadoresdeprogreso;
}