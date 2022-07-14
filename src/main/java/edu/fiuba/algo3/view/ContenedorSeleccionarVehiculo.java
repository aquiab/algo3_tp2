package edu.fiuba.algo3.view;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import edu.fiuba.algo3.controller.ControladorSeleccionarVehiculo;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.controller.ControladorIniciarJuego;

public class ContenedorSeleccionarVehiculo extends VBox {
	public ContenedorSeleccionarVehiculo(JuegoDirector director) {
		this.setPadding(new Insets(40));
		director.asignarAutoInicial();
        Label etiquetaUsuario = new Label();
        etiquetaUsuario.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiquetaUsuario.setText("Ingrese su nombre");
        etiquetaUsuario.setTextFill(Color.web("#66A7C5"));

		TextField nombreUsuario = new TextField();

		Label etiquetaVehiculo = new Label();
        etiquetaVehiculo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiquetaVehiculo.setText("Elija el vehículo inicial:");
        etiquetaVehiculo.setTextFill(Color.web("#66A7C5"));

		final ToggleGroup groupVehiculo = new ToggleGroup();

		RadioButton opcionAuto = new RadioButton("Auto");
		opcionAuto.setToggleGroup(groupVehiculo);
		opcionAuto.setSelected(true);

		RadioButton opcionMoto = new RadioButton("Moto");
		opcionMoto.setToggleGroup(groupVehiculo);

		RadioButton opcionCamioneta = new RadioButton("Camioneta");
		opcionCamioneta.setToggleGroup(groupVehiculo);

		Button botonJugar = new Button();
        botonJugar.setText("Jugar");
		botonJugar.setOnAction(new ControladorIniciarJuego(director, this, nombreUsuario));

		groupVehiculo.selectedToggleProperty().addListener(new ControladorSeleccionarVehiculo(groupVehiculo, director,
		opcionAuto, opcionMoto, opcionCamioneta));
		this.getChildren().addAll(etiquetaUsuario, nombreUsuario, etiquetaVehiculo, opcionAuto, opcionMoto, opcionCamioneta, botonJugar);
	}
	
}
