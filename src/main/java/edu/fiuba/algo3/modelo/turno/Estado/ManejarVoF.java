package edu.fiuba.algo3.modelo.turno.Estado;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.ModificadorInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;

import java.util.List;

public class ManejarVoF implements Estado {
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
        for (Simple opcionPregunta:pregunta.obtenerOpciones()) {
            for (Opcion opcion : opcionesJugador) {
                validarOpcion(opcion);
                ((Simple)opcion).actualizarEstado(opcionPregunta);
            }
        }
    }




}