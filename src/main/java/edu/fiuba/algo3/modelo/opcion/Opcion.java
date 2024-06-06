package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Correcta;
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

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean esCorrecta() {
        return estado.esCorrecta();
    }

    public String getTexto() {
        return texto;
    }

    public boolean equals(Opcion opcion) {
        if (opcion.getTexto().equals(texto)) {
            this.cambiarEstado(new Correcta());
            return true;
        }
        return false;
    }
}
