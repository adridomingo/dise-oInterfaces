package org.example.examenud1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.Map;

public class HelloController {
    @FXML
    MenuBar menuBar;

    @FXML
    Menu gestion;
    @FXML
    MenuItem nuevoEmpleado;
    @FXML
    MenuItem guardarEmpleado;

    @FXML
    Menu desplazamiento;
    @FXML
    MenuItem primerRegistro;
    @FXML
    MenuItem anteriorRegistro;
    @FXML
    MenuItem siguienteRegistro;
    @FXML
    MenuItem ultimoRegistro;

    @FXML
    Menu listados;
    @FXML
    MenuItem empleados;

    @FXML
    TextField id;
    @FXML
    TextField nombre;
    @FXML
    TextField salario;
    @FXML
    DatePicker fechaNacimiento;
    @FXML
    RadioButton hombre;
    @FXML
    RadioButton mujer;
    @FXML
    ComboBox<String> departamentoComboBox;
    @FXML
    private ValidationSupport v = new ValidationSupport();

    private ResultSet rs;
    String url = "jdbc:mysql://localhost:3306/empresa";
    String user = "root";
    String clave = "1234";
    Connection con = null;

    @FXML
    private void initialize() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM empleados";
            rs = stat.executeQuery(sql);

            if (rs.next()) {
                mostrarContenidos();
            }

            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarContenidos() {
        try {
            id.setText(String.valueOf(rs.getInt("Id")));
            nombre.setText(rs.getString("Nombre"));

            // FECHA

            if (rs.getInt("Sexo") == 1) {
                mujer.setSelected(true);
            } else {
                hombre.setSelected(true);
            }
            cargarComboBox(rs.getInt("Departamento"));

            salario.setText(String.valueOf(rs.getDouble("Salario")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ;

    private void cargarComboBox(Integer idABuscar) {
        try {
            con = DriverManager.getConnection(url, user, clave);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM departamentos WHERE Id = ?");

            ps.setInt(1, idABuscar);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                departamentoComboBox.getItems().add(rs.getString("Departamento"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void nuevoEmpleado() {
        id.clear();
        nombre.clear();
        mujer.setSelected(false);
        hombre.setSelected(false);
        //FECHA
        departamentoComboBox.getItems().clear();
        cargarComboBoxDepartamentos();
        salario.clear();
        id.setDisable(true);
    }

    @FXML
    private void guardarEmpleado() {

        v.registerValidator(nombre, Validator.createEmptyValidator("Texto requerido"));
        v.registerValidator(fechaNacimiento, Validator.createEmptyValidator("Introduce una fecha"));
        v.registerValidator(departamentoComboBox, Validator.createEmptyValidator("Selecciona algo"));
        v.setErrorDecorationEnabled(false);

        if (v.isInvalid()) {
            v.setErrorDecorationEnabled(true);
            return;
        } else {
            try {
                con = DriverManager.getConnection(url, user, clave);
                PreparedStatement ps = con.prepareStatement("INSERT INTO empleados (Id, Nombre, FechaNac, Sexo, Departamento, Salario) values(?,?,?,?,?,?);");
                int sex = 0;

                PreparedStatement ps2 = con.prepareStatement("SELECT MAX(Id) FROM empleados;");

                ResultSet rsIdMax = ps2.executeQuery();

                if (rsIdMax.next()) {
                    ps.setInt(1, Integer.valueOf(rsIdMax.getInt(1)) + 1);
                }

                ps.setString(2, nombre.getText());
                ps.setDate(3, Date.valueOf(fechaNacimiento.getValue()));
                if (mujer.isSelected()) {
                    sex = 1;
                }
                ps.setInt(4, sex);
                ps.setInt(5, Integer.valueOf(departamentoComboBox.getValue().split("-")[0]));
                ps.setDouble(6, Double.parseDouble(salario.getText()));

                ps.executeUpdate();
                con.close();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void cargarComboBoxDepartamentos() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM departamentos");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                departamentoComboBox.getItems().add(rs.getInt("Id") + "-" + rs.getString("Departamento"));
            }

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void mostrarListados() {
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


}