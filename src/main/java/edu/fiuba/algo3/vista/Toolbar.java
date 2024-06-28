package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.Boton;
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 

public class Toolbar { 
    private Button button1 = new Boton("FullScreen", "botonToolbar");

	public VBox mostrarToolbar(Stage stage) 
	{ 
        button1.setOnAction(e -> fullscreen(stage)); 
        MenuButton button2 = new MenuButton("Musica");
        button2.getItems().addAll(new MenuItem("Tema 1"), new MenuItem("Tema 2"));
        button2.setStyle("botonToolbar");
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
