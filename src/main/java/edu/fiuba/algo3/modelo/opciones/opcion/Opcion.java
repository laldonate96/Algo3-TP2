package edu.fiuba.algo3.modelo.opciones.opcion;

import edu.fiuba.algo3.modelo.opciones.opcion.estado.Estado;


import java.util.List;

public abstract class Opcion {
    protected Estado estado;
    protected String texto;
    
    public Opcion(String texto, Estado estado) {
        this.texto = texto;
        this.estado = estado;
    }

    public abstract boolean equals(Opcion opcion);
    protected abstract boolean equals(Ordenada ordenada);
    protected abstract boolean equals(Simple simple);
    protected abstract boolean equals(Grupo grupo);

    /*public boolean esCorrecta() {
        return estado.esCorrecta();
    }*/

    public int contarCorrecta(){
        if (estado.esCorrecta()){
            return 1;
        } else return 0;
    }

    public int contarIncorrecta(){
        if (estado.esCorrecta()){
            return 0;
        } else return 1;
    }

    public int contarCorrectaOIncorrecta(){
        if (estado.esCorrecta()){
            return 1;
        } else return -1;
    }

    public void actualizarEstado(Opcion opcion) {
        if (opcion.equals(this)) {
            this.estado=(opcion.estado);
        }
    }

    public String obtenerTexto() {
        return texto;
    }


}
