package edu.fiuba.algo3.controlador;

import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Reproductor {
    private String path;

    public Reproductor() {
        path = "recursos/musica/Tema1.mp3";
    }

    public void reproducir() {
        Media musica = new Media(Paths.get(path).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
    }
    
}
