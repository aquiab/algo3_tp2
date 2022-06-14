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
            fila -= 1;
        } else if (direccion.equals("down")) {
            fila += 1;
        } else if (direccion.equals("left")) {
            columna -= 1;
        } else if (direccion.equals("right")) {
            columna += 1;
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