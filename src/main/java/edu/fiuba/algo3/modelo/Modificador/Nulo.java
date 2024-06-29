package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public class Nulo extends Modificador {





    public Nulo() {
        siguiente = null;
    }

    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        if (siguiente != null) {
            siguiente.modificarPuntajes(respuestas);
        }
    }

    @Override
    public void establecerDuenio(Jugador jugadorActivo) {
    }

    @Override
    public void agregarModificador(Modificador modificador) {

        if (siguiente == null){
            siguiente=modificador;
        } else {
            siguiente.agregarModificador(modificador);
        }

    }

    @Override
    public void actualizar(List<Modificador> modificadores) {
    }

    @Override
    protected List<String> guardarModificadores(List<String> listaUsados) {

        if (siguiente == null) {
            return listaUsados;
        } else {
            return super.guardarModificadores(listaUsados);
        }
    }
}
