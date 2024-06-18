package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.RespuestaConcreta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.opciones.Opciones;

import java.util.*;

public class RespuestasConcretas implements Respuestas {
    List<Respuesta> listaRespuestas;

    public RespuestasConcretas() {
        listaRespuestas = new ArrayList<>();
    }


    @Override
    public void agregar(Opciones opciones, Jugador jugador, ModificadorPuntaje modificadorPuntaje) {
        RespuestaConcreta respuestaConcreta=new RespuestaConcreta(opciones,jugador,modificadorPuntaje);
        listaRespuestas.add(respuestaConcreta);
    }

    @Override
    public void agregar(Respuesta respuesta) {
        listaRespuestas.add(respuesta);
    }

//    @Override
//    public Respuesta buscarRespuestaPorJugador(Jugador jugador) {
//        for (Respuesta respuesta : listaRespuestas) {
//            if (respuesta.compararJugador(jugador)) {
//                return respuesta;
//            }
//        }
//    }

    @Override
    public Respuesta obtener(int index) {
        return listaRespuestas.get(index);
    }

    @Override
    public void sumarPuntajes() {
        for(Respuesta respuesta:listaRespuestas){
            respuesta.sumarPuntaje();
        }
    }


    @Override
    public Iterator<Respuesta> iterator() {
       return listaRespuestas.iterator();
    }


}
