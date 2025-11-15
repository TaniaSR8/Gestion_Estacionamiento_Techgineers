package com.example.Estacionamiento.estructuras;

public class ListaSimple<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    public ListaSimple() {
        cabeza = null;
        tamaño = 0;
    }

    //Agregar al final de la lista
    public void agregarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    //Buscar un elemento por igualdad
    public boolean buscar(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    //Eliminar un elemento
    public void eliminar(T dato) {
        if (cabeza == null) return;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(dato)) {
                actual.siguiente = actual.siguiente.siguiente;
                tamaño--;
                return;
            }
            actual = actual.siguiente;
        }
    }

    //Recorrer la lista y mostrar elementos
    public void recorrer() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public int getTamaño() {
        return tamaño;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }
}
