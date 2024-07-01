package edu.fiuba.algo3.vista.botones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import javafx.scene.layout.HBox;

public class CrearModificadores {
    public static void crearModificadores(Jugador jugador, HBox modificadoresBox, Pregunta pregunta) {
        List<BotonModificador> botones = new ArrayList<>();
        for (Modificador modificador : jugador.obtenerModificadores()) {
            if(pregunta.modificadorEsValido(modificador)) {
                switch (modificador.getClass().getSimpleName()) {
                    case "Multiplicador":
                        if (((Multiplicador) modificador).tieneFactor(2)) {
                            botones.add(new BotonX2(jugador, modificador, botones));
                            modificadoresBox.getChildren().add(botones.get(botones.size() - 1));
                        } else if (((Multiplicador) modificador).tieneFactor(3)) {
                            botones.add(new BotonX3(jugador, modificador, botones));
                            modificadoresBox.getChildren().add(botones.get(botones.size() - 1));
                        }
                        break;
                    case "Exclusividad":
                        botones.add(new BotonExclusividad(jugador, modificador, botones));
                        modificadoresBox.getChildren().add(botones.get(botones.size() - 1));
                        break;
                    case "Anulador":
                        botones.add(new BotonAnulador(jugador, modificador, botones));
                        modificadoresBox.getChildren().add(botones.get(botones.size() - 1));
                        break;
                    case "Nulo":
                        botones.add(new BotonNulo(jugador, modificador, botones));
                        modificadoresBox.getChildren().add(botones.get(botones.size() - 1));
                        break;
                    default:
                        break;
                }
            }
        }
    }
}