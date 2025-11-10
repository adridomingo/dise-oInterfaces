module org.example.ej11listadoproductos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.example.ej11listadoproductos to javafx.fxml;
    exports org.example.ej11listadoproductos;
}