package edu.fiuba.algo3.modelo.excepciones;

public class PreguntaInexistenteException extends RuntimeException {
    public PreguntaInexistenteException(String mensaje){
        super(mensaje);
    }
}
