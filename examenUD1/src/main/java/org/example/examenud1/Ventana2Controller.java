package org.example.examenud1;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class Ventana2Controller {
    HelloController helloController = new HelloController();

    private Connection con = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/empresa";
    private String user = "root";
    private String clave = "1234";


    @FXML
    private TableView<Empleado> tabla;
    @FXML
    private TableColumn<Empleado, String> nombre;
    @FXML
    private TableColumn<Empleado, Double> salario;
    @FXML
    private TableColumn<Empleado, Double> salarioNeto;
    @FXML
    private TableColumn<Empleado, String> departamento;

    @FXML
    private void initialize() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from empleados";
            rs = stat.executeQuery(sql);

            nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            salario.setCellValueFactory(new PropertyValueFactory<>("Salario"));
            salarioNeto.setCellValueFactory(new PropertyValueFactory<>("SalarioNeto"));
            departamento.setCellValueFactory(new PropertyValueFactory<>("Departamento"));

            tabla.getItems().clear();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM departamentos WHERE Id = ?");

                ps.setInt(1, rs.getInt("Departamento"));

                ResultSet rs2 = ps.executeQuery();
                Double salario = rs.getDouble("Salario");
                empleado.setNombre(rs.getString("Nombre"));
                empleado.setSalario(salario);
                empleado.setSalarioNeto(salario*0.85);
                if (rs2.next()) {
                    empleado.setDepartamento(rs2.getString("Departamento"));
                }

                tabla.getItems().add(empleado);
            }

            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}