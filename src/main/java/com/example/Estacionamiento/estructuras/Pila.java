package com.example.Estacionamiento.estructuras;

public class Pila<T> {
    private Nodo<T> cima;
    private int tamaño;

    public Pila() {
        cima = null;
        tamaño = 0;
    }

    public void Insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamaño++;
    }

    public void Quitar() {
        if (PilaVacia()) return;
        cima = cima.siguiente;
        tamaño--;
    }

    public T CimaPila() {
        if (PilaVacia()) return null;
        return cima.dato;
    }

    public boolean PilaVacia() {
        return cima == null;
    }

    public int TamanioPila() {
        return tamaño;
    }

    public void mostrarPila() {
        Nodo<T> actual = cima;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
