package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;

public class Parcial extends Puntaje {


    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        int correctas = 0;
        int incorrectas = 0;
        for (Opcion opcion : respuesta.obtenerOpciones()) {
            correctas += opcion.contarCorrecta();
            incorrectas += opcion.contarIncorrecta();
        }
        if (incorrectas == 0) {
            respuesta.asignarPuntaje(correctas*puntaje);
        }
    }
}




