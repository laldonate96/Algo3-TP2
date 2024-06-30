package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//import java.awt.*;

public class BotonX2 extends BotonModificador{

    public BotonX2(Jugador jugador){
        super("X2", jugador, new Multiplicador(2), "botonModificador");
    }


}
