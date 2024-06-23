package edu.fiuba.algo3.modelo.excepciones;

public class ArchivoInexistenteException extends RuntimeException {
    public ArchivoInexistenteException(String mensaje) {
        super(mensaje);
    }
}
