package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.layout.HBox;

public class CrearModificadores {
    public static void crearModificadores(Jugador jugador, HBox modificadoresBox) {
        for (Modificador modificador : jugador.obtenerModificadores()) {
            switch (modificador.getClass().getSimpleName()) {
                case "Multiplicador":
                    if (((Multiplicador) modificador).tieneFactor(2)) {
                        modificadoresBox.getChildren().add(new BotonX2(jugador));
                    } else if (((Multiplicador) modificador).tieneFactor(3)) {
                        modificadoresBox.getChildren().add(new BotonX3(jugador));
                    }
                    break;
                case "Exclusividad":
                    modificadoresBox.getChildren().add(new BotonExclusividad(jugador));
                    break;
                case "Anulador":
                    modificadoresBox.getChildren().add(new BotonAnulador(jugador));
                    break;
                default:
                    break;
            }
        }
    }
}
