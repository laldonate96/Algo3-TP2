package edu.fiuba.algo3.modelo.CriterioDeVictoria;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class MejorPuntaje implements CriterioDeVictoria {
    private final int limitePuntos;
    private final int limiteRondas;
    List<Jugador> listaOrdenadaJugadores;

    public MejorPuntaje(int limiteRondas,int limitePuntos){
        this.limiteRondas=limiteRondas;
        this.limitePuntos=limitePuntos;
    }

    @Override
    public List<Jugador> jugadoresOrdenados() {
        return listaOrdenadaJugadores;
    }

    private void ordenarLista(){
        listaOrdenadaJugadores.sort((j1, j2) -> j1.tieneMejorPuntajeQue(j2)?-1:1);
    }

    @Override
    public void establecerJugadores(List<Jugador> jugadores) {
        this.listaOrdenadaJugadores=new ArrayList<>(jugadores);
    }

    @Override
    public boolean terminoJuego(int rondasJugadas) {
        ordenarLista();
        Jugador ganador = listaOrdenadaJugadores.get(0);
        if(rondasJugadas>limiteRondas){
            return true;
        } else {
            return ganador.obtenerPuntaje() > limitePuntos;
        }
    }
}