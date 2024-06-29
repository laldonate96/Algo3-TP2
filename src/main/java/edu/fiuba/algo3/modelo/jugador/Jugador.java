package edu.fiuba.algo3.modelo.jugador;

import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.ModificadorInexistenteException;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Nulo;

public class Jugador {
    private int puntaje;
    private final String nombre;
    private final List<Modificador> modificadores;

    public Jugador(String nombre, List<Modificador> modificadores) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.modificadores = modificadores;
    }

    public void sumarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public void usar(Modificador modificadorReferencia){
        Modificador modificadorBuscado = buscarModificador(modificadorReferencia);
        modificadorBuscado.usar();
        modificadorBuscado.actualizar(modificadores);
    }

    public boolean tieneNombre(String buscado) {
        return nombre.equals(buscado);
    }

    public boolean equals(Jugador jugador){
        return this.tieneNombre(jugador.nombre);
    }

    private Modificador buscarModificador(Modificador modificadorReferencia) {
        int contador=0;
        Modificador modificador = new Nulo();


        try {
            while (!modificador.equals(modificadorReferencia)) {
                modificador = modificadores.get(contador);
                contador++;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ModificadorInexistenteException("El jugador "+ nombre+ " no posee el modificador usado.");
        }
        return modificador;
    }

    public String obtenerNombre(){
        return this.nombre;
    }
}


