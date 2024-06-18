package edu.fiuba.algo3.modelo.opciones;

import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Ordenada;
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

    public Ordenadas (List<String> contenidoOpciones, List<String> ordenCorrecto) {
        listaOpciones=new ArrayList<>();
        int posicionEnLista;
        int posicionOrdenada=1;

        Ordenada opcion;
        for (String textoPosicion : ordenCorrecto) {
            posicionEnLista=Integer.parseInt(textoPosicion);

            opcion = new Ordenada(contenidoOpciones.get(posicionEnLista), posicionOrdenada ,new Correcta());
            listaOpciones.add(opcion);
            posicionOrdenada++;
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

    @Override
    public List<String> obtenerListaStrings() {
        return List.of();
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
        for (Opcion ordenada: listaOpciones){
            listaOpcion.add(ordenada);
        }
        return listaOpcion.iterator();
    }
}
