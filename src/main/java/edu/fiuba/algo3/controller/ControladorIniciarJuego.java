package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.view.ContenedorMapa;
import edu.fiuba.algo3.view.ContenedorSeleccionarVehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {

	JuegoDirector director;
	ContenedorSeleccionarVehiculo contenedorSeleccionarVehiculo;

	public ControladorIniciarJuego(JuegoDirector director, ContenedorSeleccionarVehiculo contenedorSelecContenedorSeleccionarVehiculo) {
		this.director = director;
        this.contenedorSeleccionarVehiculo = contenedorSelecContenedorSeleccionarVehiculo;
    }

	@Override
    public void handle(ActionEvent e) {
		Juego juego = director.obtenerPartida();
		ContenedorMapa contenedorMapa = new ContenedorMapa(juego);
		contenedorSeleccionarVehiculo.getScene().setRoot(contenedorMapa);
		contenedorMapa.getScene().setOnKeyReleased(new ControladorMovimiento(director, contenedorMapa));
		contenedorMapa.getScene().getWindow().sizeToScene();
	}
}
