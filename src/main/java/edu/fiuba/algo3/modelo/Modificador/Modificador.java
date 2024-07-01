package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public abstract class Modificador implements Usable {
    protected Jugador duenio;
    protected Modificador siguiente;


    public abstract void modificarPuntajes(List<Respuesta> respuestas);


    public abstract void establecerDuenio(Jugador jugadorActivo);

    public abstract void agregarModificador(Modificador modificador);

    public Modificador actualizar(List<Modificador> modificadores){
        modificadores.remove(this);
        return this;
    }

    public String mostrarModificador(){
        return "Modificador usado: " + this.getClass().getSimpleName();
    }

    @Override
    public boolean usableConPenalidad() {
        return true;
    }

    @Override
    public boolean usableSinPenalidad() {
        return true;
    }
}
