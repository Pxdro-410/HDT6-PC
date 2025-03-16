//------------------------------------------
//Pedro Julio Caso
// 241286
// HDT6
// Algoritmos y estructura de datos
//------------------------------------------

import java.util.*;

public class Pokemon {
    private final String nombre;
    private final int numeroPokedex;
    private final String tipoPrincipal;
    private final String tipoSecundario;
    private final String clasificacion;
    private final double altura;
    private final double peso;
    private final List<String> habilidades; // se hace una lista debido a que en el excel esta separado por comas
    private final int generacion;
    private final boolean legendario;

    // Constructor de la clase 
    public Pokemon(String nombre, int numeroPokedex, String tipoPrincipal, String tipoSecundario, String clasificacion, double altura, double peso, List<String> habilidades, int generacion, boolean legendario) {
        this.nombre = nombre;
        this.numeroPokedex = numeroPokedex;
        this.tipoPrincipal = tipoPrincipal;
        this.tipoSecundario = tipoSecundario;
        this.clasificacion = clasificacion;
        this.altura = altura;
        this.peso = peso;
        this.habilidades = habilidades;
        this.generacion = generacion;
        this.legendario = legendario;
    }

    // Getters 
    public String getNombre() {
        return nombre;
    }

    public int getNumeroPokedex() {
        return numeroPokedex;
    }

    public String gettipoPrincipal() {
        return tipoPrincipal;
    }

    public String gettipoSecundario() {
        return tipoSecundario;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public int getGeneracion() {
        return generacion;
    }

    public boolean Legendario() {
        return legendario;
    }
}