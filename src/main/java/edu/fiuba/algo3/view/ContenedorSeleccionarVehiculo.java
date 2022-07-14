package edu.fiuba.algo3.view;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.text.*;
import edu.fiuba.algo3.controller.ControladorSeleccionarVehiculo;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.controller.ControladorIniciarJuego;

public class ContenedorSeleccionarVehiculo extends VBox {
	public ContenedorSeleccionarVehiculo(JuegoDirector director) {
		Label etiquetaVehiculo = new Label();
        etiquetaVehiculo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiquetaVehiculo.setText("Elija el vehículo inicial:");
		etiquetaVehiculo.relocate(50, 80);

		final ToggleGroup groupVehiculo = new ToggleGroup();

		RadioButton opcionAuto = new RadioButton("Auto");
		opcionAuto.setToggleGroup(groupVehiculo);
		opcionAuto.setSelected(true);
		opcionAuto.relocate(50, 110);

		RadioButton opcionMoto = new RadioButton("Moto");
		opcionMoto.setToggleGroup(groupVehiculo);
		opcionMoto.relocate(50, 135);

		RadioButton opcionCamioneta = new RadioButton("Camioneta");
		opcionCamioneta.setToggleGroup(groupVehiculo);
		opcionCamioneta.relocate(50, 160);

		Button botonJugar = new Button();
        botonJugar.setText("Jugar");
		botonJugar.setOnAction(new ControladorIniciarJuego(director, this));
		botonJugar.relocate(50, 450);

		groupVehiculo.selectedToggleProperty().addListener(new ControladorSeleccionarVehiculo(groupVehiculo, director,
		opcionAuto, opcionMoto, opcionCamioneta));

		Pane pane = new Pane(etiquetaVehiculo, opcionAuto, opcionMoto, opcionCamioneta, botonJugar);
		pane.setStyle("-fx-background-color: rgb(213, 237, 223)");
		pane.setPrefSize(500, 500);

		this.getChildren().addAll(pane);
	}
	
}
