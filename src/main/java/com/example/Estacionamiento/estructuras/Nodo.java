package com.example.Estacionamiento.estructuras;

public class Nodo<T> {
    public T dato; // dato que guarda el nodo
    public Nodo<T> siguiente; // referencia al siguiente nodo

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;

    }
}
