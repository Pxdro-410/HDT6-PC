import java.util.*;

// Se utiliza factory para evitar varias instancias de lo mismo, además permite que el usuario decida que utilizar
public class FactoryMapSelec {
    // Se crea el MAP segun la eleccion del usuario
    public static Map<String, Pokemon> crearMapa(int opcionMapa) {
        switch (opcionMapa) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Opción no válida, pruebe de nuevo");
        }
    }
}