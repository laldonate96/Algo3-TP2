package edu.fiuba.algo3.modelo.opcion.visitor;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Ordered;
import edu.fiuba.algo3.modelo.opcion.Simple;

public interface OpcionVisitor {
    boolean visitar(Ordered ordered);
    boolean visitar(Simple simple);
    boolean visitar(Grupo grupo);
}
