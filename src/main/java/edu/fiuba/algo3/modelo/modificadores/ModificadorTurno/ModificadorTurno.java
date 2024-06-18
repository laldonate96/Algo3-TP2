package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;

import edu.fiuba.algo3.modelo.Respuestas.Respuestas;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

public interface ModificadorTurno {
    public void modificarPuntajes(Respuestas respuestas);



    void actualizar(ModificadorPuntaje modificadorPuntaje, Jugador jugadorActivo);
}
