package edu.fiuba.algo3.vista.botones;

import java.util.List;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class BotonNulo extends BotonModificador {
    public BotonNulo (Jugador jugador,  Modificador modificador, List<BotonModificador> botones){
        super("N", jugador, modificador, "botonModificador", botones);
        
    }
}
