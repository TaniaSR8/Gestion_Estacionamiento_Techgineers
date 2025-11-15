package com.example.Estacionamiento;

import com.example.Estacionamiento.model.Carro;
import com.example.Estacionamiento.model.LugarEstacionamiento;
import com.example.Estacionamiento.servicio.EstacionamientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estacionamiento")
public class EstacionamientoController {

    @Autowired
    private EstacionamientoServicio servicio;

    // Registrar un carro
    @PostMapping("/carros")
    public String registrarCarro(@RequestBody Carro carro) {
        servicio.registrarCarro(carro);
        return "Carro registrado: " + carro.getPlaca();
    }

    // Agregar un lugar
    @PostMapping("/lugares")
    public String agregarLugar(@RequestBody LugarEstacionamiento lugar) {
        servicio.agregarLugar(lugar);
        return "Lugar agregado: " + lugar.getNumero();
    }

    // Ocupar un lugar
    @PostMapping("/ocupar")
    public String ocupar(@RequestParam int idLugar, @RequestParam int idCarro) {
        servicio.ocuparLugar(idLugar, idCarro);
        return "Operación ocupar ejecutada";
    }

    // Liberar un lugar
    @PostMapping("/liberar")
    public String liberar(@RequestParam int idLugar) {
        servicio.liberarLugar(idLugar);
        return "Operación liberar ejecutada";
    }

    // Atender la cola
    @PostMapping("/atender-cola")
    public String atenderCola() {
        servicio.atenderCola();
        return "Se intentó atender la cola. Revisa historial en consola.";
    }

    // Mostrar historial
    @GetMapping("/historial")
    public String historial() {
        servicio.mostrarHistorial();
        return "Historial impreso en consola.";
    }

    // Listar carros
    @GetMapping("/carros")
    public String listarCarros() {
        servicio.mostrarCarros();
        return "Carros listados en consola.";
    }

    // Listar lugares
    @GetMapping("/lugares")
    public String listarLugares() {
        servicio.mostrarLugares();
        return "Lugares listados en consola.";
    }

    // Listar cola de espera
    @GetMapping("/cola")
    public String listarCola() {
        servicio.mostrarColaEspera();
        return "Cola de espera listada en consola.";
    }
}
