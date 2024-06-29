package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;


import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;

import java.util.List;

public class Multiplicador implements Modificador {
    private final int factorDeMultiplicacion;
    private Jugador duenio;


    public Multiplicador(int factorDeMultiplicacion){
        this.factorDeMultiplicacion = factorDeMultiplicacion;

    }


    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        for(Respuesta respuesta: respuestas){
            if (respuesta.perteneceA(duenio)){
                respuesta.multiplicarPuntaje(factorDeMultiplicacion);
            }
        }
    }

    @Override
    public void usar(Jugador jugadorActivo) {
        duenio=jugadorActivo;
    }

    @Override
    public void agregarModificador(Modificador modificador) {

    }


}
