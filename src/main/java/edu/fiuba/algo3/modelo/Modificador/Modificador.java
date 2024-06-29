package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.List;

public abstract class Modificador {

     public abstract void modificarPuntajes(List<Respuesta> respuestas);


    public abstract void establecerDuenio(Jugador jugadorActivo);

    public abstract void agregarModificador(Modificador modificador);

    public void actualizar(List<Modificador> modificadores){
        modificadores.remove(this);
    };
}
