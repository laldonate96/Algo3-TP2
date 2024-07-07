package edu.fiuba.algo3.modelo.puntaje;


import edu.fiuba.algo3.modelo.Modificador.Usable;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

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

    @Override
    public boolean modificadorEsValido(Usable usable) {
        return usable.usableSinPenalidad();
    }
}




