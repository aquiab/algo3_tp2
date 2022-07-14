package edu.fiuba.algo3.view;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.obstaculos.*;
import edu.fiuba.algo3.modelo.sorpresas.*;
import edu.fiuba.algo3.modelo.estado.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class ContenedorMapa extends StackPane {
	private static final int TAMANIO_MANZANA = 35;
	private static final int OFFSET_SORPRESA = 15;
	private static final int TAMANIO_CALLE = 15;
    private static final int OFFSET_X = -7;
    private static final int OFFSET_Y = 3;
    private Juego juego;
    private Pane vehiculo = new Pane();
    private Pane overlaySombra = new Pane();
    private Pane sorpresas = new Pane();
    private Pane obstaculos = new Pane();
    public ImageView imagenVehiculo = new ImageView();

	public ContenedorMapa(Juego juego) {
        this.juego = juego;
		dibujarCalles(juego.obtenerDimensionMapa());
        this.getChildren().addAll(obstaculos, sorpresas, vehiculo);
        dibujarSombra();
        
		try {
			dibujarObstaculosYSorpresas(juego, juego.obtenerCallesHorizontales(),
			(TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);
			dibujarObstaculosYSorpresas(juego, juego.obtenerCallesVerticales(),
			TAMANIO_MANZANA, (TAMANIO_MANZANA / 2), 0, OFFSET_SORPRESA);
            actualizarVehiculo();
            vehiculo.getChildren().add(imagenVehiculo);
		}
		catch (FileNotFoundException ff) {
		    System.out.println("Exception " + ff.toString());
		}
	}

	private void dibujarCalles(int size) {
        GridPane mapa = new GridPane();
        mapa.setPadding(new Insets(6));
        mapa.setHgap( 15 );
        mapa.setVgap( 15 );
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle r = new Rectangle();
                r.setHeight(TAMANIO_MANZANA);
                r.setWidth(TAMANIO_MANZANA);
                r.setArcWidth(10);
                r.setArcHeight(10);
                r.setFill(Color.GRAY);
                mapa.add(r, i, j);
            }
        }
        this.getChildren().add(mapa);
    }

	private void dibujarObstaculosYSorpresas(Juego juego, LinkedList<LinkedList<Calle>> calles,
    int distanciaX, int distanciaY, int offsetSorpresaX, int offsetSorpresaY) throws FileNotFoundException {
        Image piquete = new Image(new FileInputStream("assets/tire.png"));
        Image policia = new Image(new FileInputStream("assets/policia.png"));
        Image pozo = new Image(new FileInputStream("assets/pozo.png"));
        Image sorpresaImagen = new Image(new FileInputStream("assets/sorpresa.png"));
        Image meta = new Image(new FileInputStream("assets/meta.png"));

        for (int i = 0; i < juego.obtenerDimensionMapa(); i++) {
            for (int j = 0; j < juego.obtenerDimensionMapa(); j++) {
                Calle calle = calles.get(i).get(j);
                IObstaculo obstaculo = calle.obtenerObstaculo();
                ISorpresa sorpresa = calle.obtenerSorpresa();
                int x = distanciaX + (TAMANIO_MANZANA + TAMANIO_CALLE) * i;
                int y = distanciaY + (TAMANIO_MANZANA + TAMANIO_CALLE) * j;


                if (obstaculo.getClass() == Piquete.class) {
                    dibujarElementoCalle(obstaculos, piquete, x, y);
                } else if (obstaculo.getClass() == ControlPolicial.class) {
                    dibujarElementoCalle(obstaculos, policia, x, y);
                } else if (obstaculo.getClass() == Pozo.class) {
                    dibujarElementoCalle(obstaculos, pozo, x, y);
                }
                
                if ((sorpresa.getClass() == SorpresaVehiculo.class) || sorpresa.getClass() == SorpresaPuntaje.class) {
                    dibujarElementoCalle(sorpresas, sorpresaImagen, x - offsetSorpresaX, y - offsetSorpresaY);
                } else if (sorpresa.getClass() == Meta.class) {
                    dibujarElementoCalle(sorpresas, meta, x + 5, y - 10);
                }
            }
        }
    }

	private void dibujarElementoCalle(Pane pane, Image img, int x, int y) {
        ImageView imagen = new ImageView(img);
        imagen.setX(x);
        imagen.setY(y);
        pane.getChildren().add(imagen);
    }

    private void actualizarVehiculo() {
        Image image;
        try {
            if (juego.obtenerEstadoVehiculo().getClass() == Auto.class) {
                image = new Image(new FileInputStream("assets/car.png"));
            } else if (juego.obtenerEstadoVehiculo().getClass() == Camioneta.class) {
                image = new Image(new FileInputStream("assets/4x4.png"));
            } else {
                image = new Image(new FileInputStream("assets/motorbike.png"));
            }
            imagenVehiculo.setImage(image);
        }
        catch (FileNotFoundException ff) {
		    System.out.println("Exception " + ff.toString());
		}
        imagenVehiculo.setX(TAMANIO_MANZANA + juego.obtenerPosicionXVehiculo() * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X);
        imagenVehiculo.setY(TAMANIO_MANZANA + juego.obtenerPosicionYVehiculo() * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
    }

    private void dibujarSombra() {
        Rectangle rectangulo = new Rectangle();
        rectangulo.setHeight(juego.obtenerDimensionMapa() * (TAMANIO_MANZANA + TAMANIO_CALLE));
        rectangulo.setWidth(juego.obtenerDimensionMapa() * (TAMANIO_MANZANA + TAMANIO_CALLE));

        Circle visionVehiculo = new Circle();
        visionVehiculo.setCenterX(juego.obtenerPosicionXVehiculo() * (TAMANIO_MANZANA + TAMANIO_CALLE) + TAMANIO_MANZANA + TAMANIO_CALLE);
        visionVehiculo.setCenterY(juego.obtenerPosicionYVehiculo() * (TAMANIO_MANZANA + TAMANIO_CALLE) + TAMANIO_MANZANA + TAMANIO_CALLE);
        visionVehiculo.setRadius(2 * (TAMANIO_MANZANA + TAMANIO_CALLE));

        Circle visionMeta = new Circle();
        visionMeta.setCenterX((juego.obtenerDimensionMapa()) * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X);
        visionMeta.setCenterY((juego.obtenerCoordenadaMeta() + 1) * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
        visionMeta.setRadius(TAMANIO_MANZANA + TAMANIO_CALLE);

        Shape sombra = Shape.subtract(rectangulo, visionVehiculo);
        sombra = Shape.subtract(sombra, visionMeta);
        overlaySombra.setClip(sombra);
        overlaySombra.setStyle("-fx-background-color: black");

        this.getChildren().add(overlaySombra);
    }

    private void actualizarMapa(Juego juego) throws FileNotFoundException {
        this.getChildren().remove(sorpresas);
        this.sorpresas = new Pane();
        dibujarObstaculosYSorpresas(juego, juego.obtenerCallesHorizontales(),
		(TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);
		dibujarObstaculosYSorpresas(juego, juego.obtenerCallesVerticales(),
		TAMANIO_MANZANA, (TAMANIO_MANZANA / 2), 0, OFFSET_SORPRESA);
        this.getChildren().add(sorpresas);
    }

    private void actualizarSombra() {
        this.getChildren().remove(overlaySombra);
        dibujarSombra();
    }

    public void actualizar(Juego juego) {
        try {
            actualizarMapa(juego);
        } catch (FileNotFoundException ff) {
		    System.out.println("Exception " + ff.toString());
	    }
        actualizarVehiculo();
        actualizarSombra();
    }
}