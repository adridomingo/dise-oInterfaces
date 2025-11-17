package org.example.ej14;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class HelloController {

    private Connection con = null;
    private String url = "jdbc:mysql://localhost:3306/piezas";
    private String user = "root";
    private String clave = "1234";

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;

    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnMostrar;


    @FXML
    private void mostrarRegistros() {
        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(HelloApplication.class.getResource("ventana2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            Stage stage2 = new Stage();
            stage2.setTitle("Nueva ventana");
            stage2.setScene(scene);
            stage2.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void añadirRegistros() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            PreparedStatement ps = con.prepareStatement("INSERT INTO piezas.piezas (Nombre, Precio) values(?,?);");

            ps.setString(1, txtNombre.getText().toString());
            ps.setFloat(2, Float.parseFloat(txtPrecio.getText()));

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}