package edu.fiuba.algo3.modelo.opcion.visitor;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Ordered;
import edu.fiuba.algo3.modelo.opcion.Simple;

public class OpcionEsVisitor implements OpcionVisitor {
    private final OpcionEsVisitor opcion;

    public OpcionEsVisitor(OpcionEsVisitor opcionVisitor) {
        this.opcion = opcionVisitor;
    }

    @Override
    public boolean visitar(Ordered ordered) {
        return opcion.visitar(ordered);
    }

    @Override
    public boolean visitar(Simple simple) {
        return opcion.visitar(simple);
    }

    @Override
    public boolean visitar(Grupo grupo) {
        return opcion.visitar(grupo);
    }
}
