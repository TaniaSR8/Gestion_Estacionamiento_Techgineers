package com.example.Estacionamiento.estructuras;


public class ColaLista<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamaño;

    public ColaLista() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

    public T desencolar() {
        if (estaVacia()) return null;
        T dato = frente.dato;
        frente = frente.siguiente;
        tamaño--;
        if (frente == null) fin = null;
        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void recorrer() {
        Nodo<T> actual = frente;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
