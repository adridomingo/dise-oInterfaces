package org.example.ej14;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Vetana2Controller {
    HelloController helloController = new HelloController();

    private Connection con = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/piezas";
    private String user = "root";
    private String clave = "1234";


    @FXML
    private TableView<Pieza> tabla;
    @FXML
    private TableColumn<Pieza, Integer> id;
    @FXML
    private TableColumn<Pieza, String> nombre;
    @FXML
    private TableColumn<Pieza, Float> precio;

    @FXML
    private void initialize() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from piezas.piezas";
            rs = stat.executeQuery(sql);

            id.setCellValueFactory(new PropertyValueFactory<>("Id"));
            nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            precio.setCellValueFactory(new PropertyValueFactory<>("Precio"));

            tabla.getItems().clear();

            while (rs.next()) {
                tabla.getItems().add(new Pieza(rs.getInt("Id"), rs.getString("Nombre"), rs.getFloat("Precio")));
            }

            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
