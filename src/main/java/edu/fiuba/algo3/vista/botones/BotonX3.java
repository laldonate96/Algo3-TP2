package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//import java.awt.*;

public class BotonX3 extends BotonModificador {

    public BotonX3(Jugador jugador){
        super("X3", jugador, new Multiplicador(3), "botonModificador");

    }


}