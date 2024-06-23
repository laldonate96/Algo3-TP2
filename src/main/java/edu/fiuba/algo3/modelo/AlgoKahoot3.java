package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Jugadores;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;

public class AlgoKahoot3 {
    //Podemos hacer una cola, seria mejor
    private final List<Pregunta> preguntas;
    private final Jugadores jugadores;
    private Turno turnoActual;
    private static AlgoKahoot3 instancia;

    private AlgoKahoot3(List<String> nombreJugadores, Jugadores jugadores){
        this.jugadores = jugadores;
        List<ModificadorPuntaje> modificadores = FabricaModificadores.crearListaModificadoresPuntaje();
        jugadores.agregar(nombreJugadores,modificadores);

        preguntas = Lector.obtenerPreguntasDeJson(new MezclaSinRepetirCategoria());
        
        turnoActual= new Turno(preguntas.getFirst());  

    }

    public static AlgoKahoot3 obtenerInstancia(List<String> nombreJugadores, Jugadores jugadores) {
        if (instancia == null) {
            instancia = new AlgoKahoot3(nombreJugadores, jugadores);
        }
        return instancia;
    }



    public void IniciarTurno() {
        turnoActual=turnoActual.nuevoTurno(preguntas.remove(0));

    }



    public void asignarModificadorTurno(ModificadorTurno modificadorTurno){
        turnoActual.asignarModificador(modificadorTurno);
    }


     public void crearRespuestaJugador(List<String> opcionesElegida, String nombreJugador, ModificadorPuntaje modificadorPuntaje){
        Jugador jugador=jugadores.buscarJugador(nombreJugador);


        turnoActual.agregarRespuesta(opcionesElegida, jugador, modificadorPuntaje);
    }




    public void asignarPuntajes(){
        turnoActual.asignarPuntajes();
    }


}
