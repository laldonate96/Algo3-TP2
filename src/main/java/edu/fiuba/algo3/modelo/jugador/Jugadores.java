package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import java.util.ArrayList;
import java.util.List;

public class Jugadores {

    private final List<Jugador> listaJugadores;

    public Jugadores() {

        listaJugadores=new ArrayList<>();
    }


    public Jugador buscarJugador(String nombreJugador){
        Jugador buscado = null;
        for (Jugador jugador:listaJugadores){
            if( jugador.tieneNombre(nombreJugador)){
                buscado=jugador;
            }
        }


        return buscado;
    }


    public void agregar(List<String> nombreJugadores, List<ModificadorPuntaje> modificadores) {
        Jugador jugador;
        for(String nombreJugador : nombreJugadores){
            jugador=new Jugador(nombreJugador,modificadores);
            listaJugadores.add(jugador);
        }

    }
}
