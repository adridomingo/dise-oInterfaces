package org.example.ej7interfazcontabla;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;

public class Ventana2Controller {
    private Connection con = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/datos";
    private String user = "root";
    private String clave = "1234";

    HelloController helloController = new HelloController();
    String nombreP = helloController.nombreV;
    String apellidosP = helloController.apellidoV;
    String localidadP = helloController.localidadV;
    Double salarioP = helloController.salarioV;

    @FXML
    TableView<Persona> tabla;
    @FXML
    TableColumn<Persona, String> nombre;
    @FXML
    TableColumn<Persona, String> apellidos;
    @FXML
    TableColumn<Persona, String> localidad;
    @FXML
    TableColumn<Persona, Double> salario;

    public void initialize() {
        nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        apellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        localidad.setCellValueFactory(new PropertyValueFactory<>("Localidad"));
        salario.setCellValueFactory(new PropertyValueFactory<>("Salario"));

        Persona persona = new Persona(nombreP, apellidosP, localidadP, salarioP);

        tabla.getItems().add(persona);
    }
}
