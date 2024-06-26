package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.Boton;
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 

public class Toolbar { 

	public VBox mostrarToolbar(Stage stage) 
	{ 
        Button button1 = new Boton("FullScreen", "botonToolbar"); 
        Button button2 = new Boton("Musica", "botonToolbar");
        Button button3 = new Boton("Ver", "botonToolbar");
        Button button4 = new Boton("Salir", "botonToolbar");
        ToolBar toolbar = new ToolBar(button1, button2, button3, button4); 
        VBox vbox = new VBox(toolbar); 

        return vbox;
	}
} 
