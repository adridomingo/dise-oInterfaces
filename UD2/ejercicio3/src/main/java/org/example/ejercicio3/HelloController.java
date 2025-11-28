package org.example.ejercicio3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class HelloController {

    @FXML
    private TextField numAleatorio;
    @FXML
    private TextField numProp;

    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn5;
    @FXML
    Button btn7;
    @FXML
    Button btn10;
    @FXML
    Button btn15;
    @FXML
    Button btn20;
    @FXML
    Button btn25;
    @FXML
    Button btn50;
    @FXML
    Button btn60;
    @FXML
    Button btn75;
    @FXML
    Button btn100;

    @FXML
    Button btnNewGame;
    @FXML
    Button btnInstrucciones;


    @FXML
    public void initialize() {
        numAleatorio.setDisable(true);
        numAleatorio.setText(numAleatorio().toString());

        btn1.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn1.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn1.getText()))); }
            btn1.setDisable(true);
            comprobarNumero();
        });

        btn2.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn2.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn2.getText()))); }
            btn2.setDisable(true);
            comprobarNumero();
        });

        btn5.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn5.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn5.getText()))); }
            btn5.setDisable(true);
            comprobarNumero();
        });

        btn7.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn7.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn7.getText()))); }
            btn7.setDisable(true);
            comprobarNumero();
        });

        btn10.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn10.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn10.getText()))); }
            btn10.setDisable(true);
            comprobarNumero();
        });

        btn15.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn15.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn15.getText()))); }
            btn15.setDisable(true);
            comprobarNumero();
        });

        btn20.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn20.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn20.getText()))); }
            btn20.setDisable(true);
            comprobarNumero();
        });

        btn25.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn25.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn25.getText()))); }
            btn25.setDisable(true);
            comprobarNumero();
        });

        btn50.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn50.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn50.getText()))); }
            btn50.setDisable(true);
            comprobarNumero();
        });

        btn60.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn60.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn60.getText()))); }
            btn60.setDisable(true);
            comprobarNumero();
        });

        btn75.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn75.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn75.getText()))); }
            btn75.setDisable(true);
            comprobarNumero();
        });

        btn100.setOnAction(event -> {
            if (numProp.getText().isEmpty()) {
                numProp.setText(btn100.getText());
            } else { numProp.setText(String.valueOf(Integer.parseInt(numProp.getText())+Integer.parseInt(btn100.getText()))); }
            btn100.setDisable(true);
            comprobarNumero();
        });
    }

    public Integer numAleatorio() {
        return (int) (Math.random() * 200) + 1;
    }

    @FXML
    public void newGame() {
        List<Button> lista = List.of(btn1,btn2,btn5,btn7,btn10,btn15,btn20,btn25,btn50,btn60,btn75,btn100);

        for (Button btn : lista) {
            btn.setDisable(false);
        }
        numAleatorio.setText(numAleatorio().toString());
        numProp.clear();
    }

    public void comprobarNumero() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        if (Integer.parseInt(numProp.getText())>Integer.parseInt(numAleatorio.getText())) {
            alert.setContentText("Has perdido");
            alert.show();
        } else if (Integer.parseInt(numProp.getText()) == Integer.parseInt(numAleatorio.getText())) {
            alert.setContentText("Has ganado");
            alert.show();
        }

    }




}