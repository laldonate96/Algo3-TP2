package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public class Grupo extends Opcion {
    private final String nombreGrupo;

    public Grupo(String texto, String nombreGrupo, Estado estado) {
        super(texto, estado);
        this.nombreGrupo = nombreGrupo;
    }

    protected String obtenerGrupo() {
        return nombreGrupo;
    }


    @Override
    public boolean equals(Opcion opcion) {
        return opcion.equals(this);
    }

    protected boolean equals(Ordenada ordenada) {
        return false;
    }

    protected boolean equals(Simple simple) {
        return false;
    }

    protected boolean equals(Grupo grupo) {
        return this.texto.equals(grupo.texto) && this.nombreGrupo.equals(grupo.nombreGrupo);
    }

    public boolean contiene(String texto,String grupo){
        return (texto.equals(this.texto) && this.nombreGrupo.equals( grupo));
    }
}
