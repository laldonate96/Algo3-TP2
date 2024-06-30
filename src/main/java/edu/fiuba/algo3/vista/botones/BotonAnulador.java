package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.modelo.Modificador.Anulador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

//import java.awt.*;

public class BotonAnulador extends BotonModificador {

    public BotonAnulador(Jugador jugador){
        super("A", jugador, new Anulador(), "botonModificador");
    }


}