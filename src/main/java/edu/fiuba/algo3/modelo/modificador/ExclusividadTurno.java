package edu.fiuba.algo3.modelo.modificador;


import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;

import java.util.ArrayList;
import java.util.List;



public class ExclusividadTurno implements ModificadorTurno {
    ModificadorPuntaje modificadorchiquito;
    int cantidadLlamados;
    int cantidadCorrectas;
    List<String> usoExclusividadUnaVez;
    final static int EFECTO = 2;

    public ExclusividadTurno() {
        cantidadLlamados = 0;
        cantidadCorrectas = 0;
        usoExclusividadUnaVez = new ArrayList<>();

    }

    @Override
    public void asignarPuntajes(List<RespuestaConcreta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            //supuesto TEMPORAL -> Una respuesta es correcta si se le asigno un puntaje mayor a 0
//            if (respuesta.esCorrecta()) {
//                cantidadCorrectas++;
//            }
        }
        for (Respuesta respuesta : respuestas) {

//            if (cantidadCorrectas == 1 && respuesta.esCorrecta()) {
//                respuesta.cambiarMultiplicador(EFECTO * cantidadLlamados);
//            } else {
//                respuesta.cambiarMutiplicador(0);
//            }
        }
    }


    @Override
    public void usar(String jugadorActivo, Respuesta respuesta) {
        if (usoExclusividadUnaVez.contains(jugadorActivo)) {
            respuesta.borrar(modificadorchiquito);
        } else {
            usoExclusividadUnaVez.add(jugadorActivo);
        }
        cantidadLlamados++;
    }

    @Override
    public void reiniciar() {
        cantidadLlamados = 0;
        cantidadCorrectas = 0;
        usoExclusividadUnaVez.clear();

    }
}

