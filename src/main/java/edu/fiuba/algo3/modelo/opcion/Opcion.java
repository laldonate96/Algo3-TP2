package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public abstract class Opcion {

    protected String texto;
    
    public Opcion(String texto, Estado estado) {
        this.texto = texto;

    }



    public abstract int contarCorrecta();

    public abstract int contarIncorrecta();

    public String obtenerTexto() {
        return texto;
    }

}
