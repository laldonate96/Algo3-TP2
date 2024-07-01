package edu.fiuba.algo3.testEntrega2;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class RespuestaMock implements Respuesta {
    int puntajeRecibidoMock;
    List<Opcion> opcionesMock;

    public RespuestaMock(List<Opcion> opcionesMock){
        this.opcionesMock=opcionesMock;
        puntajeRecibidoMock=0;
    }

    @Override
    public void sumarPuntaje(int puntaje) {
        puntajeRecibidoMock+=puntaje;
    }

    public int obtenerPuntaje(){
        return puntajeRecibidoMock;
    }

    @Override
    public List<Opcion> obtenerOpciones() {
        return opcionesMock;
    }

    @Override
    public void validarOpcion(Opcion opcionPregunta) {

    }
}
