package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.view.ContenedorSeleccionarDificultad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;

public class ControladorVolverAlMenu implements EventHandler<ActionEvent> {

	JuegoDirector director;

	public ControladorVolverAlMenu(JuegoDirector director) {
		this.director = director;
    }

	@Override
    public void handle(ActionEvent e) {
		director.refreshConstructor();
		director.setearPartidaDefault();
		((Button)e.getSource()).getScene().setRoot(new ContenedorSeleccionarDificultad(director));
	}
}