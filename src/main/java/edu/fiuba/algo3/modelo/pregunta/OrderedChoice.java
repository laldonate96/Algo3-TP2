package edu.fiuba.algo3.modelo.pregunta;


import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class OrderedChoice extends Pregunta {
    private final List<Ordenada> opciones;

    public OrderedChoice(String enunciado, List<Ordenada> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, puntaje, categoria,explicacion);
        this.opciones=opciones;
    }

    public List<Ordenada> obtenerOpciones(){
        return opciones;
    }
    private Ordenada validarOpcion(Opcion opcion) {
        try {
            return (Ordenada) opcion;
        } catch (ClassCastException e) {
            throw new OpcionesIncorrectasException(" Una pregunta "+ this.getClass().getSimpleName()+" no acepta este tipo de opciones.");
        }
    }


    @Override
    protected void validarTamanioOpciones(List<Opcion> opcionesJugador) {
        if( opcionesJugador.size()>this.opciones.size()){
            throw new OpcionesDeTamanioInvalidoException(" La respuesta del usuario a una Pregunta "+this.getClass().getSimpleName()+" contiene mas opciones elegidas  que las existentes.");
        }
    }

    @Override
    public void validarOpciones(List<Opcion> opcionesJugador) {
        Ordenada opcion;
        Ordenada opcionPregunta;
        validarTamanioOpciones(opcionesJugador);
        for (int i=0; i< opcionesJugador.size();i++) {
            opcion=validarOpcion(opcionesJugador.get(i));
            opcionPregunta=this.obtenerOpciones().get(i);

            opcionPregunta.actualizarEstado(opcion);
        }
    }

}