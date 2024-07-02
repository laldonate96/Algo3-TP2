package edu.fiuba.algo3.modelo.lector.mezclador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public class MezclaSinRepetirCategoria implements Mezclador {
    @Override
    public List<Pregunta> mezclarPreguntas(List<Pregunta> preguntas) {
        Collections.shuffle(preguntas);
        List<Pregunta> preguntasMezcladas = new ArrayList<>();
        while (!preguntas.isEmpty()) {
            int tamanioActual = preguntasMezcladas.size();
            if (preguntasMezcladas.isEmpty()) {
                preguntasMezcladas.add(preguntas.get(0));
                preguntas.remove(0);
                continue;
            }
            for (Pregunta pregunta : preguntas) {
                if (!compararCategorias(preguntasMezcladas.get(preguntasMezcladas.size() - 1), pregunta)) {
                    preguntasMezcladas.add(pregunta);
                    preguntas.remove(pregunta);
                    break;
                }
            }
            if (tamanioActual == preguntasMezcladas.size()) {
                preguntasMezcladas.add(preguntas.get(0));
                preguntas.remove(0);
            }
        }
        return preguntasMezcladas;
    }

    private boolean compararCategorias(Pregunta pregunta1, Pregunta pregunta2) {
        return pregunta1.obtenerCategoria().equals(pregunta2.obtenerCategoria());
    }
}
