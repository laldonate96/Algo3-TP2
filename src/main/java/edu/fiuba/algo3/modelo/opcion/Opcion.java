package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public abstract class Opcion {
    protected Estado estado;
    protected String texto;
    
    public Opcion(String texto, Estado estado) {
        this.texto = texto;
        this.estado = estado;
    }

    public abstract boolean equals(Opcion opcion);

    protected boolean equals(Grupo grupo){
        return false;
    }
    protected boolean equals(Simple simple){
        return false;
    }
    protected boolean equals(Ordenada ordenada){
        return false;
    }

    public void actualizarEstado(Opcion opcion) {
        if (opcion.equals(this)) {
            this.estado=(opcion.estado);
        }
    }

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

    public String obtenerTexto() {
        
        return texto;
    }
    public abstract  String obtenerTipo();

}
