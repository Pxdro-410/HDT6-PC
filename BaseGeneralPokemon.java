import java.util.*;

// Esta clase controla los puntos 4 y 5 lo que se maneja con toda la info del CSV y no con la pokedex del usuario
public class BaseGeneralPokemon {
    private Map<String, Pokemon> pokeMap;

    // Se utiliza LinkedHashMap (explicacion en el readme)
    public BaseGeneralPokemon(String rutaCSV) {
        this.pokeMap = new LinkedHashMap<>();
        // lee el archivo CSV
        LectorPokemonCSV lector = new LectorPokemonCSV(rutaCSV);
        for (Pokemon p : lector.BaseDeDatosPokemonCSV()) {
            pokeMap.put(p.getNombre(), p);
        }
    }

    // Obtiene el orden en base al tipo1 del pokemon
    public List<Pokemon> OrdenPorTipo() {
        List<Pokemon> lista = new ArrayList<>(pokeMap.values());
        lista.sort(Comparator.comparing(Pokemon::gettipoPrincipal));
        return lista;
    }

    // obtiene los nombres de los pokemons
    public Pokemon obtenerPokemon(String nombre) {
        return pokeMap.get(nombre);
    }

    // busca los coincidencia en las habilidades que el usuario le pida en el Main
    public List<Pokemon> buscarPorHabilidad(String habilidad) {
        List<Pokemon> PokemonPorHabilidad = new ArrayList<>();
        String habilidadLower = habilidad.toLowerCase();
        for (Pokemon p : pokeMap.values()) {
            for (String hab : p.getHabilidades()) {
                if (hab.toLowerCase().contains(habilidadLower)) {
                    PokemonPorHabilidad.add(p);
                    break;
                }
            }
        }
        return PokemonPorHabilidad;
    }
}
