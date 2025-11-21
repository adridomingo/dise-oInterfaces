package com.example.ejerciciopresupuesto;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private DatePicker fecha;

    @FXML
    private ComboBox duracion;

    @FXML
    private TextField invitados;

    @FXML
    private ComboBox menu;

    @FXML
    private CheckBox discomovil;

    @FXML
    private CheckBox animacion;

    @FXML
    private CheckBox transporte;


    @FXML
    private TextField precioTotal;

    @FXML
    protected void initialize() {
        for(int i=1; i<=4;i++){
            duracion.getItems().add(i+" Hora| "+i+"0€/Persona");
        }
        menu.getItems().add("Picoteo | 10€/Persona");
        menu.getItems().add("Menu 1 | 15€/Persona");
        menu.getItems().add("Menu 2 | 20€/Persona");
    }

    @FXML
    protected void calcular(){
        int precioPersona=0;
       switch (duracion.getSelectionModel().getSelectedIndex()){
            case 0:
                precioPersona+=10;
                break;
            case 1:
                precioPersona+=20;
                break;
            case 2:
                precioPersona+=30;
                break;
            case 3:
                precioPersona+=40;
                break;
        }

        switch (menu.getSelectionModel().getSelectedIndex()){
            case 0:
                precioPersona+=10;
                break;
            case 1:
                precioPersona+=15;
                break;
            case 2:
                precioPersona+=20;
                break;
        }

        if (transporte.isSelected()){
            precioPersona+=5;
            System.out.println(transporte.toString());
        }

        int total=(precioPersona*Integer.parseInt(invitados.getText()));
        if (discomovil.isSelected()){
            total+=200;
            System.out.println(discomovil.toString());

        }
        if (animacion.isSelected()){
            total+=100;
            System.out.println(animacion.toString());
        }
        precioTotal.setText("El total es de: "+String.valueOf(total)+"€");

    }
}
