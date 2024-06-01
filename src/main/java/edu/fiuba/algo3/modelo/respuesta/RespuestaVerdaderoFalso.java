package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RespuestaVerdaderoFalso implements Respuesta {
    private String contenido;
    private Jugador jugador;

    public RespuestaVerdaderoFalso(String contenido, Jugador jugador) {
        this.contenido = contenido;
        this.jugador = jugador;
    }

    @Override
    public Boolean validarRespuesta(Object respuestaCorrecta) {
        return contenido.equals(respuestaCorrecta);
    }

    @Override
    public void asignarPuntaje(int puntaje) {
        jugador.sumarPuntos(puntaje);
    }
    
}
