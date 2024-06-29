package edu.fiuba.algo3.modelo.Modificador;


import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.List;



public class Exclusividad extends Modificador {

    private int llamados;

    private int factorDeMultiplicacion;



    public Exclusividad() {
        llamados = 1;
        siguiente =new Nulo();
        factorDeMultiplicacion =2;
    }



    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        this.aplicarModificador(respuestas);
        siguiente.modificarPuntajes(respuestas);
    }

    private void aplicarModificador(List<Respuesta> respuestas) {
        int cantidadRespuestasCorrectas=0;
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
    public void establecerDuenio(Jugador jugadorActivo) {
        duenio=jugadorActivo;
    }

    @Override
    public void agregarModificador(Modificador modificador) {
        if( esIgual(modificador) ){
            llamados++;
        } else {
            siguiente.agregarModificador(modificador);
        }
    }


    private boolean esIgual(Modificador modificador) {
        return modificador.getClass().equals(this.getClass());
    }






}

