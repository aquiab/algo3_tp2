package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

public class ControladorSeleccionarDificultad implements ChangeListener<Toggle> {
	ToggleGroup group;
	JuegoDirector director;
	RadioButton opcionFacil;
	RadioButton opcionNormal;
	RadioButton opcionDificil;
	public ControladorSeleccionarDificultad(ToggleGroup group, JuegoDirector director, RadioButton opcionFacil,
	RadioButton opcionNormal, RadioButton opcionDificil) {
		this.group = group;
		this.director = director;
		this.opcionFacil = opcionFacil;
		this.opcionNormal = opcionNormal;
		this.opcionDificil = opcionDificil;
	}

	@Override
	public void changed(ObservableValue<? extends Toggle> ov,
		Toggle oldToggle, Toggle newToggle) {
			if (group.getSelectedToggle() == opcionFacil) {
				director.configurarPartidaFacil();
			}
			if (group.getSelectedToggle() == opcionNormal) {
				director.configurarPartidaNormal();
			} 
			if (group.getSelectedToggle() == opcionDificil) {
				director.configurarPartidaDificil();
			}
	}
}
