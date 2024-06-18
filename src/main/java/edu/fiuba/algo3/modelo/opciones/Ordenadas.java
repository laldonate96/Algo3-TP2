package edu.fiuba.algo3.modelo.opciones;

import edu.fiuba.algo3.modelo.opciones.opcion.Grupo;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Estado;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ordenadas implements Opciones{
    protected List<Ordenada> listaOpciones;

    protected Ordenadas(){
        listaOpciones = new ArrayList<Ordenada>();
    }

    protected void add(Ordenada ordenada){
        listaOpciones.add(ordenada);
    }

    public Ordenadas (List<String> contenidoOpciones, List<String> posicionesDeCorrectas) {

        int posicion = 0;

        Ordenada opcion;
        for (String contenidoOpcion : contenidoOpciones) {

            if (posicionesDeCorrectas.get(posicion).equals(contenidoOpciones.get(posicion))) {
                opcion = new Ordenada(contenidoOpcion, posicion ,new Correcta());
            } else {
                opcion = new Ordenada(contenidoOpcion, posicion ,new Incorrecta());
            }
            listaOpciones.add(opcion);
            posicion++;
        }
    }

    @Override
    public Opciones crearCopia(List<String> opcionesElegidas) {
        Ordenadas opciones;
        opciones = new Ordenadas();
        Ordenada opcion;
        Estado estadoOpcion;
        int posicion = 1;
        for (String elegida : opcionesElegidas) {
            if (this.contiene(elegida, posicion)) {
                estadoOpcion = new Correcta();
            } else {
                estadoOpcion = new Incorrecta();
            }
            opcion = new Ordenada(elegida, posicion, estadoOpcion);
            opciones.listaOpciones.add(opcion);
            posicion++;
        }
        return opciones;
    }




    private boolean contiene(String elegida, int posicion) {
        boolean contiene = false;

        for (Ordenada opcion : listaOpciones) {
            if (opcion.textoEstaContenidoYRespetaPosicion(elegida, posicion)) {
                contiene = true;
            }
        }
        return contiene;
    }

    @Override
    public Iterator<Opcion> iterator() {
        List<Opcion> listaOpcion=new ArrayList<>();
        listaOpcion.add((Opcion) listaOpciones);
        return listaOpcion.iterator();
    }
}
