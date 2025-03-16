import java.util.*;

// Esta primera parte del main le pide al usuario con que MAP quiere crear su pokedex
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que tipo de MAP deseas utilizar en tu pokedex?");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        

        int opcionMapa;
        do {
            System.out.print("Elija una de las opciones anteriores: ");
            opcionMapa = scanner.nextInt();
        } 
        
        while (opcionMapa < 1 || opcionMapa > 3);
        // se crea la pokedes con el MAP elegido
        Pokedex pokedex = new Pokedex(opcionMapa);
        // se crea la base general de todos los pokemon segun el la ruta del CSV
        BaseGeneralPokemon pokedexGeneral = new BaseGeneralPokemon("C:\\Users\\pedro\\OneDrive\\Escritorio\\PokemonDataCSV.csv");
        
        // notese que se utiliza una variable booleana y no un while true
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n JUEGO POKEMON");
            System.out.println("Opciones que puedes realizar con tu pokedex:");
            System.out.println("1. Agregar un pokemon a tu Pokedex");
            System.out.println("2. Mostrar datos de un Pokémon de tu pokedex");
            System.out.println("3. Mostrar colección ordenada por tipo1 de tu pokedex");
            System.out.println("\n Opciones con la base de datos");
            System.out.println("4. Mostrar todos los pokemon ordenados por el tipo 1");
            System.out.println("5. Buscar cualquier pokemon segun su habibildad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una de las opciones anteriores: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del pokemon que quiera añadir: ");
                    String nombrePokemon = scanner.nextLine();

                    // Busca si el nombre se encuentra en la base de datos sino le dice al usuario que es incorrectp
                    Pokemon p = pokedexGeneral.obtenerPokemon(nombrePokemon); 
                    if (p == null) {
                        System.out.println("El pokemon no se encontro en la base de datos");
                    } else if (!pokedex.agregarPokemon(p)) {
                        System.out.println("Ya tienes este pokemon!");
                    } else {
                        System.out.println("Nuevo registro Pokemon!");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del pokemon del cual desea ver la informacion: ");
                    String nombre = scanner.nextLine();
                    // verifica que este en su pokedex para mostrarle los datos, sino tira un error 
                    Pokemon encontrado = pokedex.obtenerPokemon(nombre);
                    if (encontrado == null) {
                        System.out.println("Ese pokemon no esta agregado en tu pokedex :(");
                    } else {
                        System.out.println("Informacion general del pokemon: ");
                        System.out.println("Nombre: " + encontrado.getNombre());
                        System.out.println("Numero de pokedex: " + encontrado.getNumeroPokedex());
                        System.out.println("Tipo principal: " + encontrado.gettipoPrincipal());
                        System.out.println("Tipo secundario: " + encontrado.gettipoSecundario());
                        System.out.println("Altura: " + encontrado.getAltura());
                        System.out.println("Peso: " + encontrado.getPeso());
                        System.out.println("Habilidades especiales: " + encontrado.getHabilidades());
                        System.out.println("Generacion: " + encontrado.getGeneracion());
                        System.out.println("Es legendario: " + (encontrado.Legendario() ? "Sí" : "No"));
                    }
                    break;
                case 3:
                    System.out.println("Aqui estan tus pokemon ordenados por su tipo principal:");
                    for (Pokemon poke : pokedex.getPorTipo()) {
                        System.out.println(poke.getNombre() + " - " + poke.gettipoPrincipal());
                    }
                    break;

                    // mismo que el punto 3 pero con la base general y no con la pokedex
                case 4:
                    System.out.println("Todos los pokemon ordenados por su tipo principal: ");
                    for (Pokemon poke : pokedexGeneral.OrdenPorTipo()) {
                        System.out.println(poke.getNombre() + " - " + poke.gettipoPrincipal());
                    }
                    break;

                    // busca todos los pokemon con la habilidad que ingrese el usuario
                case 5:
                    System.out.print("Ingrese la habilidad que le interese: ");
                    String habilidad = scanner.nextLine();
                    List<Pokemon> PokemonPorHabilidad = pokedexGeneral.buscarPorHabilidad(habilidad);
                    if (PokemonPorHabilidad.isEmpty()) {
                        System.out.println("Esa habilidad no existe.");
                    } else {
                        System.out.println("Pokemons con la habilidad ingresada :");
                        for (Pokemon poke : PokemonPorHabilidad) {
                            System.out.println(poke.getNombre());
                        }
                    }
                    break;

                    // finaliza el main volviendo falsa la variable booleana que controla el Main
                case 6:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;

                    // Se utiliza un default para evitar un crasheo del Main y que el usuario ingrese una opcion valida
                default:
                    System.out.println("Opcion incorrecta, intente otra vez");
            }
        }
        scanner.close();
    }
}