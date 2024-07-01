package edu.fiuba.algo3.modelo.turno.Estado;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.List;

public interface Estado {

    void agregarRespuesta(List<Opcion> opcionesJugador, Jugador jugador, Modificador modificador);
}