package Proyecto_Avance3;

/**
 * Un Árbol Binario de Búsqueda para organizar y consultar permutaciones de tripletas de cartas.
 * Los nodos se ordenan según el valor de la tripleta (cartas a tomar).
 */
public class ArbolPermutaciones {
    private NodoPermutacion raiz;

    public ArbolPermutaciones() {
        this.raiz = null;
    }


    public void insertar(NodoPermutacion nodo) {
        if (raiz == null) {
            raiz = nodo;
        } else {
            insertarRecursivo(raiz, nodo);
        }
    }

    private void insertarRecursivo(NodoPermutacion actual, NodoPermutacion nuevoNodo) {
     
        if (nuevoNodo.valor < actual.valor) {
            if (actual.izquierda == null) {
                actual.izquierda = nuevoNodo;
            } else {
                insertarRecursivo(actual.izquierda, nuevoNodo);
            }
        } else { 
            if (actual.derecha == null) {
                actual.derecha = nuevoNodo;
            } else {
                insertarRecursivo(actual.derecha, nuevoNodo);
            }
        }
    }

    /**
     * Encuentra el nodo con el valor máximo en el árbol.
     * En un ABB, este es el nodo que está más a la derecha.
     * @return El nodo con el valor máximo, o null si el árbol está vacío.
     */
    public NodoPermutacion encontrarMaximo() {
        if (raiz == null) {
            return null;
        }
        NodoPermutacion actual = raiz;
        while (actual.derecha != null) {
            actual = actual.derecha;
        }
        return actual;
    }
}
