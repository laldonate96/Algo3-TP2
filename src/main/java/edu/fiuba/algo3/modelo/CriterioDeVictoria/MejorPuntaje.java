package edu.fiuba.algo3.modelo.CriterioDeVictoria;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public class MejorPuntaje implements CriterioDeVictoria {
    private final int limitePuntos;
    private final int limiteRondas;
    List<Jugador> jugadores;
    private Jugador ganador;

    public MejorPuntaje(int limiteRondas,int limitePuntos){
        this.limiteRondas=limiteRondas;
        this.limitePuntos=limitePuntos;
    }

    @Override
    public Jugador obtenerGanador() {
        return ganador;
    }

    private void calcularGanador(){
        ganador = jugadores.get(0);
        for (Jugador jugador : jugadores){
            if (!ganador.tieneMejorPuntajeQue(jugador)) {
                ganador = jugador;
            }
        }
    }

    @Override
    public void establecerJugadores(List<Jugador> jugadores) {
        this.jugadores=jugadores;
    }


    @Override
    public boolean terminoJuego(int rondasJugadas) {
        calcularGanador();
        if(rondasJugadas>=limiteRondas){
            return true;
        } else {
            return ganador.obtenerPuntaje() > limitePuntos;
        }


    }
}
