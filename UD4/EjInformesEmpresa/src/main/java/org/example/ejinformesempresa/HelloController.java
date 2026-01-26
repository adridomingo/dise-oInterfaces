package org.example.ejinformesempresa;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HelloController {
    private Connection con = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/empresa";
    private String user = "root";
    private String clave = "1234";

    @FXML
    private ComboBox<String> depComboBox;

    @FXML
    private void initialize() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "select Departamento from empresa.departamentos;";
            rs = stat.executeQuery(sql);
            Set<String> set = new HashSet<>();
            while (rs.next()) {
                set.add(rs.getString("Departamento"));
            }
            depComboBox.getItems().addAll(set.stream().sorted().toList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void mostrarListaEmpleados() throws JRException {
        String fileRepo = "Informes/InfListadoEmpEmpleados.jasper";
        HashMap<String, Object> dpt = new HashMap<>();
        dpt.put("dpt", depComboBox.getValue());
        JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, dpt, con);
        JasperViewer viewer = new JasperViewer(jpRepo, false);
        viewer.setTitle("TITULO INFORME");
        viewer.setVisible(true);
    }
}