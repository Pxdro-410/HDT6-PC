import java.io.*;
import java.util.*;

public class LectorPokemonCSV {
    private String rutaCSV;

    public LectorPokemonCSV(String rutaCSV) {
        this.rutaCSV = rutaCSV;
    }

    // método guiado de CHATGPT para leer un CSV, ya que ningun otro método que probé me funcionaba
    public List<Pokemon> BaseDeDatosPokemonCSV() {
        List<Pokemon> listadoDePokemons = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCSV))) {
            String linea = lector.readLine(); 
            while ((linea = lector.readLine()) != null) {
                String[] valores = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); 
                
                for (int i = 0; i < valores.length; i++) {
                    valores[i] = valores[i].trim().replaceAll("^\"|\"$", ""); 
                }

                // valores a tomar segun su index 
                String nombre = valores[0];
                int numeroPokedex = Integer.parseInt(valores[1]);
                String tipoPrincipal = valores[2];
                String tipoSecundario = valores[3].isEmpty() ? "Ninguno" : valores[3];
                String clasificacion = valores[4];
                double altura = Double.parseDouble(valores[5]);
                double peso = Double.parseDouble(valores[6]);

                // habilidades separadas correctamente por comas
                List<String> habilidades = Arrays.asList(valores[7].split(", "));

                int generacion = Integer.parseInt(valores[8]);
                boolean legendario = valores[9].equalsIgnoreCase("true");

                //constructor
                Pokemon pokemon = new Pokemon(nombre, numeroPokedex, tipoPrincipal, tipoSecundario, clasificacion, altura, peso, habilidades, generacion, legendario);
                listadoDePokemons.add(pokemon);
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + e.getMessage());
        }
        return listadoDePokemons;
    }
}
