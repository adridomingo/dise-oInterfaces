package org.example.ejvalidacion;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;


public class HelloController {
    @FXML
    private TextField txt;
    @FXML
    private CheckBox checkBox;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Button enviar;
    @FXML
    private ValidationSupport v = new ValidationSupport();

    @FXML
    private void initialize() {
        comboBox.getItems().add("HOLA");
        v.registerValidator(txt, Validator.createEmptyValidator("Texto requerido"));

        v.registerValidator(checkBox, (Control c, Boolean newValue)
                -> ValidationResult.fromErrorIf(c,"CheckBox pulsado",!newValue));

        v.registerValidator(comboBox, Validator.createEmptyValidator("Selecciona algo"));
        v.setErrorDecorationEnabled(false);
    }

    @FXML
    private void comprobar() {
        if (v.isInvalid()) {
            v.setErrorDecorationEnabled(true);
        }
    }
}