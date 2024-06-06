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

    private boolean equals(Opcion opcion){
        return (this.texto).equals(opcion.texto);
    }

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean esCorrecta() {
        return estado.esCorrecta();
    }

    public boolean siIgualActualizarEstado(Opcion opcionCorrecta) {
        if (opcionCorrecta.equals(this)) {
            this.cambiarEstado(opcionCorrecta.estado);
            return true;
        }
        return false;
    }
}
