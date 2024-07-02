package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class GroupChoice extends Pregunta {
    private final List<Grupal> opciones;

    public GroupChoice(String enunciado, List<Grupal> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, puntaje, categoria,explicacion);
        this.opciones=opciones;
    }

    public List<Grupal> obtenerOpciones(){
        return opciones;
    }


    private Grupal validarOpcion(Opcion opcion) {
        try {

            return (Grupal) opcion;
        } catch (ClassCastException e) {
            throw new OpcionesIncorrectasException(" Una pregunta Group Choice no acepta este tipo de opciones");
        }
    }

    @Override
    protected void validarTamanioOpciones(List<Opcion> opcionesJugador) {
        if( opcionesJugador.size()>this.opciones.size()){
            throw new OpcionesDeTamanioInvalidoException(" La respuesta del usuario a una Pregunta Ordered Choice contiene opciones elegida  que las existentes.");
        }
    }

    public void validarOpciones(List<Opcion> opcionesJugador) {
        Grupal opcion;
        Grupal opcionPregunta;




        for (int i=0; i< opcionesJugador.size();i++) {
            opcion = validarOpcion(opcionesJugador.get(i));

            opcionPregunta=this.obtenerOpciones().get(i);
            opcionPregunta.actualizarEstado(opcion);
        }
    }
}
