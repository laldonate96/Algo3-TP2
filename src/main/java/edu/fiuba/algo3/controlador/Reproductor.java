package edu.fiuba.algo3.controlador;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Reproductor {
    private static Reproductor instancia;
    private String tema;
    private MediaPlayer mediaPlayer;
    private double volumen = 0.1;

    private Reproductor() {
        tema = "recursos/musica/Tema 4.mp3";
        inicializarMediaPlayer();
    }

    public static Reproductor obtenerInstancia() {
        if (instancia == null) {
            instancia = new Reproductor();
        }
        return instancia;
    }

    private void inicializarMediaPlayer() {
        String mediaPath = Paths.get(tema).toUri().toString();
        Media musica = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.setVolume(volumen);

        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        });
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
        mediaPlayer.play();
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
                if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                    mediaPlayer.play();
                } else {
                    mediaPlayer.pause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajustarVolumen(double volume) {
        this.volumen = volume;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }
}
