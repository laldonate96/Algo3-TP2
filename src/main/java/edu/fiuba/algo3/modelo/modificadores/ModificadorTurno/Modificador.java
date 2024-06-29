package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;

import java.util.List;

public interface Modificador {

     void modificarPuntajes(List<Respuesta> respuestas);


    void usar(Jugador jugadorActivo);

    void agregarModificador(Modificador modificador);


    void establecerSiguiente(Modificador modificador);
}
