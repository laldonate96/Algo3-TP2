package edu.fiuba.algo3.excepciones;


public class ModificadorInexistenteException extends RuntimeException {
    public ModificadorInexistenteException(String mensaje) {
        super(mensaje);
    }
}