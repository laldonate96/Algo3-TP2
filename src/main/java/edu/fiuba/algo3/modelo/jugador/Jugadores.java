package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.modificador.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificador.Modificadores;

import java.util.ArrayList;
import java.util.List;

public class Jugadores {

    private final List<Jugador> listaJugadores;



    public Jugadores(List<String> nombreJugadores) {

        this.listaJugadores=crearListaJugadores(nombreJugadores);
    }

    private List<Jugador> crearListaJugadores(List<String> nombreJugadores) {
        List<Jugador> listaJugadores = new ArrayList<>();
        Jugador jugador;
        List<ModificadorPuntaje> modificadores= Modificadores.obtenerListaModificadoresPuntaje();
        for(String nombreJugador : nombreJugadores){
            jugador=new Jugador(nombreJugador,modificadores);
            listaJugadores.add(jugador);
        }
        return listaJugadores;
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



}
