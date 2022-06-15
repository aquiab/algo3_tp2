package edu.fiuba.algo3.modelo;

public class Usuario {
    public Vehiculo vehiculo;
    private Mapa mapa;

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
}