package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.view.ContenedorMapa;
import edu.fiuba.algo3.view.ContenedorMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {

	JuegoDirector director;
	ContenedorMenu contenedorMenu;
	TextField nombreUsuario;

	public ControladorIniciarJuego(JuegoDirector director, ContenedorMenu contenedorMenu, TextField nombreUsuario) {
		this.director = director;
        this.contenedorMenu = contenedorMenu;
		this.nombreUsuario = nombreUsuario;
    }

	@Override
    public void handle(ActionEvent e) {
		Juego juego = director.obtenerPartida();
		ContenedorMapa contenedorMapa = new ContenedorMapa(juego);
		contenedorMenu.getScene().setRoot(contenedorMapa);
		contenedorMapa.getScene().setOnKeyReleased(new ControladorMovimiento(director, contenedorMapa));
		contenedorMapa.getScene().getWindow().sizeToScene();
		juego.aplicarJugador(nombreUsuario.getText());
	}
}