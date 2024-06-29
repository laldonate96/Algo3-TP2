package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public abstract class Modificador {
    protected Jugador duenio;
    protected Modificador siguiente;


    public abstract void modificarPuntajes(List<Respuesta> respuestas);


    public abstract void establecerDuenio(Jugador jugadorActivo);

    public abstract void agregarModificador(Modificador modificador);

    public void actualizar(List<Modificador> modificadores){
        modificadores.remove(this);
    }

    public List<String> mostrarModificadoresUsados(){
        List<String> modificadorUsados=new ArrayList<>();
        modificadorUsados.add("Los modificadores usados Son: \n");
        return guardarModificadores(modificadorUsados);
    }
    protected List<String> guardarModificadores(List<String> listaUsados) {
        listaUsados.add(this.getClass() + " por el jugador " + duenio.obtenerNombre() + "\n");
        return siguiente.guardarModificadores(listaUsados);
    }
}
