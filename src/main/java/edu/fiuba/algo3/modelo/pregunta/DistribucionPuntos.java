package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public abstract class DistribucionPuntos {
    protected  int totalCorrectas;
    protected int puntaje = 1;

    public void establecerTotalCorrectas(int totalCorrectas) {
        this.totalCorrectas = totalCorrectas;
    }

    public abstract void asignarPuntaje(Respuesta respuesta);


}
