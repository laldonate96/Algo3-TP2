package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;

import java.util.List;

public class Nulo implements Modificador {


    private Modificador anterior;

    public Nulo() {
        anterior = null;

    }

    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {

    }

    @Override
    public void usar(Jugador jugadorActivo) {
    }

    @Override
    public void agregarModificador(Modificador modificador) {
        if (anterior == null){
            siguiente.agregarModificador(modificador);
        }
        anterior.establecerSiguiente(modificador);
    }

    @Override
    public void establecerSiguiente(Modificador modificador) {
    }


    public void establecerAnterior(Modificador modificador) {
        anterior=modificador;
    }
}
