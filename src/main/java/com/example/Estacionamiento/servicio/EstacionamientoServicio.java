package com.example.Estacionamiento.servicio;

import com.example.Estacionamiento.estructuras.ColaLista;
import com.example.Estacionamiento.estructuras.ListaSimple;
import com.example.Estacionamiento.estructuras.Nodo;
import com.example.Estacionamiento.estructuras.Pila;
import com.example.Estacionamiento.model.Carro;
import com.example.Estacionamiento.model.LugarEstacionamiento;
import org.springframework.stereotype.Service;

@Service
public class EstacionamientoServicio {

    //Lista de carros registrados en el sistema
    private ListaSimple<Carro> carros = new ListaSimple<>();
    //Lista de lugares disponibles en el estacionamiento
    private ListaSimple<LugarEstacionamiento> lugares = new ListaSimple<>();
    //Cola de carros en espera
    private ColaLista<Carro> colaEspera = new ColaLista<>();
    //Pila para historial de operaciones
    private Pila<String> historial = new Pila<>();

    // Validar si el carro ya existe
    public void registrarCarro(Carro carro) {
        Nodo<Carro> actual = carros.getCabeza();
        while (actual != null) {
            if (actual.dato.getId() == carro.getId()) {
                historial.Insertar("Carro duplicado: " + carro.getPlaca());
                return;
            }
            actual = actual.siguiente;
        }
        carros.agregarFinal(carro);
        historial.Insertar("Carro registrado: " + carro.getPlaca());
    }


    public void agregarLugar(LugarEstacionamiento lugar) {
        Nodo<LugarEstacionamiento> actual = lugares.getCabeza();
        while (actual != null) {
            if (actual.dato.getId() == lugar.getId()) {
                historial.Insertar("Lugar duplicado: " + lugar.getNumero());
                return;
            }
            actual = actual.siguiente;
        }
        lugares.agregarFinal(lugar);
        historial.Insertar("Lugar agregado: " + lugar.getNumero());
    }


    //Ocupar un lugar
    public void ocuparLugar(int idLugar, int idCarro){
        Nodo<LugarEstacionamiento> actualLugar = lugares.getCabeza();
        while(actualLugar != null){
            LugarEstacionamiento lugar = actualLugar.dato;
            if (lugar.getId() == idLugar && !lugar.esOcupado()) {
                lugar.ocupar(idCarro);
                historial.Insertar("Lugar ocupado: " + lugar.getNumero() + " por carro " + idCarro);
                return;
            }
            actualLugar = actualLugar.siguiente;
        }
        //Si no se pudo ocupar , el carro va a la cola de espera
        Nodo<Carro> actualCarro = carros.getCabeza();
        while(actualCarro != null){
            if (actualCarro.dato.getId() == idCarro) {
                colaEspera.encolar(actualCarro.dato);
                historial.Insertar("Carro en espera: " + actualCarro.dato.getPlaca());
                return;
            }
            actualCarro = actualCarro.siguiente;
        }

    }

    //Liberar un lugar
    public void liberarLugar(int idLugar) {
        Nodo<LugarEstacionamiento> actualLugar = lugares.getCabeza();
        while (actualLugar != null) {
            LugarEstacionamiento lugar = actualLugar.dato;
            if (lugar.getId() == idLugar && lugar.esOcupado()) {
                lugar.liberar();
                historial.Insertar("Lugar liberado: " + lugar.getNumero());
                return;
            }
            actualLugar = actualLugar.siguiente;
        }
    }

    //Mostrar historial
    public void mostrarHistorial() {
        historial.mostrarPila();
    }

    //Atender la cola de espera
    public void atenderCola() {
        Carro siguiente = colaEspera.desencolar();
        if (siguiente != null) {
            historial.Insertar("Carro atendido de la cola: " + siguiente.getPlaca());
            System.out.println("Carro atendido: " + siguiente.getPlaca());
        } else {
            System.out.println("No hay carros en espera.");
        }
    }

    //Mostrar todos los carros
    public void mostrarCarros() {
        carros.recorrer();
    }

    //Mostrar todos los lugares
    public void mostrarLugares() {
        lugares.recorrer();
    }

    //Mostrar cola de espera
    public void mostrarColaEspera() {
        colaEspera.recorrer();
    }




}
