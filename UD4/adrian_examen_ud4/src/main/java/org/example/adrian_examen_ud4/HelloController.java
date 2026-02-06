package org.example.adrian_examen_ud4;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
    private String url = "jdbc:mysql://localhost:3306/examen";
    private String user = "root";
    private String clave = "1234";

    @FXML
    private ComboBox<String> tiposComboBox;

    @FXML
    private ComboBox<String> proveedoresComboBox;

    @FXML
    private void initialize() {
        try {
            con = DriverManager.getConnection(url, user, clave);
            Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Tipo from examen.tipos;";
            rs = stat.executeQuery(sql);
            Set<String> tipos = new HashSet<>();
            while (rs.next()) {
                tipos.add(rs.getString("Tipo"));
            }
            tiposComboBox.getItems().addAll(tipos);

            sql = "SELECT Proveedor FROM examen.proveedores;";
            rs = stat.executeQuery(sql);
            Set<String> proveedores = new HashSet<>();

            while (rs.next()) {
                proveedores.add(rs.getString("Proveedor"));
            }
            proveedoresComboBox.getItems().addAll(proveedores);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void mostrarInforme1() throws JRException {
        String fileRepo = "Informes/Informe_examen1.jasper";
        JRDesignQuery jq = new JRDesignQuery();
        JasperReport jr;
        JasperPrint jp;
//        JasperDesign d = JRXmlLoader.load("Informes/Informe_examen1.jrxml");
        HashMap<String, Object> imagen = new HashMap<>();
        String tipoSeleccionado = tiposComboBox.getValue();
        if (tipoSeleccionado=="Quesos") {
            imagen.put("imagen", "file:Images/Quesos.jpg");
        } else if (tipoSeleccionado=="Legumbres") {
            imagen.put("imagen", "file:Images/Legumbres.jpg");
        } else if (tipoSeleccionado=="Dulces") {
            imagen.put("imagen", "file:Images/dulces.jpg");
        }
        imagen.put("tipo", tipoSeleccionado);

        JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, imagen, con);
        JasperViewer viewer = new JasperViewer(jpRepo, false);
        viewer.setTitle("TITULO INFORME");
        viewer.setVisible(true);
    }

    @FXML
    public void mostrarInforme2() throws JRException {
        String fileRepo = "Informes/Informe_examen2.jasper";
        String proveedorSeleccionado = proveedoresComboBox.getValue();
        HashMap<String, Object> proveedor = new HashMap<>();
        proveedor.put("proveedor", proveedorSeleccionado);

        JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, proveedor, con);
        JasperViewer viewer = new JasperViewer(jpRepo, false);
        viewer.setTitle("TITULO INFORME");
        viewer.setVisible(true);
    }

    @FXML
    public void mostrarInforme3() throws JRException {
        JasperDesign d;
        JRDesignQuery jq = new JRDesignQuery();
        JasperReport jr;
        JasperPrint jp;
        d = JRXmlLoader.load("Informes/Informe_examen3.jrxml");
        jq.setText("select  p.Nombre, p.Unidades, t.Tipo, p.Caducidad from productos p join examen.tipos t on (p.Tipo=t.Id) join examen.proveedores p2 on(p.Proveedor=p2.Id);");
        d.setQuery(jq);
        jr = JasperCompileManager.compileReport(d);
        jp = JasperFillManager.fillReport(jr,null,con);
        JasperViewer.viewReport(jp,false);
    }
}