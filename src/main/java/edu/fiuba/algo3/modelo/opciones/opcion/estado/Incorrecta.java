package edu.fiuba.algo3.modelo.opciones.opcion.estado;

public class Incorrecta implements Estado {
    @Override
    public boolean esCorrecta() {
        return false;
    }
}