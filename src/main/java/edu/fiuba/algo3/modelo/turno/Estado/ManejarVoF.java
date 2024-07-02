package edu.fiuba.algo3.modelo.turno.Estado;


import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesInexistentesException;

import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;

import java.util.List;

public class ManejarVoF implements Manejador {
    private final VerdaderoFalso pregunta;

    public ManejarVoF(VerdaderoFalso pregunta) {
        this.pregunta=pregunta;
    }

    private void validarOpcion(Opcion opcion) {
        if(!(opcion instanceof Simple)){
            throw new OpcionesIncorrectasException(" la pregunta asignada no acepta este tipo de opciones");
        }
    }

    public void validarOpciones(List<Opcion> opcionesJugador) {

        validarOpcion(opcionesJugador.get(0));
        boolean textoExistente=false;

        if( opcionesJugador.size()>1){
            throw new OpcionesDeTamanioInvalidoException(" La respuesta del usuario al Verdadero o Falso contiene mas de una opcion elegida.");
        }
        Simple opcionJugador=(Simple) opcionesJugador.get(0);
        for (Simple opcionPregunta:pregunta.obtenerOpciones()) {
            if(opcionPregunta.tieneIgualTexto(opcionJugador)) {
                textoExistente=true;
                opcionPregunta.actualizarEstado(opcionJugador);
            }
        }
        if (!textoExistente){
            throw new OpcionesInexistentesException(" La respuesta del usuario al Verdadero O Falso contiene opciones inexistentes");
        }
    }
}