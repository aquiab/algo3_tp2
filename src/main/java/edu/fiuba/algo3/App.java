package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.constructor_juego.JuegoDirector;
import edu.fiuba.algo3.modelo.estado.Auto;
import edu.fiuba.algo3.modelo.estado.Camioneta;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.Piquete;
import edu.fiuba.algo3.modelo.fabrica_obstaculos.Pozo;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.Meta;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.SopresaPuntaje;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.SorpresaVehiculo;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    private Scene active_scene;


    //Animaciones para el vehículo.
    private void actualizarMovimientoHorizontal(ImageView imageView, Juego juego) {
        try {
            imageView.setImage(obtenerVehiculo(juego));
        } catch (Exception e) {}
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.seconds(0.5));
        transition.setToX(juego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X+5);
        transition.play();
    }

    private void actualizarMovimientoVertical(ImageView imageView, Juego juego) {
        try {
            imageView.setImage(obtenerVehiculo(juego));
        } catch (Exception e) {
            System.out.println(e);
        }
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.seconds(0.5));
        transition.setToY( juego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
        transition.play();
    }

    private void rotarVehiculo(ImageView vehiculo, int i) {
        RotateTransition transition = new RotateTransition();
        transition.setNode(vehiculo);
        transition.setDuration(Duration.seconds(0.1));
        transition.setToAngle(i);
        transition.play();
    }

    //Dibujo del mapa y su contenido.
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

    private Image obtenerVehiculo(Juego juego) throws FileNotFoundException {
        Image auto = new Image(new FileInputStream("assets/car.png"));
        Image camioneta = new Image(new FileInputStream("assets/4x4.png"));
        Image moto = new Image(new FileInputStream("assets/motorbike.png"));
        if (juego.vehiculo.estado.getClass() == Auto.class) return auto;
        if (juego.vehiculo.estado.getClass() == Camioneta.class) return camioneta;
        return moto;
    }

    //Generación de las distintas pantallas del juego.
    private void dibujarMenuPrincipal(Scene menuPrincipal, Stage stage) {
        active_scene = menuPrincipal;
        stage.setScene(active_scene);
    }

    private void dibujarPantallaDeJuego(JuegoDirector director, Scene scene0, Stage stage) throws FileNotFoundException {
        Juego juego = director.obtenerPartida();
        juego.aplicarJugador("RAUL");
        GridPane calles = dibujarCalles(juego.mapSize);
        ImageView vehiculo = dibujarVehiculo(TAMANIO_MANZANA + OFFSET_X, TAMANIO_MANZANA + OFFSET_Y, "assets/car.png");
        Pane pane = new Pane(calles, vehiculo);
        Pane pane2 = new Pane();

        dibujarObstaculosYSorpresas(pane, juego, juego.mapa.callesHorizontales, (TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);
        dibujarObstaculosYSorpresas(pane, juego, juego.mapa.callesVerticales, TAMANIO_MANZANA, (TAMANIO_MANZANA / 2), 0, OFFSET_SORPRESA);

        //Desde aca es de la sombra
        Rectangle rectangulo = new Rectangle();
        rectangulo.setHeight(juego.mapSize* (TAMANIO_MANZANA + TAMANIO_CALLE));
        rectangulo.setWidth(juego.mapSize* (TAMANIO_MANZANA + TAMANIO_CALLE));

        Circle visionVehiculo = new Circle();
        visionVehiculo.setCenterX(juego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE) + TAMANIO_MANZANA + TAMANIO_CALLE);
        visionVehiculo.setCenterY(juego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE) + TAMANIO_MANZANA + TAMANIO_CALLE);
        visionVehiculo.setRadius(2 * (TAMANIO_MANZANA + TAMANIO_CALLE));

        Circle visionMeta = new Circle();
        visionMeta.setCenterX((juego.mapSize) * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X);
        visionMeta.setCenterY((juego.mapa.obtenerMetaY()+1) * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
        visionMeta.setRadius(TAMANIO_MANZANA + TAMANIO_CALLE);

        Shape sombra = Shape.subtract(rectangulo, visionVehiculo);
        sombra = Shape.subtract(sombra, visionMeta);
        pane2.setClip(sombra);
        pane2.setStyle("-fx-background-color: black");
        //Hasta aca
        StackPane stack = new StackPane(pane, pane2);

        var pantallaJuego = new Scene(stack);
        active_scene = pantallaJuego;
        stage.setScene(active_scene);
        Juego finalJuego = juego;

        pantallaJuego.setOnKeyReleased(tecla -> {
            switch (tecla.getCode().toString()) {
                case "UP":
                    finalJuego.mover(new DireccionArriba());
                    rotarVehiculo(vehiculo, -90);
                    actualizarMovimientoVertical(vehiculo, finalJuego);
                    break;
                case "DOWN":
                    finalJuego.mover(new DireccionAbajo());
                    rotarVehiculo(vehiculo, 90);
                    actualizarMovimientoVertical(vehiculo, finalJuego);
                    break;
                case "LEFT":
                    finalJuego.mover(new DireccionIzquierda());
                    rotarVehiculo(vehiculo, 180);
                    actualizarMovimientoHorizontal(vehiculo, finalJuego);
                    break;
                case "RIGHT":
                    finalJuego.mover(new DireccionDerecha());
                    rotarVehiculo(vehiculo, 0);
                    actualizarMovimientoHorizontal(vehiculo, finalJuego);
                    break;
                case "ENTER":
                    dibujarMenuPrincipal(scene0, stage);
                    break;
            }
            pane.getChildren().retainAll(vehiculo, calles);

            //Actualización de obstáculos y sorpresas.
            try {
                dibujarObstaculosYSorpresas(pane, finalJuego, juego.mapa.callesHorizontales,
                        (TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);
                dibujarObstaculosYSorpresas(pane, finalJuego, juego.mapa.callesVerticales,
                        TAMANIO_MANZANA, (TAMANIO_MANZANA / 2), 0, OFFSET_SORPRESA);
            } catch (Exception exception) {
                System.out.print(exception);
            }

            //Actualización de la visión.
            visionVehiculo.setCenterX(finalJuego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE) + TAMANIO_MANZANA + TAMANIO_CALLE);
            visionVehiculo.setCenterY(finalJuego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE) + TAMANIO_MANZANA + TAMANIO_CALLE);
            visionMeta.setCenterY((finalJuego.mapa.obtenerMetaY()+1) * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
            Shape sombra1 = Shape.subtract(rectangulo, visionVehiculo);
            sombra1 = Shape.subtract(sombra1, visionMeta);
            pane2.setClip(sombra1);

            //Actualización del título de la ventana.
            stage.setTitle("Movimientos: " + new DecimalFormat("#.##").format(finalJuego.vehiculo.movimientos));
        });
    }

    private void dibujarNuevaPartida(JuegoDirector director, Scene scene0, Stage stage) {
        try {
            dibujarPantallaDeJuego(director, scene0, stage);
        }  catch (Exception error) {
            System.out.println(error);
        }
    }

    private void dibujarPantallaDeDificultad(Stage stage, Scene scene0, JuegoDirector director) {
        Button botonFacil = new Button("Fácil");
        Button botonMedio = new Button("Medio");
        Button botonDificil = new Button("Dificil");
        Label label1 = new Label("Seleccione dificultad");
        label1.setUnderline(true);
        VBox vbox1 = new VBox(30, label1, botonFacil, botonMedio, botonDificil);
        VBox.setMargin(label1, new Insets(60));
        vbox1.setPrefSize(350, 500);
        vbox1.setAlignment(Pos.TOP_CENTER);
        var sceneDificultad = new Scene(vbox1);
        active_scene = sceneDificultad;
        stage.setScene(active_scene);

        botonFacil.setOnAction(ee -> {
            director.configurarPartidaFacil();
            dibujarNuevaPartida(director, scene0, stage);
        });
        botonMedio.setOnAction(ee -> {
            director.configurarPartidaNormal();
            dibujarNuevaPartida(director, scene0, stage);
        });
        botonDificil.setOnAction(ee -> {
            director.configurarPartidaDificil();
            dibujarNuevaPartida(director, scene0, stage);
        });
    }

    private void dibujarTablaDePosiciones(JuegoDirector director, Scene scene0, Stage stage) {
        Button botonVolver = new Button("Volver");
        VBox vboxizq = new VBox();
        VBox vboxder = new VBox();
        HBox hbox = new HBox(50, botonVolver, vboxizq, vboxder);
        hbox.setPrefSize(350, 500);
        hbox.setAlignment(Pos.TOP_CENTER);
        var scene2 = new Scene(hbox);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        vboxizq.getChildren().clear();
        vboxder.getChildren().clear();
        vboxizq.getChildren().add(new Label("Jugador"));
        vboxder.getChildren().add(new Label("Puntaje"));
        Juego juego = director.obtenerPartida();
        Jugador jugador = juego.ranking.devolverGanador();
        while ( jugador != null) {
            vboxizq.getChildren().add(new Label(jugador.nombre));
            vboxder.getChildren().add(new Label(String.valueOf(jugador.movimientos)));
            jugadores.add(jugador);
            jugador = juego.ranking.devolverGanador();
        }
        for (int i = 0; i < jugadores.size(); i++) {
            juego.ranking.agregarJugador(jugadores.get(i));
        }
        active_scene = scene2;
        stage.setScene(active_scene);
        botonVolver.setOnAction(e -> dibujarMenuPrincipal(scene0, stage));
    }

    @Override
    public void start(Stage stage) {
        JuegoDirector director = new JuegoDirector();

        /*Media musica = new Media(new File("assets/musica.mp3").toURI().toString());
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();*/

        //Escena MainMenu
        Button botonRanking = new Button("Ranking");
        Button botonSalir = new Button("Salir");
        Button botonJugar = new Button("Jugar");
        Label label = new Label("AlgoGPS");
        label.setUnderline(true);
        VBox vbox = new VBox(30, label, botonJugar, botonRanking, botonSalir);
        VBox.setMargin(label, new Insets(60));
        vbox.setPrefSize(350, 500);
        vbox.setAlignment(Pos.TOP_CENTER);
        var scene0 = new Scene(vbox);

        active_scene = scene0;

        //Accion de los botones
        botonJugar.setOnAction(e -> dibujarPantallaDeDificultad(stage, scene0, director));
        botonSalir.setOnAction(e -> System.exit(0));
        botonRanking.setOnAction(e -> dibujarTablaDePosiciones(director, scene0, stage));

        stage.setScene(active_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}