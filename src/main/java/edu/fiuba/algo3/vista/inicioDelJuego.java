package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import edu.fiuba.algo3.vista.animaciones.Titilante;
import edu.fiuba.algo3.vista.botones.Boton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InicioDelJuego extends Application {
    private Stage ventanaPrincipal;

    public void abrirCargaJugadores() {
        CargarJugadores cargarJugadores = new CargarJugadores();
        try {
            cargarJugadores.start(new Stage());
            ventanaPrincipal.close();
        } catch (Exception e) {
            Alerta algoSalioMal = new AlgoSalioMal();
            algoSalioMal.mostrarAlerta();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.ventanaPrincipal = primaryStage;

        Text titulo = new Text("Bienvenido a Algohoot");
        titulo.getStyleClass().add("primeraVentanaTitulo");
        Titilante titilante = new Titilante(1, titulo);
        titilante.aplicarAnimacion();

        Boton botonJugar = new Boton("Jugar", "botonJugar");
        botonJugar.setOnAction(event -> abrirCargaJugadores());
        
        VBox root = new VBox(20);
        root.getChildren().addAll(titulo, botonJugar);
        root.setAlignment(Pos.CENTER);

        Scene escenaDelJuego = new Scene(root, 800, 500);
        String css = this.getClass().getResource("src/css/style.css").toExternalForm();
        escenaDelJuego.getStylesheets().add(css);

        primaryStage.setTitle("Algohoot");
        primaryStage.setScene(escenaDelJuego);
        primaryStage.show();
    }
}
