package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PreguntaLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Let´s plaaaay");

        Button enviarRespuestaButton = new Button("Enviar Respuesta");
        enviarRespuestaButton.getStyleClass().add("enviar-button");
        

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

      

      




        gridPane.getStyleClass().add("form-grid");

        Scene scene = new Scene(gridPane, 500, 550);
        String css = this.getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
