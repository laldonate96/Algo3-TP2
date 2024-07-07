package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public class Simple extends Opcion {
    private Estado estado;
    public Simple(String texto, Estado estado) {
        super(texto);
        this.estado=estado;
    }

    @Override
    public int contarCorrecta() {
        return estado.contarCorrecta();
    }

    @Override
    public int contarIncorrecta() {
        return estado.contarIncorrecta();
    }

    public void actualizarEstado(Simple opcion) {
        if(this.texto.equals(opcion.texto)) {
            opcion.estado=this.estado;
        }
    }

    public boolean tieneIgualTexto(Simple opcionJugador) {
        return this.texto.equals(opcionJugador.texto);
    }
}