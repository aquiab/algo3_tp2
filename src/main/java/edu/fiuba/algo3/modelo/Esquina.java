package edu.fiuba.algo3.modelo;
import java.util.HashMap;

public class Esquina {
    HashMap<String, Tuple> map = new HashMap<>();

    Esquina(Tuple arr, Tuple ab, Tuple izq, Tuple der) { //lleno el diccionario de la esquina
        map.put("up", arr);
        map.put("down", ab);
        map.put("right", der);
        map.put("left", izq);
    }
    Tuple devolver_esquina_calle(String direccion) {
        return map.get(direccion);
    }
    public void modificarDiccionario(Tuple tupla, String str) {
        map.put(str, tupla);
    }
}
