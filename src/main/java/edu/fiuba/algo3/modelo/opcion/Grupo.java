package edu.fiuba.algo3.modelo.opcion;


import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public class Grupo extends Opcion {
    private final String nombreGrupo;
    private int puntosCorrecta;
    private int puntosIncorrecta;

    public Grupo(String texto, String nombreGrupo, Estado estado) {
        super(texto, estado);
        this.nombreGrupo = nombreGrupo;
        puntosIncorrecta=0;
        puntosCorrecta= 0;
    }



    public void actualizarEstado(Grupo opcion) {
        if (this.texto.equals(opcion.texto) && this.nombreGrupo.equals(opcion.nombreGrupo)) {
            opcion.puntosCorrecta=1;
        } else{
            opcion.puntosIncorrecta=1;
        }
    }

    public String obtenerGrupo(){
        return this.nombreGrupo;
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
