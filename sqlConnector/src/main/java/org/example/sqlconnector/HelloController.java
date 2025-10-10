package org.example.sqlconnector;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class HelloController {

    private ResultSet rs;

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField localidad;
    @FXML
    private TextField salario;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;

    @FXML
    public void initialize() {
        String url = "jdbc:mysql://localhost:3306/datos";
        String user = "root";
        String clave = "1234";
        try {
            Connection con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from datos.empleados";
            rs = stat.executeQuery(sql);

            if (rs.next()) {
                mostrarContenidos();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarContenidos() {
        try {
            nombre.setText(rs.getString("Nombre"));
            apellidos.setText(rs.getString("Apellidos"));
            localidad.setText(rs.getString("Localidad"));
            salario.setText(String.valueOf(rs.getDouble("Salario")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    @FXML
    private void primero() {
        try {
            rs.first();
            mostrarContenidos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void ultimo() {
        try {
            rs.last();
            mostrarContenidos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void anterior() {
        try {
            if (!rs.previous()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Ya estas en el primero");
                alert.show();
            } else {
                rs.previous();
                mostrarContenidos();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void siguiente() {
        try {
            if (!rs.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Ya estas en el ultimo");
                alert.show();
            } else {
                rs.next();
                mostrarContenidos();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}