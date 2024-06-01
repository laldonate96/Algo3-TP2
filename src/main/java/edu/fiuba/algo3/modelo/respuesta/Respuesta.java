package edu.fiuba.algo3.modelo.respuesta;

public interface Respuesta {
    public Boolean validarRespuesta(Object respuestaCorrecta);

    public void asignarPuntaje(int puntaje);
}
