package Logica;

/**
 * Clase de marcador para el paquete proyectoM.
 * Aquí puedes agregar las funciones/estructura que correspondan al trabajo del grupo.
 * Autor: Brandon Granados (bngranados)
 */
public class proyectoM {

    private String autor = "Brandon Granados";

    public proyectoM() {}

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "proyectoM{autor='" + autor + "'}";
    }

    // Método de prueba
    public static void main(String[] args) {
        proyectoM p = new proyectoM();
        System.out.println("Clase proyectoM cargada. " + p);
    }
}
