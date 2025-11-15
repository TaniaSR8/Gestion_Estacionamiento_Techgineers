package com.example.Estacionamiento.pruebas;

import com.example.Estacionamiento.model.Carro;
import com.example.Estacionamiento.model.LugarEstacionamiento;
import com.example.Estacionamiento.servicio.EstacionamientoServicio;

public class Main {
    public static void main(String[] args) {

        //Crea el servicio
        EstacionamientoServicio servicio = new EstacionamientoServicio();

        // Crea y registrar carros
        Carro carro1 = new Carro();
        carro1.setId(1);
        carro1.setPlaca("ABC-123");
        carro1.setMarca("Nissan");
        carro1.setColor("Rojo");
        carro1.setHoraEntrada("10:00");

        Carro carro2 = new Carro();
        carro2.setId(2);
        carro2.setPlaca("XYZ-999");
        carro2.setMarca("Toyota");
        carro2.setColor("Azul");
        carro2.setHoraEntrada("10:15");

        servicio.registrarCarro(carro1);
        servicio.registrarCarro(carro2);

        // Crear y agregar lugares
        LugarEstacionamiento lugar1 = new LugarEstacionamiento();
        lugar1.setId(1);
        lugar1.setNumero("A-1");
        lugar1.setOcupado(false);

        LugarEstacionamiento lugar2 = new LugarEstacionamiento();
        lugar2.setId(2);
        lugar2.setNumero("A-2");
        lugar2.setOcupado(false);

        servicio.agregarLugar(lugar1);
        servicio.agregarLugar(lugar2);

        //Ocupar lugar con carro1
        servicio.ocuparLugar(1, 1);

        //Intentar ocupar lugar ya ocupado con carro2 (debería ir a cola)
        servicio.ocuparLugar(1, 2);

        //Liberar lugar
        servicio.liberarLugar(1);

        //Atender cola (carro2 debería ocupar el lugar liberado)
        servicio.atenderCola();

        // Mostrar todo
        System.out.println("\n--- Carros ---");
        servicio.mostrarCarros();

        System.out.println("\n--- Lugares ---");
        servicio.mostrarLugares();

        System.out.println("\n--- Cola de espera ---");
        servicio.mostrarColaEspera();

        System.out.println("\n--- Historial ---");
        servicio.mostrarHistorial();
    }
}
