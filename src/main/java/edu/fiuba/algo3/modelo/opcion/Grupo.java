package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public class Grupo extends Opcion {
    private final String nombreGrupo;

    public Grupo(String texto, String nombreGrupo, Estado estado) {
        super(texto, estado);
        this.nombreGrupo = nombreGrupo;
    }

    @Override
    public boolean equals(Opcion opcion) {
        return opcion.equals(this);
    }

    @Override
    protected boolean equals(Grupo grupo) {
        return this.texto.equals(grupo.texto) && this.nombreGrupo.equals(grupo.nombreGrupo);
    }

    public String obtenerGrupo(){
        return this.nombreGrupo;
    }


}
