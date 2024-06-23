package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;


import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import java.util.List;



public class ExclusividadTurno implements ModificadorTurno {
    private final ModificadorPuntaje modificadorDereferencia;
    private int llamados;
    private int cantidadRespuestasCorrectas;
    private int factorDeMultiplicacion;


    public ExclusividadTurno(ModificadorPuntaje modificadorDereferencia) {
        llamados = 0;
        cantidadRespuestasCorrectas = 0;
        this.modificadorDereferencia= modificadorDereferencia;

        factorDeMultiplicacion =2;
    }


    public void modificarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            if (respuesta.esCorrecta()) {
                cantidadRespuestasCorrectas++;
                if (cantidadRespuestasCorrectas > 1) {
                    factorDeMultiplicacion = 0;
                    break;
                }
            }

        }
        for (Respuesta respuesta : respuestas) {
            respuesta.multiplicarPuntaje(factorDeMultiplicacion * llamados);
        }
    }


    private void usarModificador() {
        llamados++;
    }



    @Override
    public void usar(ModificadorPuntaje modificadorPuntaje, Jugador jugadorActivo) {
        jugadorActivo.usar(modificadorPuntaje);
        if(modificadorPuntaje.equals(modificadorDereferencia)){
            usarModificador();
        }
    }
}

