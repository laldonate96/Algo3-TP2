package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//import java.awt.*;

public class BotonExclusividad extends BotonModificador {

    public BotonExclusividad (Jugador jugador,  Modificador modificador){
        super("E", jugador, modificador, "botonModificador");
        
    }


}