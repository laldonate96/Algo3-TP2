package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.*;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.AnuladorTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ExclusividadTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.NuloTurno;

import java.util.ArrayList;
import java.util.List;

public class FabricaModificadores {
    public static List<ModificadorPuntaje> crearListaModificadoresPuntaje() {
        List<ModificadorPuntaje> listaModificadores = new ArrayList<>();
        listaModificadores.add(new NuloPuntaje());
        listaModificadores.add(new Multiplicador(2));
        listaModificadores.add(new Multiplicador(3));
        listaModificadores.add(new ExclusividadPuntaje());
        listaModificadores.add(new AnuladorPuntaje());
        return listaModificadores;
    }

    public static List<ModificadorTurno> crearListaModificadoresTurno(){
        List<ModificadorTurno> listaModificadores = new ArrayList<>();
        listaModificadores.add(new NuloTurno());
        listaModificadores.add(new ExclusividadTurno(new ExclusividadPuntaje()));
        listaModificadores.add(new AnuladorTurno(new ExclusividadPuntaje()));
        return listaModificadores;
    }

}
