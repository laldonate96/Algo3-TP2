package edu.fiuba.algo3.modelo.Modificador;


import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.List;

public class Multiplicador extends Modificador {
    private final int factorDeMultiplicacion;

    public Multiplicador(int factorDeMultiplicacion){
        this.factorDeMultiplicacion = factorDeMultiplicacion;
        this.siguiente=new Nulo();
    }


    @Override
    public void modificarPuntajes(List<Respuesta> respuestas) {
        this.aplicarModificador(respuestas);
        siguiente.modificarPuntajes(respuestas);
    }

    private void aplicarModificador(List<Respuesta> respuestas) {
        for(Respuesta respuesta: respuestas){
            if (respuesta.perteneceA(duenio)){
                respuesta.multiplicarPuntaje(factorDeMultiplicacion);
            }
        }
    }


    @Override
    public void establecerDuenio(Jugador jugadorActivo) {
        duenio=jugadorActivo;
    }

    public boolean tieneFactor(int factorDeMultiplicacion){
        return this.factorDeMultiplicacion==factorDeMultiplicacion;
    }

    @Override
    public void agregarModificador(Modificador modificador) {
        siguiente.agregarModificador(modificador);
    }

    @Override
    public String mostrarModificador(){
        return "Modificador usado: Multiplicador" + " x" + factorDeMultiplicacion;
    }

    @Override
    public boolean usableSinPenalidad() {
        return false;
    }
}
