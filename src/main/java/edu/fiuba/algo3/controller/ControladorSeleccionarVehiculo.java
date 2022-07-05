package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

public class ControladorSeleccionarVehiculo implements ChangeListener<Toggle> {
	ToggleGroup group;
	JuegoDirector director;
	RadioButton opcionAuto;
	RadioButton opcionMoto;
	RadioButton opcionCamioneta;
	public ControladorSeleccionarVehiculo(ToggleGroup group, JuegoDirector director, RadioButton opcionAuto,
	RadioButton opcionMoto, RadioButton opcionCamioneta) {
		this.group = group;
		this.director = director;
		this.opcionAuto = opcionAuto;
		this.opcionMoto = opcionMoto;
		this.opcionCamioneta = opcionCamioneta;
	}

	@Override
	public void changed(ObservableValue<? extends Toggle> ov,
		Toggle oldToggle, Toggle newToggle) {
			if (group.getSelectedToggle() == opcionAuto) {
				director.asignarAutoInicial();
			}
			if (group.getSelectedToggle() == opcionMoto) {
				director.asignarMotoInicial();
			} 
			if (group.getSelectedToggle() == opcionCamioneta) {
				director.asignarCamionetaInicial();
			}
	}
}

