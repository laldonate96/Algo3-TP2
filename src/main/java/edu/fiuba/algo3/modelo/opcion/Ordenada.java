package edu.fiuba.algo3.modelo.opcion;

public class Ordenada extends Opcion {
    private final int posicion;
    private int puntosIncorrecta;
    private int puntosCorrecta;

    public Ordenada(String texto, int posicion) {
        super(texto);
        this.posicion = posicion;
        puntosCorrecta=0;
        puntosIncorrecta=0;
    }

    public void actualizarEstado(Ordenada opcion) {
        if (this.texto.equals(opcion.texto) && this.posicion==opcion.posicion) {
            opcion.puntosCorrecta=1;
        } else{
            opcion.puntosIncorrecta=1;
        }
    }

    @Override
    public int contarCorrecta() {
        return puntosCorrecta;
    }

    @Override
    public int contarIncorrecta() {
        return puntosIncorrecta;
    }
}
