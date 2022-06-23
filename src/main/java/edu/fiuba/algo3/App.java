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
import edu.fiuba.algo3.modelo.modificadores.*;


/**
 * JavaFX App
 */
public class App extends Application {
    private static final int TAMANIO_MANZANA = 35;
    private static final int TAMANIO_CALLE = 15;
    private static final int OFFSET_X = -9;
    private static final int OFFSET_Y = 3;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        
        Juego juego = new Juego();
        juego.aplicarEstado(new Auto(juego.vehiculo));
        GridPane gp = new GridPane();
        
        gp.setPadding(new Insets(6));
        gp.setHgap( 15 );
        gp.setVgap( 15 );

        Image auto = new Image(new FileInputStream("assets/car.png"));
        Image piquete = new Image(new FileInputStream("assets/tire.png"));
        Image policia = new Image(new FileInputStream("assets/policia2.png"));
        Image pozo = new Image(new FileInputStream("assets/pozo.png"));
        Image sorpresa = new Image(new FileInputStream("assets/sorpresa.png"));

        ImageView imageView = new ImageView(auto);
        imageView.setX(TAMANIO_MANZANA + OFFSET_X);
        imageView.setY(TAMANIO_MANZANA + OFFSET_Y);

        Pane pane = new Pane(gp, imageView); 
        var scene = new Scene(pane);

        scene.setOnKeyReleased(e-> {
            if (e.getCode() == KeyCode.UP) {
                juego.mover(new DireccionArriba());
                imageView.setRotate(-90);
            } else if (e.getCode() == KeyCode.DOWN) {
                juego.mover(new DireccionAbajo());
                imageView.setRotate(90);
            } else if (e.getCode() == KeyCode.LEFT) {
                juego.mover(new DireccionIzquierda());
                imageView.setRotate(180);
            } else if (e.getCode() == KeyCode.RIGHT) {
                juego.mover(new DireccionDerecha());
                imageView.setRotate(0);
            }
            imageView.setX(TAMANIO_MANZANA + juego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X);
            imageView.setY(TAMANIO_MANZANA + juego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
            stage.setTitle("Movimientos: " + juego.vehiculo.movimientos);
        });

        for (int i = 0; i < juego.mapSize; i++) {
            for (int j = 0; j < juego.mapSize; j++) {
                Calle calle = juego.mapa.callesHorizontales.get(i).get(j);
                if (calle.obstaculo.getClass() == Piquete.class) {
                    ImageView imagen = new ImageView(piquete);
                    imagen.setX((TAMANIO_MANZANA / 2) + ((TAMANIO_MANZANA + TAMANIO_CALLE) * i));
                    imagen.setY(TAMANIO_MANZANA + ((TAMANIO_MANZANA + TAMANIO_CALLE) * j));
                    pane.getChildren().add(imagen);
                }
                if (calle.obstaculo.getClass() == ControlPolicial.class) {
                    ImageView imagen = new ImageView(policia);
                    imagen.setFitHeight(30);
                    imagen.setFitWidth(30);
                    imagen.setX((TAMANIO_MANZANA / 2) + ((TAMANIO_MANZANA + TAMANIO_CALLE) * i));
                    imagen.setY(TAMANIO_MANZANA + ((TAMANIO_MANZANA + TAMANIO_CALLE) * j));
                    pane.getChildren().add(imagen);
                }
                if (calle.obstaculo.getClass() == Pozo.class) {
                    ImageView imagen = new ImageView(pozo);
                    imagen.setFitHeight(30);
                    imagen.setFitWidth(30);
                    imagen.setX((TAMANIO_MANZANA / 2) + ((TAMANIO_MANZANA + TAMANIO_CALLE) * i));
                    imagen.setY(TAMANIO_MANZANA + ((TAMANIO_MANZANA + TAMANIO_CALLE) * j));
                    pane.getChildren().add(imagen);
                }
                if ((calle.sorpresa.getClass() == SorpresaFavorable.class) || 
                (calle.sorpresa.getClass() == SorpresaDesfavorable.class) || 
                (calle.sorpresa.getClass() == SorpresaVehiculo.class)) {
                    ImageView imagen = new ImageView(sorpresa);
                    imagen.setFitHeight(30);
                    imagen.setFitWidth(30);
                    imagen.setX((TAMANIO_MANZANA / 2) + ((TAMANIO_MANZANA + TAMANIO_CALLE) * i));
                    imagen.setY(TAMANIO_MANZANA + ((TAMANIO_MANZANA + TAMANIO_CALLE) * j));
                    pane.getChildren().add(imagen);
                }
            }
        }
        
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