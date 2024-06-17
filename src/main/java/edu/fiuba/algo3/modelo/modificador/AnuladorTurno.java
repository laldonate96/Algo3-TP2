package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;

import java.util.ArrayList;
import java.util.List;


import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;

public class AnuladorTurno implements ModificadorTurno{

    ModificadorPuntaje modificadorchiquito;
    int cantidadLlamados;
    int cantidadCorrectas;
    List<Jugador> jugadorProtegido;

        public AnuladorTurno() {
            jugadorProtegido=new ArrayList<>();
        }

        public void establecerJugadorProtegido(Jugador jugadorProtegido){
            this.jugadorProtegido.add(jugadorProtegido);
        }

        @Override
        public void asignarPuntajes(List<RespuestaConcreta> respuestas) {
            for (Respuesta respuesta : respuestas) {
//                if (respuesta.perteneceA(jugadorProtegido.getFirst())){
//                    respuesta.cambiarMultiplicador()
//                }
            }


        }




        @Override
        public void usar(String jugadorActivo, Respuesta respuesta) {

            respuesta.borrar(modificadorchiquito);

        }

        @Override
        public void reiniciar() {
            jugadorProtegido.clear();
        }


    }
