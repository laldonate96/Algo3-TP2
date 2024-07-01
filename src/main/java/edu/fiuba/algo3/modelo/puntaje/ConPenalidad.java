package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class ConPenalidad extends Puntaje {
    protected int puntajeIncorrecta=-1;

    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        int correctas = 0;
        int incorrectas = 0;

        for (Opcion opcion : respuesta.obtenerOpciones()) {
            correctas += opcion.contarCorrecta();
            incorrectas += opcion.contarIncorrecta();
        }
        respuesta.asignarPuntaje(correctas*puntaje + incorrectas*puntajeIncorrecta);
    }

    @Override
    public boolean modificadorEsValido(Modificador modificador) {
        return modificador.usableConPenalidad();
    }
}