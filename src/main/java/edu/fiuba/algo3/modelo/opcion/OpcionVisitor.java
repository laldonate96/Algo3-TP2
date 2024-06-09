package edu.fiuba.algo3.modelo.opcion;

public interface OpcionVisitor {
    boolean visitar(Ordered ordered);
    boolean visitar(Simple simple);
    boolean visitar(Group group);
}
