package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.view.ContenedorMapa;
import edu.fiuba.algo3.view.ContenedorVictoria;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.image.*;

public class ControladorMovimiento implements EventHandler<KeyEvent> {
	
    JuegoDirector director;
    Juego juego;
    ContenedorMapa contenedorMapa;
    ImageView imagenVehiculo;

    public ControladorMovimiento(JuegoDirector director, ContenedorMapa contenedorMapa) {
        this.director = director;
        this.juego = director.obtenerPartida();
        this.contenedorMapa = contenedorMapa;
        this.imagenVehiculo = contenedorMapa.imagenVehiculo;
    }

    @Override
    public void handle(KeyEvent e) {
        if (e.getCode() == KeyCode.UP) {
            juego.mover(new DireccionArriba());
            imagenVehiculo.setRotate(-90);
        } else if (e.getCode() == KeyCode.DOWN) {
            juego.mover(new DireccionAbajo());
            imagenVehiculo.setRotate(90);
        } else if (e.getCode() == KeyCode.LEFT) {
            juego.mover(new DireccionIzquierda());
            imagenVehiculo.setRotate(180);
        } else if (e.getCode() == KeyCode.RIGHT) {
            juego.mover(new DireccionDerecha());
            imagenVehiculo.setRotate(0);
        } else {
            return;
        }
        contenedorMapa.actualizar(juego);
        
        if (juego.gano()) {
            ContenedorVictoria contenedorVictoria = new ContenedorVictoria(director);
            contenedorMapa.getScene().removeEventHandler(KeyEvent.KEY_RELEASED, this);
            contenedorMapa.getScene().setRoot(contenedorVictoria);
            contenedorVictoria.getScene().getWindow().sizeToScene();
        }
        
    }
}
