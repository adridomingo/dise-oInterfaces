package org.example.ej10audios;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class HelloController {

    String audiofile = new File("music1.mp3").toURI().toString();

    @FXML
    private Button pause;
    @FXML
    private Button play;
    @FXML
    private Button stop;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    public void initialize() {

        btn1.setOnAction(e -> audiofile=new File("music1.mp3").toURI().toString());
        btn2.setOnAction(e -> audiofile=new File("music2.mp3").toURI().toString());
        btn3.setOnAction(e -> audiofile=new File("music3.mp3").toURI().toString());

        Media media = new Media(audiofile);
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        pause.setOnAction(e -> mediaPlayer.pause());
        play.setOnAction(e -> mediaPlayer.play());
        stop.setOnAction(e -> mediaPlayer.stop());
    }



}