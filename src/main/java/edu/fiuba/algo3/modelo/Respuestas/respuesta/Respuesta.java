package edu.fiuba.algo3.modelo.Respuestas.respuesta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;

import java.util.List;

public interface Respuesta {
    void asignarPuntaje(int puntaje);

    Opciones obtenerOpciones();

    void validarOpcion(Opcion opcionPregunta);

    //Pre: La respuesta fue asignada un puntaje
    //Post: Se obtiene ese puntaje
    int obtenerPuntaje();

    //Pre: La respuesta fue asignada un puntaje
    //Post: Se multiplica el puntaje por el valor recibido
    void multiplicarPuntaje(int valor);

    //Pre: La respuesta fue asignada un puntaje
    //Post: Devuelve true si la respuesta tiene un puntaje mayor a 0, false en caso contrario
    boolean esCorrecta();

    //Pre: La respuesta fue asignada un puntaje
    //Post: Se suma el puntaje de la respuesta al jugador
    void sumarPuntaje();

    boolean perteneceA(Jugador first);
}
