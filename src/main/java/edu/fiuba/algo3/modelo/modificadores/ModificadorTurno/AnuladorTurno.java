package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import java.util.ArrayList;
import java.util.List;

public class AnuladorTurno implements ModificadorTurno {

    ModificadorPuntaje modificadorReferencia;
    int cantidadCorrectas;
    List<Jugador> jugadoresProtegidos;

    public AnuladorTurno(ModificadorPuntaje modificadorReferencia) {
        jugadoresProtegidos = new ArrayList<>();
        this.modificadorReferencia = modificadorReferencia;
        cantidadCorrectas=0;
    }


    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if (respuesta.esCorrecta()) {
                cantidadCorrectas++;
                if (cantidadCorrectas > 1) {
                    break;
                }
            }

        }

        for (Respuesta respuesta : respuestas) {
            if(respuesta.esCorrecta()) {
                if ((cantidadCorrectas == 1) & (jugadoresProtegidos.size() == 1) && (respuesta.perteneceA(jugadoresProtegidos.get(0)))) {
                    respuesta.multiplicarPuntaje(1);
                } else {
                    respuesta.multiplicarPuntaje(0);
                }
            }

        }
    }

    private void usarModificador(Jugador jugadorActivo) {
        jugadoresProtegidos.add(jugadorActivo);

    }

    public void usar(ModificadorPuntaje modificadorPuntaje, Jugador jugadorActivo) {
        jugadorActivo.usar(modificadorPuntaje);
        if (modificadorPuntaje.equals(modificadorReferencia)) {
            usarModificador(jugadorActivo);
        }
    }
}



