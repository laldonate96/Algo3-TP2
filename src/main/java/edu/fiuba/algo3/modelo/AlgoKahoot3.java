package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Jugadores;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.Mezclador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;

import java.util.List;

public class AlgoKahoot3 {
    //Podemos hacer una cola, seria mejor
    private List<Pregunta> preguntas;
    private Jugadores jugadores;
    private Turno turnoActual;
    AlgoKahoot3(List<String> nombreJugadores, Jugadores jugadores, Turno turno){

        this.jugadores= jugadores;
        List<ModificadorPuntaje> modificadores= FabricaModificadores.obtenerListaModificadoresPuntaje();
        jugadores.agregar(nombreJugadores,modificadores);

//        this.controlador = controlador;
        turnoActual=turno;


        preguntas = Lector.obtenerPreguntasDeJson(new Mezclador());

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
