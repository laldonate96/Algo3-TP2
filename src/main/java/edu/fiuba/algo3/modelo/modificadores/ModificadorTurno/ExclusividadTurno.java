package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;


import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
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


    public void modificarPuntajes(List<Respuesta> respuestas) {
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

    private void usarModificador() {
        cantidadLlamados++;
    }



    @Override
    public void usar(ModificadorPuntaje modificadorPuntaje, Jugador jugadorActivo) {
        jugadorActivo.usar(modificadorPuntaje);
        if(jugadorActivo.tieneModificador(modificadorPuntaje) && modificadorPuntaje.equals(modificadorDereferencia)){
            usarModificador();
        }
    }
}

