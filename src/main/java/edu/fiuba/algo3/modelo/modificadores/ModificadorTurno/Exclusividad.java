package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;


import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;

import java.util.List;



public class Exclusividad implements Modificador {
    private final Modificador modificadorDereferencia;
    private final Modificador otroModificador;
    private int llamados;
    private int cantidadRespuestasCorrectas;
    private int factorDeMultiplicacion;


    public Exclusividad(Modificador modificadorDereferencia) {
        llamados = 0;
        cantidadRespuestasCorrectas = 0;
        this.modificadorDereferencia= modificadorDereferencia;
        Nulo modificadorSiguiente=new Nulo();
        modificadorSiguiente.establecerAnterior(this);
        otroModificador=modificadorSiguiente;
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

    @Override
    public void usar(Jugador jugadorActivo) {

    }

    @Override
    public void agregarModificador(Modificador modificador) {
        if( modificador.equals(this)){
            llamados++;
        } else {
            otroModificador.agregarModificador(modificador);
        }
    }


    private void usarModificador() {

    }



    @Override
    public void usar(Modificador modificador, Jugador jugadorActivo) {
        jugadorActivo.usar(modificador);
        if(modificador.equals(modificadorDereferencia)){
            usarModificador();
        }
    }
}

