package edu.fiuba.algo3.view;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.text.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.controller.ControladorSeleccionarDificultad;

public class ContenedorSeleccionarDificultad extends VBox {
	public ContenedorSeleccionarDificultad(JuegoDirector director) {
		this.setPadding(new Insets(40));

		Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));
		etiquetaTitulo.setText("AlgoGPS");
        etiquetaTitulo.setTextFill(Color.web("#66A7C5"));

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

		Button botonSiguenteEscena = new Button();
        botonSiguenteEscena.setText("Siguiente");
		botonSiguenteEscena.setOnAction(e -> {
			this.getScene().setRoot(new ContenedorSeleccionarVehiculo(director));
		});

		groupDificultad.selectedToggleProperty().addListener(new ControladorSeleccionarDificultad(groupDificultad, director, 
		opcionFacil, opcionNormal, opcionDificil));

        this.getChildren().addAll(etiquetaTitulo, etiquetaDificultad, 
		opcionFacil, opcionNormal, opcionDificil, botonSiguenteEscena);
	}
}
