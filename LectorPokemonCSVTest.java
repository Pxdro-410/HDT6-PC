import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;

public class LectorPokemonCSVTest {

    @Test
    void testArchivoExiste() {
        String ruta = "C:\\Users\\pedro\\OneDrive\\Escritorio\\Algoritmos y estructuras de datos\\HDT6\\HDT6-PC\\PokemonDataCSV.csv";
        File archivo = new File(ruta);

        assertTrue(archivo.exists(), "El archivo CSV no se encontr");
    }
}

