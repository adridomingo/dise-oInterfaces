module com.example.ejerciciopresupuesto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejerciciopresupuesto to javafx.fxml;
    exports com.example.ejerciciopresupuesto;
}