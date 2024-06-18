package edu.fiuba.algo3.testEntrega2.mocks;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;

import java.util.List;

public class RespuestaMock implements Respuesta {
    int puntaje;
    Opciones opcionesMock;

    public RespuestaMock(Opciones opcionesMock){
        this.opcionesMock=opcionesMock;
        puntaje =0;
    }

    @Override
    public void asignarPuntaje(int puntaje) {
        this.puntaje +=puntaje;
    }


    @Override
    public Opciones obtenerOpciones() {
        return opcionesMock;
    }

    @Override
    public void validarOpcion(Opcion opcionPregunta) {

    }

    @Override
    public int obtenerPuntaje() {
        return puntaje;
    }

    @Override
    public void multiplicarPuntaje(int valor) {
        puntaje=puntaje*valor;
    }

    @Override
    public boolean esCorrecta() {
        return puntaje>0;
    }

    @Override
    public void sumarPuntaje() {
    }

    @Override
    public boolean perteneceA(Jugador first) {
        return false;
    }

}
