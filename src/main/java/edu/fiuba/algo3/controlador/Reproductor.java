package edu.fiuba.algo3.controlador;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Reproductor {
    private String tema;
    private MediaPlayer mediaPlayer;

    public Reproductor() {
        tema = "recursos/musica/Tema 1.mp3";
        inicializarMediaPlayer();
    }

    private void inicializarMediaPlayer() {
        String mediaPath = Paths.get(tema).toUri().toString();
        Media musica = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(musica);
    }

    public void reproducir() {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void establecerTema(String tema) {
        this.tema = tema;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        inicializarMediaPlayer();
    }

    public void detener() {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pausar() {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                mediaPlayer.play();
            } else {
                mediaPlayer.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
