package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;


import java.util.List;

public class Anulador extends Modificador implements Usable{

    private int factorDeMultiplicacion;
    private int llamados;


    public Anulador() {
        llamados=1;
        factorDeMultiplicacion =1;
        siguiente=new Nulo();
    }

    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        this.aplicarModificador(respuestas);
        siguiente.modificarPuntajes(respuestas);
    }


    private void aplicarModificador(List<Respuesta> respuestas) {

        if(llamados>1){
            factorDeMultiplicacion =0;
        }

        for (Respuesta respuesta : respuestas) {
            if(respuesta.esCorrecta()) {
                if (respuesta.perteneceA(duenio)) {
                    respuesta.multiplicarPuntaje(factorDeMultiplicacion);
                } else {
                    respuesta.multiplicarPuntaje(0);
                }
            }
        }
    }


    public void establecerDuenio(Jugador jugadorActivo) {
        duenio=jugadorActivo;
    }

    @Override
    public void agregarModificador(Modificador modificador) {
        if( esIgual(modificador)){
            llamados++;
        } else {
            siguiente.agregarModificador(modificador);
        }
    }


    private boolean esIgual(Modificador modificador) {
        return modificador.getClass().equals(this.getClass());
    }
}



