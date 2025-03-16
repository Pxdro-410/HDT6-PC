import java.util.*;

// Clase que maneja la colección de Pokémon del usuario
public class Pokedex {
    private Map<String, Pokemon> pokedex;

    public Pokedex(int opcionMapa) {
        this.pokedex = FactoryMapSelec.crearMapa(opcionMapa);
    }

    // Agrega un pokemon a la pokedex del usario
    public boolean agregarPokemon(Pokemon pokemon) {
        if (pokedex.containsKey(pokemon.getNombre())) {
            return false; // si ya estaba agregado devuelve false
        }
        pokedex.put(pokemon.getNombre(), pokemon);
        return true; // sino lo agrega correctamente
    }

    // metodo para obtener un pokeon por su nombre
    public Pokemon obtenerPokemon(String nombre) {
        return pokedex.get(nombre);
    }

    // metodo para mostrar los pokemon ordenados por su tipo principal o tipo1 
    public List<Pokemon> getPorTipo() {
        List<Pokemon> lista = new ArrayList<>(pokedex.values());
        lista.sort(Comparator.comparing(Pokemon::gettipoPrincipal));
        return lista;
    }
}
