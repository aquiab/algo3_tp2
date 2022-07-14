package edu.fiuba.algo3.view;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.text.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.controller.ControladorSeleccionarDificultad;

public class ContenedorSeleccionarDificultad extends VBox {
	public ContenedorSeleccionarDificultad(JuegoDirector director) {
		//this.setPadding(new Insets(40));
		director.asignarAutoInicial();
		Label etiquetaUsuario = new Label();
		etiquetaUsuario.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiquetaUsuario.setText("Ingrese su nombre");
		etiquetaUsuario.setTextFill(Color.web("#66A7C5"));
		etiquetaUsuario.relocate(50, 80);

		TextField nombreUsuario = new TextField();
		nombreUsuario.relocate(50, 110);
		nombreUsuario.setPrefSize(390, 10);

		Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));
		etiquetaTitulo.setText("AlgoGPS");
        etiquetaTitulo.setTextFill(Color.web("#66A7C5"));
		etiquetaTitulo.relocate(50, 30);

		Label etiquetaDificultad = new Label();
        etiquetaDificultad.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiquetaDificultad.setText("Seleccione la dificultad:");
        etiquetaDificultad.setTextFill(Color.web("#66A7C5"));
		etiquetaDificultad.relocate(50, 165);

		final ToggleGroup groupDificultad = new ToggleGroup();

		RadioButton opcionFacil = new RadioButton("Fácil");
		opcionFacil.setToggleGroup(groupDificultad);
		opcionFacil.relocate(50, 190);

		RadioButton opcionNormal = new RadioButton("Normal");
		opcionNormal.setToggleGroup(groupDificultad);
		opcionNormal.setSelected(true);
		opcionNormal.relocate(50, 215);

		RadioButton opcionDificil = new RadioButton("Difícil");
		opcionDificil.setToggleGroup(groupDificultad);
		opcionDificil.relocate(50, 240);

		Button botonSiguenteEscena = new Button();
        botonSiguenteEscena.setText("Siguiente");
		botonSiguenteEscena.setOnAction(e -> {
			this.getScene().setRoot(new ContenedorSeleccionarVehiculo(director));
			director.obtenerPartida().aplicarJugador(nombreUsuario.getText());
		});
		botonSiguenteEscena.relocate(50, 450);

		groupDificultad.selectedToggleProperty().addListener(new ControladorSeleccionarDificultad(groupDificultad, director, 
		opcionFacil, opcionNormal, opcionDificil));

		Pane pane = new Pane(etiquetaTitulo, etiquetaUsuario, nombreUsuario, etiquetaDificultad,
				opcionFacil, opcionNormal, opcionDificil, botonSiguenteEscena);
		pane.setStyle("-fx-background-color: rgb(168,129,65)");
		pane.setPrefSize(500, 500);

        this.getChildren().addAll(pane);
	}
}
