package edu.fiuba.algo3.modelo.DistribuidoraDePuntaje;

import edu.fiuba.algo3.modelo.Respuesta;

public abstract class DistribuidoraDePuntaje {
    protected int totalCorrectas ;
    protected int puntaje = 1;

    public void establecerTotalCorrectas(int totalCorrectas) {
        this.totalCorrectas = totalCorrectas;
    }

    public abstract void asignarPuntaje(Respuesta respuesta, int respuestasIncorrectas, int respuestasCorrectas);


}
