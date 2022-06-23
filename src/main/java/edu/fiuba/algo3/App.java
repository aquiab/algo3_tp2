package edu.fiuba.algo3;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import edu.fiuba.algo3.modelo.*;


/**
 * JavaFX App
 */
public class App extends Application {
    private static final int TAMANIO_MANZANA = 35;
    private static final int TAMANIO_CALLE = 15;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        
        Juego juego = new Juego();
        juego.aplicarEstado(new Auto(juego.vehiculo));
        GridPane gp = new GridPane();
        
        gp.setHgap( 15 );
        gp.setVgap( 15 );

        Image image = new Image(new FileInputStream("assets/car.png"));
        ImageView imageView = new ImageView(image);

        Pane pane = new Pane(gp, imageView); 
        var scene = new Scene(pane);

        scene.setOnKeyPressed(e-> {
            if (e.getCode() == KeyCode.UP) {
                juego.mover(new DireccionArriba());
            } else if (e.getCode() == KeyCode.DOWN) {
                juego.mover(new DireccionAbajo());
            } else if (e.getCode() == KeyCode.LEFT) {
                juego.mover(new DireccionIzquierda());
            } else if (e.getCode() == KeyCode.RIGHT) {
                juego.mover(new DireccionDerecha());
            }
            imageView.setX(juego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE));
            imageView.setY(juego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE));
            System.out.print(juego.vehiculo.posicion.x);
            System.out.print(",");
            System.out.print(juego.vehiculo.posicion.y);
            System.out.print("\n");
            System.out.print(juego.mapSize);
        });
        for (int i = 0; i < juego.mapSize; i++) {
            for (int j = 0; j < juego.mapSize; j++) {
                Rectangle r = new Rectangle();
                r.setHeight(TAMANIO_MANZANA);
                r.setWidth(TAMANIO_MANZANA);
                r.setArcWidth(10);
                r.setArcHeight(10);
                r.setFill(Color.GRAY);
                gp.add(r, i, j);
            }
        }
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}