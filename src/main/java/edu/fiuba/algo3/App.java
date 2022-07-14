package edu.fiuba.algo3;
import edu.fiuba.algo3.modelo.Ranking;
import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import edu.fiuba.algo3.view.ContenedorSeleccionarDificultad;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        JuegoDirector director = new JuegoDirector(new Ranking());
        director.setearPartidaDefault();
        Scene scene = new Scene(new ContenedorSeleccionarDificultad(director));
        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.show();
    }
}