package org.example.gridpainprueba;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private TextField nombre;

    @FXML
    private Button btnRegistrarCita;

    @FXML
    private DatePicker fecha;

    @FXML
    private Spinner hora;

    @FXML
    private Spinner minutos;

    @FXML
    private TextArea textArea;

    @FXML
    private void registrarCita() {
        textArea.setWrapText(false);
        textArea.appendText("Nombre de paciente: " + nombre.getText() +"\n");
        textArea.appendText("Fecha de la cita: " + fecha.getValue() +"\n");
        DecimalFormat formatoNumero = new DecimalFormat("00");
        textArea.appendText("Hora de la cita es: " + formatoNumero.format( hora.getValue()) + ":" + formatoNumero.format(minutos.getValue()) + "\n");

    }

    @FXML
    private void initialize() {
        SpinnerValueFactory<Integer> horaMax = new
                SpinnerValueFactory.IntegerSpinnerValueFactory(8, 17, 0, 1);
        hora.setValueFactory(horaMax);

        SpinnerValueFactory<Integer> minutosMax = new
                SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0, 1);
        minutos.setValueFactory(minutosMax);
    }
}