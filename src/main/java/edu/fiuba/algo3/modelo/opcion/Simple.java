package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.opcion.visitor.OpcionVisitor;

public class Simple extends Opcion {
    public Simple(String texto, Estado estado) {
        super(texto, estado);
    }

    @Override
    public boolean aceptar(OpcionVisitor visitor) {
        return visitor.visitar(this);
    }

    @Override
    public boolean visitar(Ordered ordered) {
        return false;
    }

    @Override
    public boolean visitar(Simple simple) {
        return this.texto.equals(simple.obtenerTexto());
    }

    @Override
    public boolean visitar(Grupo grupo) {
        return false;
    }
}