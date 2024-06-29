package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorMusica;
import edu.fiuba.algo3.vista.botones.Boton;
import edu.fiuba.algo3.vista.botones.BotonMenu;
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 

public class Toolbar { 
    private Button button1 = new Boton("FullScreen", "botonToolbar");
    private ControladorMusica controladorMusica = new ControladorMusica();

	public VBox mostrarToolbar(Stage stage) 
	{ 
        button1.setOnAction(e -> fullscreen(stage)); 
        MenuButton button2 = new BotonMenu("Musica");
        MenuItem item1 = new MenuItem("Reproducir/Parar");
        item1.setOnAction(e -> controladorMusica.pausar());
        MenuItem item2 = new MenuItem("Tema 1");
        item2.setOnAction(e -> controladorMusica.cambiarMusica("recursos/musica/Tema 1.mp3"));
        MenuItem item3 = new MenuItem("Tema 2");
        item3.setOnAction(e -> controladorMusica.cambiarMusica("recursos/musica/Tema 2.mp3"));
        MenuItem item4 = new MenuItem("Tema 3");
        Slider sliderVolumen = new Slider(0, 1, 0.5);
        sliderVolumen.valueProperty().addListener((observable, oldValue, newValue) -> {
            controladorMusica.ajustarVolumen(newValue.doubleValue());
        });
        CustomMenuItem sliderMenuItem = new CustomMenuItem(sliderVolumen);
        sliderMenuItem.setHideOnClick(false);
        item4.setOnAction(e -> controladorMusica.cambiarMusica("recursos/musica/Tema 3.mp3"));
        button2.getItems().addAll(item1, item2, item3, item4, sliderMenuItem);
        Button button3 = new Boton("Ver", "botonToolbar");
        Button button4 = new Boton("Salir", "botonToolbar");
        button4.setOnAction(e -> cerrarJuego(stage));
        ToolBar toolbar = new ToolBar(button1, button2, button3, button4); 
        VBox vbox = new VBox(toolbar);

        return vbox;
	}

    public void cerrarJuego(Stage stage) {
        stage.close();
    }

    public void fullscreen(Stage stage) {
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
            button1.setText("FullScreen");
        }
        else {           
            stage.setFullScreen(true);
            button1.setText("Exit FullScreen");
        }
    }
} 
