package edu.fiuba.algo3.testEntrega2.mocks;

import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class RespuestaMock implements Respuesta {
    int puntaje;
    List<Opcion> opcionesMock;

    public RespuestaMock(List<Opcion> opcionesMock){
        this.opcionesMock=opcionesMock;
        puntaje =0;
    }

    @Override
    public void asignarPuntaje(int puntaje) {
        this.puntaje +=puntaje;
    }


    @Override
    public List<Opcion> obtenerOpciones() {
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
        return puntaje*valor;
    }

    @Override
    public boolean esCorrecta() {
        return puntaje>0;
    }

    @Override
    public void sumarPuntaje() {
    }

}
