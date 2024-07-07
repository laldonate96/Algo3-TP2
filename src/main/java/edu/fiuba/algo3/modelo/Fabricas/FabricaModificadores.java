package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.Modificador.*;
import java.util.ArrayList;
import java.util.List;

public class FabricaModificadores {
    public static List<Modificador> crearListaModificadores() {
        List<Modificador> listaModificadores = new ArrayList<>();
        listaModificadores.add(new Nulo());
        listaModificadores.add(new Multiplicador(2));
        listaModificadores.add(new Multiplicador(3));
        listaModificadores.add(new Exclusividad());
        listaModificadores.add(new Exclusividad());
        listaModificadores.add(new Anulador());
        return listaModificadores;
    }
}
