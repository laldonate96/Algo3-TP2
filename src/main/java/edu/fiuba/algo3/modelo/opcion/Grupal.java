package edu.fiuba.algo3.modelo.opcion;


public class Grupal extends Opcion {
    private final String nombreGrupo;
    private int puntosCorrecta;
    private int puntosIncorrecta;

    public Grupal(String texto, String nombreGrupo) {
        super(texto);
        this.nombreGrupo = nombreGrupo;
        puntosIncorrecta=0;
        puntosCorrecta= 0;
    }



    public void actualizarEstado(Grupal opcion) {
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
