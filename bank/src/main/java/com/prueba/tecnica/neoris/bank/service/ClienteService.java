package com.prueba.tecnica.neoris.bank.service;

import java.util.List;

import com.prueba.tecnica.neoris.bank.entity.Cliente;

public interface ClienteService {

	public List<Cliente> listarClientes();
	public Cliente obtenerClienteById(int idCliente);
	public boolean eliminarClienteById(int idCliente);
	public boolean registrarCliente(Cliente cliente);
	public boolean eliminarCliente(Cliente cliente);
	
}
