package edu.fiuba.algo3.view;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.beans.value.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.controller.ControladorMovimiento;

public class ContenedorMenu extends VBox {
	private JuegoDirector director;
	private Juego juego;
	public ContenedorMenu(JuegoDirector director) {
		this.director = director;
		this.juego = director.obtenerPartida();

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiqueta.setText("Ingrese su nombre");
        etiqueta.setTextFill(Color.web("#66A7C5"));

		TextField nombreUsuario = new TextField();

		Label etiquetaVehiculo = new Label();
        etiquetaVehiculo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		etiquetaVehiculo.setText("Elija el vehículo inicial:");
        etiquetaVehiculo.setTextFill(Color.web("#66A7C5"));

		final ToggleGroup group = new ToggleGroup();

		RadioButton opcionAuto = new RadioButton("Auto");
		opcionAuto.setToggleGroup(group);
		opcionAuto.setSelected(true);

		RadioButton opcionMoto = new RadioButton("Moto");
		opcionMoto.setToggleGroup(group);

		RadioButton opcionCamioneta = new RadioButton("Camioneta");
		opcionCamioneta.setToggleGroup(group);

		Button botonJugar = new Button();
        botonJugar.setText("Jugar");
		botonJugar.setOnAction(e -> {
			Button button = (Button) e.getSource();
    		Scene scene = button.getScene();
			ContenedorMapa contenedorMapa = new ContenedorMapa(juego);
			scene.setRoot(contenedorMapa);
			contenedorMapa.getScene().setOnKeyReleased(new ControladorMovimiento(director, contenedorMapa));
			contenedorMapa.getScene().getWindow().sizeToScene();
			juego.aplicarJugador(nombreUsuario.getText());
		});


		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
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
		});
        this.getChildren().addAll(etiqueta, nombreUsuario, etiquetaVehiculo,
		opcionAuto, opcionMoto, opcionCamioneta, botonJugar);
	}
}
