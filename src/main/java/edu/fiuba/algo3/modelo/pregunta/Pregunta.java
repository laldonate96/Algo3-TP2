package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Respuestas.Respuestas;
import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;

import java.util.List;

public abstract class Pregunta {
    protected String categoria;
    protected String enunciado;
    protected Opciones opciones;
    protected Puntaje puntaje;

    public Pregunta(String enunciado, Opciones opciones, Puntaje puntaje, String categoria) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.puntaje = puntaje;
        this.categoria = categoria;
    }

    public void asignarPuntajes(List<Respuesta> respuestas) {

        puntaje.asignarPuntajes(respuestas);
    }
    public void asignarPuntajes(Respuestas respuestas) {

        puntaje.asignarPuntajes(respuestas);
    }

//    protected void asignarPuntaje(List<Respuesta> respuestas) {
//        puntaje.asignarPuntaje(respuesta);
//    }


    public String obtenerCategoria() {
        return categoria;
    }

    public Opciones obtenerOpciones() {
        return opciones;
    }

    public Opciones crearCopiaOpciones(List<String> opcionesElegidas) {
        return opciones.crearCopia(opcionesElegidas);
    }
}
