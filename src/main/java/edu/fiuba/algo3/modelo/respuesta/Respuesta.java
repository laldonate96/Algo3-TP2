package edu.fiuba.algo3.modelo.respuesta;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.TipoPregunta;


public class Respuesta {
    private List<String> contenido;
    private Jugador jugador;
    private TipoPregunta tipoPregunta;

    public Respuesta(List<String> contenido, Jugador jugador, TipoPregunta tipoPregunta) {
        this.contenido = contenido;
        this.jugador = jugador;
        this.tipoPregunta = tipoPregunta;
    }

    public void validarRespuesta(List<String> respuestasCorrectas) {
        int aciertos = 0;
        for (String respuesta : respuestasCorrectas) {
            if (contenido.contains(respuesta)) {
                aciertos++;
            }
        }
        tipoPregunta.asignarPuntaje(aciertos, respuestasCorrectas.size(), this);
    }
    
    public void asignarPuntaje(int puntaje) {
        jugador.sumarPuntos(puntaje);
    }
}