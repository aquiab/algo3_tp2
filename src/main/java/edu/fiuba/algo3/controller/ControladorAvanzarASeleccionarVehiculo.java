package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.view.ContenedorSeleccionarVehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorAvanzarASeleccionarVehiculo implements EventHandler<ActionEvent> {

	JuegoDirector director;
	TextField nombreUsuario;

	public ControladorAvanzarASeleccionarVehiculo(JuegoDirector director, TextField nombreUsuario) {
		this.director = director;
        this.nombreUsuario = nombreUsuario;
    }

	@Override
    public void handle(ActionEvent e) {
		((Button)e.getSource()).getScene().setRoot(new ContenedorSeleccionarVehiculo(director));
		director.obtenerPartida().aplicarJugador(nombreUsuario.getText());
		director.asignarAutoInicial();
	}
}