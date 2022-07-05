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
import edu.fiuba.algo3.modelo.fabrica_obstaculos.*;
import edu.fiuba.algo3.modelo.fabrica_sorpresa.*;
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
    private Pane mapaConElementos = new Pane();
    private Pane overlaySombra = new Pane();
    public ImageView imagenVehiculo = new ImageView();

	public ContenedorMapa(Juego juego) {
        this.juego = juego;
		dibujarCalles(juego.mapSize);
        this.getChildren().add(mapaConElementos);
        dibujarSombra();
        
		try {
			dibujarObstaculosYSorpresas(juego, juego.mapa.callesHorizontales,
			(TAMANIO_MANZANA / 2), TAMANIO_MANZANA, OFFSET_SORPRESA, 0);
			dibujarObstaculosYSorpresas(juego, juego.mapa.callesVerticales,
			TAMANIO_MANZANA, (TAMANIO_MANZANA / 2), 0, OFFSET_SORPRESA);
            actualizarVehiculo();
            mapaConElementos.getChildren().add(imagenVehiculo);
		}
		catch (FileNotFoundException ff) {
		    System.out.println("Exception " + ff.toString());
		}
	}

	private void dibujarCalles(int size) {
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
        this.getChildren().add(gp);
    }

	private void dibujarObstaculosYSorpresas(Juego juego, LinkedList<LinkedList<Calle>> calles,
    int distanciaX, int distanciaY, int offsetSorpresaX, int offsetSorpresaY) throws FileNotFoundException {
        Image piquete = new Image(new FileInputStream("assets/tire.png"));
        Image policia = new Image(new FileInputStream("assets/policia.png"));
        Image pozo = new Image(new FileInputStream("assets/pozo.png"));
        Image sorpresaImagen = new Image(new FileInputStream("assets/sorpresa.png"));
        Image meta = new Image(new FileInputStream("assets/meta.png"));

        for (int i = 0; i < juego.mapSize; i++) {
            for (int j = 0; j < juego.mapSize; j++) {
                Calle calle = calles.get(i).get(j);
                IObstaculo obstaculo = calle.obtenerObstaculo();
                ISorpresa sorpresa = calle.obtenerSorpresa();
                int x = distanciaX + (TAMANIO_MANZANA + TAMANIO_CALLE) * i;
                int y = distanciaY + (TAMANIO_MANZANA + TAMANIO_CALLE) * j;


                if (obstaculo.getClass() == Piquete.class) {
                    dibujarElementoCalle(piquete, x, y);
                } else if (obstaculo.getClass() == ControlPolicial.class) {
                    dibujarElementoCalle(policia, x, y);
                } else if (obstaculo.getClass() == Pozo.class) {
                    dibujarElementoCalle(pozo, x, y);
                }
                
                if ((sorpresa.getClass() == SorpresaVehiculo.class)) {
                    dibujarElementoCalle(sorpresaImagen, x - offsetSorpresaX, y - offsetSorpresaY);
                } else if (sorpresa.getClass() == Meta.class) {
                    dibujarElementoCalle(meta, x + 5, y - 10);
                }
            }
        }
    }

	private void dibujarElementoCalle(Image img, int x, int y) {
        ImageView imagen = new ImageView(img);
        imagen.setX(x);
        imagen.setY(y);
        mapaConElementos.getChildren().add(imagen);
    }

    private void actualizarVehiculo() {
        Image image;
        try {
            if (juego.vehiculo.estado.getClass() == Auto.class) {
                image = new Image(new FileInputStream("assets/car.png"));
            } else if (juego.vehiculo.estado.getClass() == Camioneta.class) {
                image = new Image(new FileInputStream("assets/4x4.png"));
            } else {
                image = new Image(new FileInputStream("assets/motorbike.png"));
            }
            imagenVehiculo.setImage(image);
        }
        catch (FileNotFoundException ff) {
		    System.out.println("Exception " + ff.toString());
		}
        imagenVehiculo.setX(TAMANIO_MANZANA + juego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X);
        imagenVehiculo.setY(TAMANIO_MANZANA + juego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
    }

    private void dibujarSombra() {
        Rectangle rectangulo = new Rectangle();
        rectangulo.setHeight(juego.mapSize * (TAMANIO_MANZANA + TAMANIO_CALLE));
        rectangulo.setWidth(juego.mapSize * (TAMANIO_MANZANA + TAMANIO_CALLE));

        Circle visionVehiculo = new Circle();
        visionVehiculo.setCenterX(juego.vehiculo.posicion.x * (TAMANIO_MANZANA + TAMANIO_CALLE) + TAMANIO_MANZANA + TAMANIO_CALLE);
        visionVehiculo.setCenterY(juego.vehiculo.posicion.y * (TAMANIO_MANZANA + TAMANIO_CALLE) + TAMANIO_MANZANA + TAMANIO_CALLE);
        visionVehiculo.setRadius(2 * (TAMANIO_MANZANA + TAMANIO_CALLE));

        Circle visionMeta = new Circle();
        visionMeta.setCenterX((juego.mapSize) * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_X);
        visionMeta.setCenterY((juego.obtenerCoordenadaMeta() + 1) * (TAMANIO_MANZANA + TAMANIO_CALLE) + OFFSET_Y);
        visionMeta.setRadius(TAMANIO_MANZANA + TAMANIO_CALLE);

        Shape sombra = Shape.subtract(rectangulo, visionVehiculo);
        sombra = Shape.subtract(sombra, visionMeta);
        overlaySombra.setClip(sombra);
        overlaySombra.setStyle("-fx-background-color: black");

        this.getChildren().add(overlaySombra);
    }

    private void actualizarMapa() {
        
    }

    public void actualizar() {
        actualizarVehiculo();
        this.getChildren().remove(overlaySombra);
        dibujarSombra();
    }
}