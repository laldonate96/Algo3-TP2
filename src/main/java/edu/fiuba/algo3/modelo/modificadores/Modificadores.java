package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.*;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.AnuladorTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ExclusividadTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.NuloTurno;

import java.util.ArrayList;
import java.util.List;

public class Modificadores {
    public static List<ModificadorPuntaje> obtenerListaModificadoresPuntaje() {
        List<ModificadorPuntaje> listaModificadores = new ArrayList<>();
        listaModificadores.add(new NuloPuntaje());
        listaModificadores.add(new Multiplicador(2));
        listaModificadores.add(new Multiplicador(3));
        return listaModificadores;
    }

    public static ModificadorPuntaje parsearModificadorPuntaje(String nombreModificador) {
        ModificadorPuntaje modificador = new NuloPuntaje();
        if (!nombreModificador.isEmpty()) {
            switch (nombreModificador) {
                case "Multiplicador 2":
                    modificador = new Multiplicador(2);
                    break;
                case "Multiplicador 3":
                    modificador = new Multiplicador(3);
                    break;
                case "Exclusividad":
                    modificador = new ExclusividadPuntaje();
                    break;
                case "Anulador":
                    modificador = new AnuladorPuntaje();

                    break;
            }

        }
        return modificador;
    }

    public static ModificadorTurno parsearModificadorTurno(String nombreModificador) {
        ModificadorTurno modificador = new NuloTurno();
        if(!nombreModificador.isEmpty()) {
            switch (nombreModificador) {
                case "Exclusividad":
                    modificador = new ExclusividadTurno(new ExclusividadPuntaje());
                    break;
                case "Anulador":
                    modificador = new AnuladorTurno(new AnuladorPuntaje());
                    break;
            }
        }
        return modificador;
    }
}
