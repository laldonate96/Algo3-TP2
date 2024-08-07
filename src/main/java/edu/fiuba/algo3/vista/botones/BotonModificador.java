package edu.fiuba.algo3.vista.botones;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorActivarBoton;
import edu.fiuba.algo3.controlador.ControladorUsoDeModificadores;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class BotonModificador extends Boton{
    private Modificador modificador;
    
    private Jugador jugador;

    public BotonModificador(String texto, Jugador jugador, Modificador modificador, String claseCSSDeBoton, List<BotonModificador> botones){
        super(texto, claseCSSDeBoton);
        this.modificador = modificador;
        this.jugador = jugador;
        this.setMinHeight(100);
        this.setOnAction(new ControladorUsoDeModificadores(jugador,modificador));
        this.setOnAction(new ControladorActivarBoton(this, botones));
    }

    public Modificador obtenerModificador(){
        return modificador;
    }
    
}
