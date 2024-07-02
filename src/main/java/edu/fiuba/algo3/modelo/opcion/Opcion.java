package edu.fiuba.algo3.modelo.opcion;



public abstract class Opcion {

    protected String texto;
    
    public Opcion(String texto) {
        this.texto = texto;

    }



    public abstract int contarCorrecta();

    public abstract int contarIncorrecta();

    public String obtenerTexto() {
        return texto;
    }


}
