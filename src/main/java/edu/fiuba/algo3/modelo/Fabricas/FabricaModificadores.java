package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.*;

import java.util.ArrayList;
import java.util.List;

public class FabricaModificadores {
    public static List<ModificadorPuntaje> obtenerListaModificadoresPuntaje() {
        List<ModificadorPuntaje> listaModificadores = new ArrayList<>();
        listaModificadores.add(new NuloPuntaje());
        listaModificadores.add(new Multiplicador(2));
        listaModificadores.add(new Multiplicador(3));
        listaModificadores.add(new ExclusividadPuntaje());
        listaModificadores.add(new AnuladorPuntaje());
        return listaModificadores;
    }




}
