package edu.fiuba.algo3.modelo.Fabricas;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class FabricaJugadores {
    public static List<Jugador> crearListaJugadores(List<String> jugadores){
        List<Jugador> listaJugadores = new ArrayList<>();
        List<Modificador> modificadores = new ArrayList<>();
        Jugador jugador;
        for(String nombreJugador : jugadores){
            modificadores = FabricaModificadores.crearListaModificadores();
            jugador = new Jugador(nombreJugador, modificadores);
            listaJugadores.add(jugador);
        }
        return listaJugadores;
    }
}
