package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;


import java.util.List;

public class AnuladorTurno implements ModificadorTurno {

    ModificadorPuntaje modificadorReferencia;
    private int factorDeMultiplicacion;
    private int cantidadLlamados;
    private Jugador jugadorProtegido;

    public AnuladorTurno(ModificadorPuntaje modificadorReferencia) {
        this.modificadorReferencia = modificadorReferencia;
        cantidadLlamados=0;
        factorDeMultiplicacion =1;
    }


    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if(respuesta.esCorrecta()) {
                if (respuesta.perteneceA(jugadorProtegido)) {
                    respuesta.multiplicarPuntaje(factorDeMultiplicacion);
                } else {
                    respuesta.multiplicarPuntaje(0);
                }
            }

        }
    }

    private void usarModificador(Jugador jugadorActivo) {
        jugadorProtegido=jugadorActivo;
        cantidadLlamados++;
        if(cantidadLlamados>1){
            factorDeMultiplicacion =0;
        }
    }

    public void usar(ModificadorPuntaje modificadorPuntaje, Jugador jugadorActivo) {
        jugadorActivo.usar(modificadorPuntaje);
        if (modificadorPuntaje.equals(modificadorReferencia)) {
            usarModificador(jugadorActivo);
        }
    }
}



