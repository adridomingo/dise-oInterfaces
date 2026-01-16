package org.example.ejinformes1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HelloController {

    private Connection con = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/datos";
    private String user = "root";
    private String clave = "1234";

    @FXML
    ComboBox<String> localidades;
    @FXML
    TextField min;
    @FXML
    TextField max;
    @FXML
    RadioButton infNormal;
    @FXML
    RadioButton infAgrupados;
    @FXML
    Button btn;

    @FXML
    private void initialize() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Localidad FROM datos.empleados;";
            rs = stat.executeQuery(sql);
            Set<String> localidadesUnicas = new HashSet<>();
            while (rs.next()) {
                localidadesUnicas.add(rs.getString("Localidad"));
            }
            localidades.getItems().addAll(localidadesUnicas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void mostrarInforme() throws JRException {
        JasperDesign d;
        JRDesignQuery jq = new JRDesignQuery();
        JasperReport jr;
        JasperPrint jp;
        HashMap<String, Object> param = new HashMap<>();
        param.put("Images/Agenda.png", "file:Images/Agenda.png");
        if (infNormal.isSelected()) {
            d = JRXmlLoader.load("Informes/EmpleadosSinAgrupar.jrxml");
            jq.setText("SELECT * FROM datos.empleados WHERE Localidad = '" + localidades.getValue()
                    + "' AND Salario > " + Integer.parseInt(min.getText()) + " AND Salario < " + Integer.parseInt(max.getText()));
            d.setQuery(jq);
            jr = JasperCompileManager.compileReport(d);
            jp = JasperFillManager.fillReport(jr,param,con);
            JasperViewer.viewReport(jp,false);
        } else {
            d = JRXmlLoader.load("Informes/EmpleadosAgrupadosLoc.jrxml");
            jq.setText("SELECT * FROM datos.empleados WHERE Localidad = '" + localidades.getValue()
                    + "' AND Salario > " + Integer.parseInt(min.getText()) + " AND Salario < " + Integer.parseInt(max.getText()));
            d.setQuery(jq);
            jr = JasperCompileManager.compileReport(d);
            jp = JasperFillManager.fillReport(jr,param,con);
            JasperViewer.viewReport(jp,false);
        }
    }
}