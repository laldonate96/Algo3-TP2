package edu.fiuba.algo3.modelo.opciones.opcion;

import edu.fiuba.algo3.modelo.opciones.opcion.estado.Estado;

import java.util.List;

public class Simple extends Opcion {
    public Simple(String texto, Estado estado) {
        super(texto, estado);
    }



    @Override
    public boolean equals(Opcion opcion) {
        return opcion.equals(this);
    }

    protected boolean equals(Ordenada ordenada) {
        return false;
    }

    protected boolean equals(Simple simple) {
        return this.texto.equals(simple.obtenerTexto());
    }

    protected boolean equals(Grupo grupo) {
        return false;
    }

    public boolean textoEstaContenido(List<String> opcionesElegidas) {
        return opcionesElegidas.contains(texto);
    }
}