package edu.fiuba.algo3.excepciones;

public class ArchivoInexistenteException extends RuntimeException {
    public ArchivoInexistenteException(String mensaje) {
        super(mensaje);
    }
}
