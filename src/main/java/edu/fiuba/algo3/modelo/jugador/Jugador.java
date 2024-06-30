package edu.fiuba.algo3.modelo.jugador;

import java.util.List;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.excepciones.ModificadorInexistenteException;

public class Jugador {
    private int puntaje;
    private final String nombre;
    private final List<Modificador> modificadores;

    public Jugador(String nombre, List<Modificador> modificadores) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.modificadores = modificadores;
        establecerDuenioModificadores();
    }

    private void establecerDuenioModificadores() {
        for(Modificador modificador:modificadores){
            modificador.establecerDuenio(this);
        }
    }

    public void sumarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public boolean tieneMejorPuntajeQue(Jugador jugador){
       return puntaje > jugador.puntaje;
    }

    public void usar(Modificador modificador) {

            if (!modificadores.contains(modificador)){
                throw new ModificadorInexistenteException("El jugador "+ nombre + " no posee el modificador usado.");
            }
            modificador.actualizar(modificadores);
    }

    public List<Modificador> obtenerModificadores(){
        return modificadores;
    }

    public boolean tieneNombre(String buscado) {
        return nombre.equals(buscado);
    }

    public boolean equals(Jugador jugador){
        return this.tieneNombre(jugador.nombre);
    }


    public String obtenerNombre(){
        return this.nombre;
    }
}


