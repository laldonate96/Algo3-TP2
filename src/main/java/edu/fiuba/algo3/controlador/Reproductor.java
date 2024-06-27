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
        try {
            String mediaPath = Paths.get(path).toUri().toString();
            System.out.println("Media path: " + mediaPath);
            Media musica = new Media(mediaPath);
            MediaPlayer mediaPlayer = new MediaPlayer(musica);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error details
        }
    }
}
