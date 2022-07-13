package edu.fiuba.algo3.view;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.text.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.controller.ControladorSeleccionarDificultad;
import edu.fiuba.algo3.controller.ControladorSeleccionarVehiculo;
import edu.fiuba.algo3.controller.ControladorIniciarJuego;

public class ContenedorMenu extends VBox {
	public ContenedorMenu(JuegoDirector director) {

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiqueta.setText("Ingrese su nombre");
        etiqueta.setTextFill(Color.web("#66A7C5"));

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

		Label etiquetaDificultad = new Label();
        etiquetaDificultad.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiquetaDificultad.setText("Seleccione la dificultad:");
        etiquetaDificultad.setTextFill(Color.web("#66A7C5"));

		final ToggleGroup groupDificultad = new ToggleGroup();

		RadioButton opcionFacil = new RadioButton("Fácil");
		opcionFacil.setToggleGroup(groupDificultad);

		RadioButton opcionNormal = new RadioButton("Normal");
		opcionNormal.setToggleGroup(groupDificultad);
		opcionNormal.setSelected(true);

		RadioButton opcionDificil = new RadioButton("Difícil");
		opcionDificil.setToggleGroup(groupDificultad);

		Button botonJugar = new Button();
        botonJugar.setText("Jugar");
		botonJugar.setOnAction(new ControladorIniciarJuego(director, this, nombreUsuario));

		groupDificultad.selectedToggleProperty().addListener(new ControladorSeleccionarDificultad(groupDificultad, director, 
		opcionFacil, opcionNormal, opcionDificil));
		groupVehiculo.selectedToggleProperty().addListener(new ControladorSeleccionarVehiculo(groupVehiculo, director,
		opcionAuto, opcionMoto, opcionCamioneta));

        this.getChildren().addAll(etiqueta, nombreUsuario, etiquetaVehiculo,
		opcionAuto, opcionMoto, opcionCamioneta, etiquetaDificultad, opcionFacil, opcionNormal, opcionDificil, botonJugar);
	}
}
