package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;
import java.util.List;

public interface ModificadorTurno {
    public void asignarPuntajes(List<RespuestaConcreta> respuestas);

    void usar(String jugadorActivo, Respuesta respuesta);

    public void reiniciar();
}
