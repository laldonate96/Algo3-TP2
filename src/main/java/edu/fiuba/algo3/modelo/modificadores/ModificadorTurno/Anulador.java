package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;


import java.util.List;

public class Anulador implements Modificador {

    Modificador modificadorReferencia;
    private int factorDeMultiplicacion;
    private Jugador jugadorProtegido;

    public Anulador(Modificador modificadorReferencia) {
        this.modificadorReferencia = modificadorReferencia;
        cantidadLlamados=0;
        factorDeMultiplicacion =1;
    }


    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        int llamados=calcularLlamados();
        if(cantidadLlamados>1){
            factorDeMultiplicacion =0;
        }


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
    }

    public void usar(Jugador jugadorActivo) {
        jugadorProtegido=jugadorActivo;
    }

    @Override
    public void agregarModificador(Modificador modificador) {

    }
}



