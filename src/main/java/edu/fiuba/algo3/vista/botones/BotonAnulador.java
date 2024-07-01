package edu.fiuba.algo3.vista.botones;


import java.util.List;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//import java.awt.*;

public class BotonAnulador extends BotonModificador {

    public BotonAnulador(Jugador jugador,  Modificador modificador, List<BotonModificador> botones){
        super("A", jugador, modificador, "botonModificador", botones);
    }

}