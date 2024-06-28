package edu.fiuba.algo3.controlador;

public class ControladorMusica {
    private Reproductor reproductor;

    public ControladorMusica() {
        reproductor = new Reproductor();
        iniciar();
    }

    public void iniciar() {
        reproductor.reproducir();
    }

    public void detener() {
        reproductor.detener();
    }

    public void pausar() {
        reproductor.pausar();
    }

    public void cambiarMusica(String tema) {
        reproductor.detener();
        reproductor.establecerTema(tema);
        reproductor.reproducir();
    }
}
