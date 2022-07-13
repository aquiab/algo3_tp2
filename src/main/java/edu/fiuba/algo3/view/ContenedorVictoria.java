package edu.fiuba.algo3.view;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class ContenedorVictoria extends VBox {
	public ContenedorVictoria(JuegoDirector director) {
		Juego juego = director.obtenerPartida();
        Ranking rank = director.obtenerRanking();
        Jugador jugador = rank.devolverGanador();

		Button botonVolver = new Button("Volver");
        botonVolver.relocate(20, 460);

        VBox vboxizq = new VBox();
        VBox vboxder = new VBox();
        HBox hbox = new HBox(50, vboxizq, vboxder);
        hbox.relocate(175, 150);

        Label felicidades = new Label();
        felicidades.setText("Felicidades!");
        felicidades.relocate(165, 20);
        felicidades.setFont(new Font(30));

        Label llegaste = new Label();
        llegaste.setText("Llegaste a la meta con un puntaje de " + String.valueOf(juego.obtenerMovimientos()));
        llegaste.relocate(110, 60);
        llegaste.setFont(new Font(15));

        Label ranking = new Label();
        ranking.setText("Ranking");
        ranking.relocate(205, 110);
        ranking.setFont(new Font(20));

        Pane pane = new Pane(hbox, botonVolver, felicidades, ranking, llegaste);
        pane.setPrefSize(350, 500);
        pane.setStyle("-fx-background-color: #ec6553");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        vboxizq.getChildren().clear();
        vboxder.getChildren().clear();
        vboxizq.getChildren().add(new Label("Jugador"));
        vboxder.getChildren().add(new Label("Puntaje"));

        while (jugador != null) {
            vboxizq.getChildren().add(new Label(jugador.nombre));
            vboxder.getChildren().add(new Label(String.valueOf(jugador.movimientos)));
            jugadores.add(jugador);
            jugador = juego.ranking.devolverGanador();
        }
        for (int i = 0; i < jugadores.size(); i++) {
            juego.ranking.agregarJugador(jugadores.get(i));
        }
        this.getChildren().add(pane);
        botonVolver.setOnAction(e -> {
            director.refreshConstructor();
            director.setearPartidaDefault();
			this.getScene().setRoot(new ContenedorMenu(director));
		});
	}
}
