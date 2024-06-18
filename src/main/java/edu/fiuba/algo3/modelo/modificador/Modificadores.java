package edu.fiuba.algo3.modelo.modificador;

import java.util.ArrayList;
import java.util.List;

public class Modificadores {
    public static List<ModificadorPuntaje> obtenerListaModificadoresPuntaje() {
        List<ModificadorPuntaje> listaModificadores = new ArrayList<>();
        listaModificadores.add(new Nulo());
        listaModificadores.add(new Multiplicador(2));
        listaModificadores.add(new Multiplicador(3));
        return listaModificadores;
    }
}
