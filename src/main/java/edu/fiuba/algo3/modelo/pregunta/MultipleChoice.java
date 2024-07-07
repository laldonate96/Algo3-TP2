package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class MultipleChoice extends Pregunta {
    private final List<Simple> opciones;

    public MultipleChoice(String enunciado, List<Simple> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, puntaje, categoria, explicacion);
        this.opciones = opciones;
    }


    public List<Simple> obtenerOpciones() {
        return opciones;
    }

    private Simple validarOpcion(Opcion opcion) {
        try {
        return (Simple) opcion;
    } catch(ClassCastException e){
            throw new OpcionesIncorrectasException(" Una pregunta "+ this.getClass().getSimpleName()+" no acepta este tipo de opciones.");
    }
}

    @Override
    protected void validarTamanioOpciones(List<Opcion> opcionesJugador) {
        if( opcionesJugador.size()>this.opciones.size()){
            throw new OpcionesDeTamanioInvalidoException(" La respuesta del usuario a una Pregunta "+this.getClass().getSimpleName()+" contiene mas opciones elegidas  que las existentes.");
        }
    }

    public void validarOpciones(List<Opcion> opcionesJugador) {
        Simple simple;
        validarTamanioOpciones(opcionesJugador);
        for (Opcion opcion : opcionesJugador) {
            simple=validarOpcion(opcion);
            for (Simple opcionPregunta : this.obtenerOpciones()) {

                opcionPregunta.actualizarEstado(simple);
            }
        }


    }

}

