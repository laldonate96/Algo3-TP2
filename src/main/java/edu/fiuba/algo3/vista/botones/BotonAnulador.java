package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//import java.awt.*;

public class BotonAnulador extends BotonModificador {

    public BotonAnulador(Jugador jugador,  Modificador modificador){
        super("A", jugador, modificador, "botonModificador");
    }


}