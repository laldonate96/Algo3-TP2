package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.opcion.visitor.OpcionVisitor;

public class Ordered extends Opcion {
    private int posicion;
    
    public Ordered(String texto, int posicion, Estado estado) {
        super(texto, estado);
        this.posicion = posicion;
    }

    public int obtenerPosicion() {
        return posicion;
    }



    @Override
    public boolean aceptar(OpcionVisitor visitor) {
        return visitor.visitar(this);
    }

    @Override
    public boolean visitar(Ordered ordered) {
        return this.texto.equals(ordered.obtenerTexto()) && this.posicion == ordered.obtenerPosicion();
    }

    @Override
    public boolean visitar(Simple simple) {
        return false;
    }

    @Override
    public boolean visitar(Grupo grupo) {
        return false;
    }
}
