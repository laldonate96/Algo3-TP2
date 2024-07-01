package edu.fiuba.algo3.vista.botones;


import java.util.List;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//import java.awt.*;

public class BotonX3 extends BotonModificador {

    public BotonX3(Jugador jugador, Modificador modificador, List<BotonModificador> botones){
        super("X3", jugador,  modificador, "botonModificador", botones);

    }


}