package org.example.ejcontrolsfx;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.SearchableComboBox;

import java.sql.*;

public class HelloController {

    private Connection con = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/poblacion";
    private String user = "root";
    private String clave = "1234";

    @FXML
    SearchableComboBox<String> comboBox;
    @FXML
    TableView<Capital> tabla;
    @FXML
    TableColumn<Capital, String> provincia;
    @FXML
    TableColumn<Capital, String> autonomia;
    @FXML
    TableColumn<Capital, String> poblacion;

    @FXML
    private void initialize() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from poblacion.capitales";
            rs = stat.executeQuery(sql);

            provincia.setCellValueFactory(new PropertyValueFactory<>("Provincia"));
            autonomia.setCellValueFactory(new PropertyValueFactory<>("Autonomía"));
            poblacion.setCellValueFactory(new PropertyValueFactory<>("Población"));

            tabla.getItems().clear();

            while (rs.next()) {
                Capital capital = new Capital();
                capital.setProvincia(rs.getString("Provincia"));
                capital.setAutonomía(rs.getString("Autonomía"));
                capital.setPoblación(rs.getString("Población"));

                tabla.getItems().add(capital);
            }

            sql="select Provincia from poblacion.capitales";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                comboBox.getItems().add(rs.getString("Provincia"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void buscar() {
        try {
            tabla.getItems().clear();
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * from poblacion.capitales WHERE Provincia LIKE '" + comboBox.getValue() + "';";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                Capital capital = new Capital();
                capital.setProvincia(rs.getString("Provincia"));
                capital.setAutonomía(rs.getString("Autonomía"));
                capital.setPoblación(rs.getString("Población"));

                tabla.getItems().add(capital);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}