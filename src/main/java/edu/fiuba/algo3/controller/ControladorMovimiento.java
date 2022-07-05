package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.view.ContenedorMapa;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.text.DecimalFormat;

public class ControladorMovimiento implements EventHandler<KeyEvent> {
	
    Juego juego;
    Stage stage;
    ContenedorMapa contenedorMapa;
    ImageView imagenVehiculo;

    public ControladorMovimiento(Juego juego, Stage stage, ContenedorMapa contenedorMapa) {
        this.juego = juego;
        this.stage = stage;
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
        }
        contenedorMapa.actualizar();
        stage.setTitle("Movimientos: " + new DecimalFormat("#.##").format(juego.obtenerMovimientos()));
    }
}
