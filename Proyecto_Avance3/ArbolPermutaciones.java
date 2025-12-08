package Proyecto_Avance3;

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
