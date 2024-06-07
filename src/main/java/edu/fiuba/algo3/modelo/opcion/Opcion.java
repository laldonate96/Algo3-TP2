package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Incorrecta;

public class Opcion {
    private Estado estado;
    private String texto;

    public Opcion(String texto) {
        this.texto = texto;
        this.estado = new Incorrecta();
    }

    public Opcion(String texto, Estado estado) {
        this.texto = texto;
        this.estado = estado;
    }

    private boolean equals(Opcion opcion){
        return (this.texto).equals(opcion.texto);
    }

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean esCorrecta() {
        return estado.esCorrecta();
    }

    public void ActualizarEstado(Opcion opcion) {
        if (opcion.equals(this)) {
            this.cambiarEstado(opcion.estado);
        }
    }
}
