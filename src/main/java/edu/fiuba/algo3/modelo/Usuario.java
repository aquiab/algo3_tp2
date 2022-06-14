package edu.fiuba.algo3.modelo;

public class Usuario {
    public Vehiculo vehiculo;
    private Mapa mapa;
    private int fila;
    private int columna;

    Usuario() {
        mapa = new Mapa();
        fila = 0;
        columna = 0;
    }

    void hacerMovimiento(String direccion) {
        if (direccion.equals("up")) {
            Calle calle = mapa.columnas.get(columna).get(fila);
            vehiculo.pasarObstaculo(calle.obstaculo);
            this.aplicarSorpresa(calle.sorpresa);
        } else if (direccion.equals("down")) {
            Calle calle = mapa.columnas.get(columna).get(fila + 1);
            vehiculo.pasarObstaculo(calle.obstaculo);
            this.aplicarSorpresa(calle.sorpresa);
        } else if (direccion.equals("left")) {
            Calle calle = mapa.filas.get(fila).get(columna);
            vehiculo.pasarObstaculo(calle.obstaculo);
            this.aplicarSorpresa(calle.sorpresa);
        } else if (direccion.equals("right")) {
            Calle calle = mapa.filas.get(fila).get(columna + 1);
            vehiculo.pasarObstaculo(calle.obstaculo);
            this.aplicarSorpresa(calle.sorpresa);
        }
        //Sorpresa sorpresa = vehiculo.hacerMovimiento(direccion);
        //if (sorpresa != null) sorpresa.aplicar(this);
    }

    Vehiculo devolverVehiculo() {
        return vehiculo;
    }

    public void establecerVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double cantidadDeMovimientos() {
        return vehiculo.movimientos;
    }

    private void aplicarSorpresa(String sorpresa){}
}

/*
Usuario.hacerMovimiento("arriba")
se lee de los atributos de la esquina la tupla
se actualiza la nueva esquina
de la calle se toma el obstaculo
se delega al vehiculo aplicar el obstaculo
se delega al usuario aplicar la sorpresa
*/