package edu.fiuba.algo3.view;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import java.util.ArrayList;

public class ContenedorVictoria extends VBox {
	public ContenedorVictoria(JuegoDirector director) {
		Juego juego = director.obtenerPartida();
		Button botonVolver = new Button("Volver");
        VBox vboxizq = new VBox();
        VBox vboxder = new VBox();
        HBox hbox = new HBox(50, botonVolver, vboxizq, vboxder);
        hbox.setPrefSize(350, 500);
        hbox.setAlignment(Pos.TOP_CENTER);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        vboxizq.getChildren().clear();
        vboxder.getChildren().clear();
        vboxizq.getChildren().add(new Label("Jugador"));
        vboxder.getChildren().add(new Label("Puntaje"));
        Jugador jugador = juego.ranking.devolverGanador();
        while (jugador != null) {
            vboxizq.getChildren().add(new Label(jugador.nombre));
            vboxder.getChildren().add(new Label(String.valueOf(jugador.movimientos)));
            jugadores.add(jugador);
            jugador = juego.ranking.devolverGanador();
        }
        for (int i = 0; i < jugadores.size(); i++) {
            juego.ranking.agregarJugador(jugadores.get(i));
        }
        this.getChildren().add(hbox);
        botonVolver.setOnAction(e -> {
			this.getScene().setRoot(new ContenedorMenu(director));
		});
	}
}
