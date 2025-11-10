package org.example.ej11listadoproductos;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    TextField nombre;
    @FXML
    TextField unidades;
    @FXML
    TextField precio;
    @FXML
    Button agregar;
    @FXML
    Button nuevo;

    @FXML
    TableView<Producto> tabla;
    @FXML
    TableColumn<Producto, String> Cnombre;
    @FXML
    TableColumn<Producto, Integer> Cunidades;
    @FXML
    TableColumn<Producto, Double> Cprecio;
    @FXML
    TableColumn<Producto, Double> Csubtotal;

    @FXML
    TextField total;

    private Double totalValor = 0.0;

    @FXML
    public void initialize() {
        Cnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        Cunidades.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        Cprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        Csubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

        tabla.getItems().clear();
    }

    @FXML
    public void agregar() {
        Integer units = Integer.parseInt(unidades.getText());
        Double price = Double.parseDouble(precio.getText());
        Double subT = units*price;

        tabla.getItems().add(new Producto(nombre.getText(), units, price, subT));
        totalValor+=subT;

        total.setText(totalValor.toString());

        nombre.clear();
        unidades.clear();
        precio.clear();
    }
}