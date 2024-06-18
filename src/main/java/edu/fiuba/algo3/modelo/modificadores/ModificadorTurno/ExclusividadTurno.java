package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;


import edu.fiuba.algo3.modelo.Respuestas.Respuestas;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import java.util.ArrayList;
import java.util.List;



public class ExclusividadTurno implements ModificadorTurno {
    ModificadorPuntaje modificadorDereferencia;
    int cantidadLlamados;
    int cantidadCorrectas;
    List<String> usoExclusividadUnaVez;
    final static int EFECTO = 2;


    public ExclusividadTurno(ModificadorPuntaje modificadorDereferencia) {
        cantidadLlamados = 0;
        cantidadCorrectas = 0;
        usoExclusividadUnaVez = new ArrayList<>();
        this.modificadorDereferencia= modificadorDereferencia;

    }


    public void modificarPuntajes(Respuestas respuestas) {
        for (Respuesta respuesta : respuestas) {
            if (respuesta.esCorrecta()) {
                cantidadCorrectas++;
            }
        }
        for (Respuesta respuesta : respuestas) {

            if (cantidadCorrectas == 1 && respuesta.esCorrecta()) {
                respuesta.multiplicarPuntaje(EFECTO * cantidadLlamados);
            } else {
                respuesta.multiplicarPuntaje(0);
            }
        }
    }

    private void usarModificador(Jugador jugadorActivo) {

        cantidadLlamados++;
    }



    @Override
    public void actualizar(ModificadorPuntaje modificadorPuntaje, Jugador jugadorActivo) {
        jugadorActivo.usar(modificadorDereferencia);
        if(jugadorActivo.tieneModificador(modificadorPuntaje) && modificadorPuntaje.equals(modificadorDereferencia)){
            usarModificador(jugadorActivo);
        }
    }
}
