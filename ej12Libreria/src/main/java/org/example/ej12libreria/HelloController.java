package org.example.ej12libreria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML
    TextField titulo;
    @FXML
    TextField autor;
    @FXML
    TextField isbn;
    @FXML
    TextField paginas;
    @FXML
    ComboBox<String> genero;
    @FXML
    TextField disponible;

    @FXML
    Button btnAnterior;
    @FXML
    Button btnPrimero;
    @FXML
    Button btnUltimo;
    @FXML
    Button btnSiguiente;

    private ResultSet rs;
    String url = "jdbc:mysql://localhost:3306/libreria";
    String user = "root";
    String clave = "1234";
    public static Map<Integer, String> generos;

    @FXML
    public void ventana2() {
        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(HelloApplication.class.getResource("Ventana2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            Stage stage2 = new Stage();
            stage2.setTitle("Ventana2");
            stage2.setScene(scene);
            stage2.show();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize() {

        try {
            Connection con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM libros";
            rs = stat.executeQuery(sql);

            generos = cogerGeneros();
            System.out.println(generos);
            for (Map.Entry<Integer, String> entrada : generos.entrySet()) {
                genero.getItems().add(entrada.getKey() + " " + entrada.getValue());
            }

            if (rs.next()) {
                mostrarContenidos();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Integer, String> cogerGeneros() {
        try {
            Connection con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet rs2 = stat.executeQuery("SELECT * FROM genero");

            Map<Integer, String> map = new HashMap<>();

            while (rs2.next()) {
                map.put(rs2.getInt("Id"), rs2.getString("Nombre"));
            }
            con.close();
            return map;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void mostrarContenidos() {
        try {
            titulo.setText(rs.getString("Titulo"));
            autor.setText(rs.getString("Autor"));
            isbn.setText(rs.getString("ISBN"));
            paginas.setText(rs.getString("Paginas"));
            disponible.setText(rs.getString("Disponible"));
            genero.getSelectionModel().select(Integer.parseInt(rs.getString("Genero"))-1);
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