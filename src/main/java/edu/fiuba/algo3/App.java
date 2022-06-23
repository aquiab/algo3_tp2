package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.scene.media.*;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.text.DecimalFormat;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.modificadores.*;


public class App extends Application {
    private static final int TAMANIO_MANZANA = 35;
    private static final int TAMANIO_CALLE = 15;
    private static final int OFFSET_X = -9;
    private static final int OFFSET_Y = 3;
    private static final int OFFSET_SORPRESA = 15;

    private GridPane dibujarCalles(int size) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(6));
        gp.setHgap( 15 );
        gp.setVgap( 15 );
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle r = new Rectangle();
                r.setHeight(TAMANIO_MANZANA);
                r.setWidth(TAMANIO_MANZANA);
                r.setArcWidth(10);
                r.setArcHeight(10);
                r.setFill(Color.GRAY);
                gp.add(r, i, j);
            }
        }
        return gp;
    }

    private ImageView dibujarVehiculo(int x, int y, String src) throws FileNotFoundException {
        Image auto = new Image(new FileInputStream(src));
        ImageView imageView = new ImageView(auto);
        imageView.setX(x);
        imageView.setY(y);
        return imageView;
    }

    private void dibujarElementoCalle(Image img, Pane pane, int x, int y) {
        ImageView imagen = new ImageView(img);
        imagen.setX(x);
        imagen.setY(y);
        pane.getChildren().add(imagen);
    }

    private void dibujarObstaculosYSorpresas(Pane pane, Juego juego, LinkedList<LinkedList<Calle>> calles,
    int distanciaX, int distanciaY, int offsetSorpresaX, int offsetSorpresaY) throws FileNotFoundException {
        Image piquete = new Image(new FileInputStream("assets/tire.png"));
        Image policia = new Image(new FileInputStream("assets/policia.png"));
        Image pozo = new Image(new FileInputStream("assets/pozo.png"));
        Image sorpresa = new Image(new FileInputStream("assets/sorpresa.png"));
        Image meta = new Image(new FileInputStream("assets/meta.png"));

        for (int i = 0; i < juego.mapSize; i++) {
            for (int j = 0; j < juego.mapSize; j++) {
                Calle calle = calles.get(i).get(j);
                int x = distanciaX + (TAMANIO_MANZANA + TAMANIO_CALLE) * i;
                int y = distanciaY + (TAMANIO_MANZANA + TAMANIO_CALLE) * j;

                if (calle.obstaculo.getClass() == Piquete.class) {
                    dibujarElementoCalle(piquete, pane, x, y);
                } else if (calle.obstaculo.getClass() == ControlPolicial.class) {
                    dibujarElementoCalle(policia, pane, x, y);
                } else if (calle.obstaculo.getClass() == Pozo.class) {
                    dibujarElementoCalle(pozo, pane, x, y);
                } else if (calle.obstaculo.getClass() == Meta.class) {
                    dibujarElementoCalle(meta, pane, x + 5, y - 10);
                }
                
                if ((calle.sorpresa.getClass() == SorpresaFavorable.class) || 
                (calle.sorpresa.getClass() == SorpresaDesfavorable.class) || 
                (calle.sorpresa.getClass() == SorpresaVehiculo.class)) {
                    dibujarElementoCalle(sorpresa, pane, x - offsetSorpresaX, y - offsetSorpresaY);
                }
            }
        }
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Juego juego = new Juego();
        juego.aplicarEstado(new Auto(juego.vehiculo));
        juego.aplicarJugador("RAUL");

        ImageView vehiculo =  dibujarVehiculo(TAMANIO_MANZANA + OFFSET_X, TAMANIO_MANZANA + OFFSET_Y, "assets/car.png");
        Pane pane = new Pane(dibujarCalles(juego.mapSize), vehiculo);

        dibujarObstaculosYSorpresas(pane, juego, juego.mapa.callesHorizontales,
        (TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);
        dibujarObstaculosYSorpresas(pane, juego, juego.mapa.callesVerticales,
        TAMANIO_MANZANA, (TAMANIO_MANZANA / 2), 0, OFFSET_SORPRESA);

        Media musica = new Media(new File("assets/musica.mp3").toURI().toString());
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();

        var scene = new Scene(pane);

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                juego.mover(new DireccionArriba());
                try {
                    actualizarMovimiento(pane, vehiculo, juego, -90);
                } catch (FileNotFoundException error) {}

            } else if (e.getCode() == KeyCode.DOWN) {
                juego.mover(new DireccionAbajo());
                try {
                    actualizarMovimiento(pane, vehiculo, juego, 90);
                } catch (FileNotFoundException error) {}
            } else if (e.getCode() == KeyCode.LEFT) {
                juego.mover(new DireccionIzquierda());
                try {
                    actualizarMovimiento(pane, vehiculo, juego, 180);
                } catch (FileNotFoundException error) {}
            } else if (e.getCode() == KeyCode.RIGHT) {
                juego.mover(new DireccionDerecha());
                try {
                    actualizarMovimiento(pane, vehiculo, juego, 0);
                } catch (FileNotFoundException error) {}
            }
            stage.setTitle("Movimientos: " + new DecimalFormat("#.##").format(juego.vehiculo.movimientos));
        });
        
        stage.setScene(scene);
        stage.show();
    }

    private void actualizarMovimiento(Pane pane, ImageView imageView, Juego juego, int rotar) throws FileNotFoundException {
        imageView.setImage(obtenerVehiculo(juego));
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        imageView.setRotate(rotar);
        imageView.setX(TAMANIO_MANZANA + juego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X);
        imageView.setY(TAMANIO_MANZANA + juego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
    }

    private Image obtenerVehiculo(Juego juego) throws FileNotFoundException {
        if (juego.vehiculo.estado.getClass() == Auto.class) {
            return new Image(new FileInputStream("assets/car.png"));
        }
        if (juego.vehiculo.estado.getClass() == Camioneta.class) {
            return new Image(new FileInputStream("assets/4x4.png"));
        }
        return new Image(new FileInputStream("assets/motorbike.png"));
    }

    public static void main(String[] args) {
        launch();
    }

}