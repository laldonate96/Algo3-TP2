package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class Clasica extends Puntaje {
    protected int cantidadCorrectasEsperada;

    public Clasica(int cantidadCorrectasPregunta){
        cantidadCorrectasEsperada= cantidadCorrectasPregunta;
    }

    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        int cantidadCorrectas=0;

        for (Opcion opcion : respuesta.obtenerOpciones()) {
            if (opcion.esCorrecta()) {
                cantidadCorrectas++;
            }
        }

        if(cantidadCorrectas==cantidadCorrectasEsperada) {
            respuesta.asignarPuntaje(puntaje);
        } else {
            respuesta.asignarPuntaje(0);
        }
    }
}
