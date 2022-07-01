package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.estados.Auto;
import edu.fiuba.algo3.modelo.estados.Camioneta;
import edu.fiuba.algo3.modelo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.sistema_de_posicion.DireccionAbajo;
import edu.fiuba.algo3.modelo.sistema_de_posicion.DireccionArriba;
import edu.fiuba.algo3.modelo.sistema_de_posicion.DireccionDerecha;
import edu.fiuba.algo3.modelo.sistema_de_posicion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.sorpresas.Meta;
import edu.fiuba.algo3.modelo.sorpresas.SopresaPuntaje;
import edu.fiuba.algo3.modelo.sorpresas.SorpresaVehiculo;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
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
import java.nio.file.PathMatcher;
import java.util.LinkedList;
import java.text.DecimalFormat;
import edu.fiuba.algo3.modelo.*;
import javafx.util.Duration;


public class App extends Application {
    private static final int TAMANIO_MANZANA = 35;
    private static final int TAMANIO_CALLE = 15;
    private static final int OFFSET_X = -7;
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
                }
                
                if ((calle.sorpresa.getClass() == SopresaPuntaje.class) ||
                (calle.sorpresa.getClass() == SorpresaVehiculo.class)) {
                    dibujarElementoCalle(sorpresa, pane, x - offsetSorpresaX, y - offsetSorpresaY);
                } else if (calle.sorpresa.getClass() == Meta.class) {
                    dibujarElementoCalle(meta, pane, x + 5, y - 10);
                }
            }
        }
    }

    private ImageView dibujarVehiculo(int x, int y, String src) throws FileNotFoundException {
        Image auto = new Image(new FileInputStream(src));
        ImageView imageView = new ImageView(auto);
        imageView.setX(x);
        imageView.setY(y);
        return imageView;
    }

    private void actualizarMovimientoHorizontal(ImageView imageView, Juego juego) {
        try {
            imageView.setImage(obtenerVehiculo(juego));
        } catch (Exception e) {}
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.seconds(0.5));
        transition.setToX(juego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X);
        transition.play();
    }

    private void actualizarMovimientoVertical(ImageView imageView, Juego juego) {
        try {
            imageView.setImage(obtenerVehiculo(juego));
        } catch (Exception e) {}
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.seconds(0.5));
        transition.setToY( juego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
        transition.play();
    }

    private Image obtenerVehiculo(Juego juego) throws FileNotFoundException {
        Image auto = new Image(new FileInputStream("assets/car.png"));
        Image camioneta = new Image(new FileInputStream("assets/4x4.png"));
        Image moto = new Image(new FileInputStream("assets/motorbike.png"));
        if (juego.vehiculo.estado.getClass() == Auto.class) return auto;
        if (juego.vehiculo.estado.getClass() == Camioneta.class) return camioneta;
        return moto;
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Juego juego = new Juego();
        juego.aplicarEstadoInicial(new Auto(juego.vehiculo));
        juego.aplicarJugador("RAUL");

        ImageView vehiculo =  dibujarVehiculo(TAMANIO_MANZANA, TAMANIO_MANZANA, "assets/car.png");
        GridPane calles = dibujarCalles(juego.mapSize);
        Pane pane = new Pane(calles, vehiculo);

        /*Media musica = new Media(new File("assets/musica.mp3").toURI().toString());
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();*/

        var scene = new Scene(pane);

        dibujarObstaculosYSorpresas(pane, juego, juego.mapa.callesHorizontales,
                (TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);
        dibujarObstaculosYSorpresas(pane, juego, juego.mapa.callesVerticales,
                (TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                juego.mover(new DireccionArriba());
                //vehiculo.setRotate(-90);
                rotarVehiculo(vehiculo, -90);
                actualizarMovimientoVertical(vehiculo, juego);

            } else if (e.getCode() == KeyCode.DOWN) {
                juego.mover(new DireccionAbajo());
                //vehiculo.setRotate(90);
                rotarVehiculo(vehiculo, 90);
                actualizarMovimientoVertical(vehiculo, juego);
            } else if (e.getCode() == KeyCode.LEFT) {
                juego.mover(new DireccionIzquierda());
                //vehiculo.setRotate(180);
                rotarVehiculo(vehiculo, 180);
                actualizarMovimientoHorizontal(vehiculo, juego);
            } else if (e.getCode() == KeyCode.RIGHT) {
                juego.mover(new DireccionDerecha());
                //vehiculo.setRotate(0);
                rotarVehiculo(vehiculo, 0);
                actualizarMovimientoHorizontal(vehiculo, juego);
            }
            try {
                pane.getChildren().retainAll(vehiculo, calles);
                //actualizarMovimiento(vehiculo, juego);
                dibujarObstaculosYSorpresas(pane, juego, juego.mapa.callesHorizontales,
                        (TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);
                dibujarObstaculosYSorpresas(pane, juego, juego.mapa.callesVerticales,
                        TAMANIO_MANZANA, (TAMANIO_MANZANA / 2), 0, OFFSET_SORPRESA);
            }
            catch (Exception exception) {
                System.out.print(exception);
            }

            stage.setTitle("Movimientos: " + new DecimalFormat("#.##").format(juego.vehiculo.movimientos));
        });
        
        stage.setScene(scene);
        stage.show();
    }

    private void rotarVehiculo(ImageView vehiculo, int i) {
        RotateTransition transition = new RotateTransition();
        transition.setNode(vehiculo);
        transition.setDuration(Duration.seconds(0.1));
        transition.setToAngle(i);
        transition.play();
    }

    public static void main(String[] args) {
        launch();
    }

}