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
    private int factorDeMultiplicacion;

    public AnuladorTurno(ModificadorPuntaje modificadorReferencia) {
        jugadoresProtegidos = new ArrayList<>();
        this.modificadorReferencia = modificadorReferencia;
        cantidadCorrectas=0;
        factorDeMultiplicacion =1;
    }


    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if(respuesta.esCorrecta()) {
                if (respuesta.perteneceA(jugadoresProtegidos.get(0))) {
                    respuesta.multiplicarPuntaje(factorDeMultiplicacion);
                } else {
                    respuesta.multiplicarPuntaje(0);
                }
            }

        }
    }

    private void usarModificador(Jugador jugadorActivo) {
        jugadoresProtegidos.add(jugadorActivo);
        if(jugadoresProtegidos.size()>1){
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



