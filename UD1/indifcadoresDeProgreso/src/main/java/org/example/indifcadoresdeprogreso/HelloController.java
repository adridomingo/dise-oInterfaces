package org.example.indifcadoresdeprogreso;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    // Barra
    @FXML
    private ProgressBar progressBar;

    @FXML
    private TextField textoBarra;

    @FXML
    private Button btn1Barra;

    @FXML
    private Button btn2Barra;

    // Indicador
    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private TextField textoIndicador;

    @FXML
    private Button btn1Ind;

    @FXML
    private Button btn2Ind;

    // Slider
    @FXML
    private Slider slider;

    @FXML
    private TextField textSlider;

    @FXML
    private Button btn1Slider;

    @FXML
    private Button btn2Slider;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    protected void incrementarBarra() {
        if (progressBar.getProgress()==1.0) return;
        progressBar.setProgress(progressBar.getProgress()+0.25);
        mostrarValorBarra();
    }

    @FXML
    protected void decrementarBarra() {
        if (progressBar.getProgress() == 0) return;
        progressBar.setProgress(progressBar.getProgress()-0.25);
        mostrarValorBarra();
    }

    @FXML
    protected void mostrarValorBarra() {
        textoBarra.setText(Double.toString(progressBar.getProgress()));
    }

    @FXML
    protected void incrementarIndicador() {
        if (progressIndicator.getProgress()==1.0) return;
        progressIndicator.setProgress(progressIndicator.getProgress() + 0.25);
        mostrarValorIndicador();
    }

    @FXML
    protected void decrementarIndicador() {
        if (progressIndicator.getProgress() == 0) return;
        progressIndicator.setProgress(progressIndicator.getProgress() - 0.25);
        mostrarValorIndicador();
    }

    @FXML
    protected void mostrarValorIndicador() {
        textoIndicador.setText(Double.toString(progressIndicator.getProgress()));
    }

    @FXML
    protected void incrementarSlider() {
        slider.increment();
        mostrarValorSlider();
    }

    @FXML
    protected void decrementarSlider() {
        slider.decrement();
        mostrarValorSlider();
    }

    @FXML
    protected void mostrarValorSlider() {
        textSlider.setText(Double.toString(slider.getValue()));
    }

    @FXML
    protected void initialize() {
        SpinnerValueFactory<Integer> factory = new
                SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 50, 5);
        spinner.setValueFactory(factory);
    }
}