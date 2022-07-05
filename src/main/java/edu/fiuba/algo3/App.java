package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.view.ContenedorMapa;
import edu.fiuba.algo3.view.ContenedorMenu;


public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        JuegoDirector director = new JuegoDirector();
        director.configurarPartidaNormal();
        Juego juego = director.obtenerPartida();

        ContenedorMapa contenedorMapa = new ContenedorMapa(juego);

        ContenedorMenu contenedorMenu = new ContenedorMenu(stage, contenedorMapa, director);
        var scene = new Scene(contenedorMenu);
        stage.setScene(scene);
        stage.show();
    }
}