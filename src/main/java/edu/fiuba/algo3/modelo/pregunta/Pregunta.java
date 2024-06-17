package edu.fiuba.algo3.modelo.pregunta;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public abstract class Pregunta {
    protected String categoria;
    protected String enunciado;
    protected List<Opcion> opciones;
    protected Puntaje puntaje;

    public Pregunta(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.puntaje = puntaje;
        this.categoria = categoria;
    }
    
    public List<String> obtenerOpciones(){
        List<String> textoOpciones = new ArrayList<String>();
        for(Opcion opcion: this.opciones){
            textoOpciones.add(opcion.obtenerTexto());
        }
        return  textoOpciones;
    }
    
    public void asignarPuntajes(List<Respuesta> respuestas) {
        puntaje.asignarPuntajes(respuestas);
    }

}
