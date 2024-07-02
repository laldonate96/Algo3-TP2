package edu.fiuba.algo3.modelo.turno.Estado;


import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;

import java.util.List;

public class ManejarGroupChoice implements Manejador {
    GroupChoice pregunta;

    public ManejarGroupChoice(GroupChoice pregunta) {
        this.pregunta=pregunta;
    }

    private void validarOpcion(Opcion opcion) {
        if(!(opcion instanceof Grupo)){
            throw new OpcionesIncorrectasException(" La pregunta asignada no acepta este tipo de opciones");
        }
    }

    public void validarOpciones(List<Opcion> opcionesJugador) {
        Grupo opcion;
        Grupo opcionPregunta;

        for (int i=0; i< opcionesJugador.size();i++) {
            validarOpcion(opcionesJugador.get(i));
            opcion = (Grupo) opcionesJugador.get(i);

            opcionPregunta=pregunta.obtenerOpciones().get(i);
            opcionPregunta.actualizarEstado(opcion);
        }
    }







}