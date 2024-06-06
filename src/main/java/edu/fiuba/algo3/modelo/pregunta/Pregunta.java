package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class Pregunta {
    protected String enunciado;
    protected List<Opcion> correctas;
    protected List<Opcion> opciones;
    protected Puntaje Puntaje;

    public Pregunta(String enunciado, List<Opcion> opciones, List<Opcion> correctas, Puntaje Puntaje) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.correctas = correctas;
        this.Puntaje = Puntaje;
    }

    public void asignarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            verificarOpciones(respuesta);
            asignarPuntaje(respuesta);
        }
    }

    public void asignarPuntaje(Respuesta respuesta) {
        Puntaje.asignarPuntaje(respuesta);
    }

    public void verificarOpciones(Respuesta respuesta) {
        for (Opcion opcionCorrecta : this.correctas) {
            respuesta.validarOpcion(opcionCorrecta);
        }
    }
}
