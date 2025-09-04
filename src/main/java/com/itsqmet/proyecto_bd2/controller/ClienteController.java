package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.Cliente;
import com.itsqmet.proyecto_bd2.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteServices clienteService;

    // Leer todos
    @GetMapping
    public List<Cliente> leer() {
        return clienteService.mostrarClientes();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable String id) {
        return clienteService.buscarPorId(id);
    }

    // Guardar
    @PostMapping("/guardar")
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable String id) {
        clienteService.eliminarCliente(id);
    }

    // Actualizar
    @PutMapping("/actualizar/{id}")
    public Cliente actualizar(@PathVariable String id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteService.buscarPorId(id);
        if (clienteOptional.isPresent()) {
            Cliente clienteExistente = clienteOptional.get();

            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setCedula(cliente.getCedula());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setPassword(cliente.getPassword());
            clienteExistente.setRol(cliente.getRol());

            return clienteService.guardarCliente(clienteExistente);
        }
        return null;
    }
}