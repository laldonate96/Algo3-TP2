package edu.fiuba.algo3.modelo.jugador;

import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.ModificadorInexistenteException;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;

public class Jugador {
    private int puntaje;
    private final String nombre;
    private final List<ModificadorPuntaje> modificadores;

    public Jugador(String nombre, List<ModificadorPuntaje> modificadores) {
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


    public void usar(ModificadorPuntaje modificadorReferencia){
        ModificadorPuntaje modificadorBuscado = buscarModificador(modificadorReferencia);
        modificadorBuscado.usar();
        modificadorBuscado.actualizar(modificadores);
    }


    public boolean tieneNombre(String buscado) {
        return nombre.equals(buscado);
    }
    public boolean equals(Jugador jugador){
        return this.tieneNombre(jugador.nombre);
    }

    public boolean tieneModificador(ModificadorPuntaje modificadorPuntaje) {
        return modificadores.contains(modificadorPuntaje);
    }



    private ModificadorPuntaje buscarModificador(ModificadorPuntaje modificadorReferencia) {
        int contador=0;
        ModificadorPuntaje modificadorPuntaje= new NuloPuntaje();


        try {
            while (!modificadorPuntaje.equals(modificadorReferencia)) {
                modificadorPuntaje = modificadores.get(contador);
                contador++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ModificadorInexistenteException("El jugador"+ nombre+ "no posee el modificador usado." );
        }
        return modificadorPuntaje;
    }
}


