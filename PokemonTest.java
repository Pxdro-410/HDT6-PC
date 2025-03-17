import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.io.File;

public class PokemonTest {
    
    @Test
    void testGetters() {
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", "", Arrays.asList("Impactrueno", "Ataque Rápido"));

        assertEquals("Pikachu", pikachu.getNombre());
        assertEquals("Eléctrico", pikachu.gettipoPrincipal());
        assertTrue(pikachu.getHabilidades().contains("Impactrueno"));
    }
}
