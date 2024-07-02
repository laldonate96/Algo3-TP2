package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;


import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class VerdaderoFalso extends Pregunta {
    private List<Simple> opciones;

    public VerdaderoFalso(String enunciado, List<Simple> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, puntaje, categoria, explicacion);
        this.opciones=opciones;
    }

    public List<Simple> obtenerOpciones() {
        return opciones;
    }

    private Simple validarOpcion(Opcion opcion) {
        try {

            return (Simple) opcion;
        } catch (ClassCastException e) {

            throw new OpcionesIncorrectasException(" Una pregunta Verdadero O Falso no acepta este tipo de opciones");
        }
    }

    @Override
    protected void validarTamanioOpciones(List<Opcion> opcionesJugador) {
        if( opcionesJugador.size()>1){
            throw new OpcionesDeTamanioInvalidoException(" La respuesta del usuario al Verdadero o Falso contiene mas de una opcion elegida.");
        }
    }

    public void validarOpciones(List<Opcion> opcionesJugador) {

        validarTamanioOpciones(opcionesJugador);


        Simple opcionJugador=validarOpcion(opcionesJugador.get(0));
        for (Simple opcionPregunta:this.obtenerOpciones()) {

            if(opcionPregunta.tieneIgualTexto(opcionJugador)) {
                opcionPregunta.actualizarEstado(opcionJugador);
            }
        }

    }


}
