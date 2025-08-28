package com.itsqmet.proyecto_bd2.services;

import com.itsqmet.proyecto_bd2.entity.Cliente;
import com.itsqmet.proyecto_bd2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos
    public List<Cliente> mostrarClientes() {
        return clienteRepository.findAll();
    }

    // Buscar por ID
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Guardar
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
