package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class ConPenalidad extends Puntaje {
    protected int puntajeIncorrecta=-1;
    private int correctas = 0;
    private int incorrectas = 0;

    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        for (Opcion opcion : respuesta.obtenerOpciones()) {
            correctas += opcion.contarCorrecta();
            incorrectas += opcion.contarIncorrecta();
        }
        respuesta.asignarPuntaje(correctas*puntaje + incorrectas*puntajeIncorrecta);
    }
}