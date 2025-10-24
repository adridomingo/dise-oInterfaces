package org.example.ej7interfazcontabla;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    private Connection con = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/datos";
    private String user = "root";
    private String clave = "1234";

    @FXML
    ComboBox<String> localidades;

    @FXML
    Button mostrar;
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

    public  String nombreV;
    public  String apellidoV;
    public  String localidadV;
    public Double salarioV;

    @FXML
    private void initialize() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from datos.empleados";
            rs = stat.executeQuery(sql);

            nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            apellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
            localidad.setCellValueFactory(new PropertyValueFactory<>("Localidad"));
            salario.setCellValueFactory(new PropertyValueFactory<>("Salario"));

            limpiarTabla();

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setNombre(rs.getString("Nombre"));
                persona.setApellidos(rs.getString("Apellidos"));
                persona.setLocalidad(rs.getString("Localidad"));
                persona.setSalario(rs.getDouble("Salario"));

                tabla.getItems().add(persona);
            }

            rs = stat.executeQuery("select distinct Localidad from datos.empleados");

            while (rs.next()) {
                localidades.getItems().add(rs.getString("Localidad"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    @FXML
    private void limpiarTabla(){
        tabla.getItems().clear();
    }

    @FXML
    private void buscarPorLocalidad() {
        try{
            limpiarTabla();

            if (localidades.getValue().isEmpty()) {
                return;
            }

            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from datos.empleados where Localidad like '"+localidades.getValue()+"'";

            rs = stat.executeQuery(sql);

            while (rs.next()) {
                Persona p = new Persona(rs.getString("Nombre"),rs.getString("Apellidos"),rs.getString("Localidad"),Integer.parseInt(rs.getString("Salario")));

                tabla.getItems().add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void pasarDeVentana() throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(HelloApplication.class.getResource("ventana2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage2 = new Stage();
        stage2.setTitle("Nueva ventana");
        stage2.setScene(scene);
        stage2.show();
    }
}