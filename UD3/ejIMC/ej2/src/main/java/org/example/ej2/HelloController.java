package org.example.ej2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelloController {
    @FXML
    Slider altura;
    @FXML
    TextField alturaTxt;

    @FXML
    Slider peso;
    @FXML
    TextField pesoTxt;

    @FXML
    Text imc;
    @FXML
    Button btn;

    @FXML
    public void initialize() {
        altura.setMax(200.0);
        peso.setMax(200.0);
        altura.setBlockIncrement(1.0);
        peso.setBlockIncrement(1.0);

        pesoTxt.setDisable(true);
        alturaTxt.setDisable(true);
    }

    @FXML
    public void calcularIMC() {
        Double p = peso.getValue();
        pesoTxt.setText(String.format("%.1f", p));
        Double altMostrar = altura.getValue();
        Double a = (altura.getValue()/100 * altura.getValue()/100);
        alturaTxt.setText(String.format("%.1f", altMostrar));
        Double result = p / a;

        if (String.valueOf(result)=="Infinity"||String.valueOf(result)=="NaN"){
            imc.setText("0.0");
        }else {
            imc.setText(String.format("%.1f", result));
        }
    }

    @FXML
    public void ayuda() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("CalculadoraIMC.chm"));
    }

}