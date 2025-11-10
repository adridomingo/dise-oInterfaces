package org.example.date;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class HelloController {

    @FXML
    private DatePicker date;

    @FXML
    private TextField texto;

    public DateTimeFormatter formatter;

    @FXML
    public void initialize() {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @FXML
    protected void mostrarFecha() {
        texto.setText(date.getValue().format(formatter));
    }
}