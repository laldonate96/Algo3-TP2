package edu.fiuba.algo3.modelo.opcion;

public interface OpcionVisitor {
    boolean visit(Ordered ordered);
    boolean visit(Simple simple);
    boolean visit(Group group);
}
