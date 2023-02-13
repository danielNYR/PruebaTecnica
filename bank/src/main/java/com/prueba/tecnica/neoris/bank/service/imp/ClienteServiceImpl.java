package com.prueba.tecnica.neoris.bank.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.neoris.bank.entity.Cliente;
import com.prueba.tecnica.neoris.bank.entity.Cuenta;
import com.prueba.tecnica.neoris.bank.entity.Persona;
import com.prueba.tecnica.neoris.bank.repository.ClienteRepository;
import com.prueba.tecnica.neoris.bank.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteImp;
	
	@Override
	public List<Cliente> listarClientes() {
	//TODO Auto-generated method stub
		if(clienteImp.listarCliente().isEmpty()) {
			List<Cliente> c = new ArrayList<>();
			c.add(new Cliente());
		    return c;
		}else {
			return clienteImp.listarCliente();
		}
	}

	@Override
	public Cliente obtenerClienteById(int idCliente) {
		// TODO Auto-generated method stub
		Cliente clienteObtenido = clienteImp.findClienteById(idCliente);
		if(clienteObtenido.getEstadoCliente().isEmpty()) {
			return new Cliente();
		}else {
			return clienteObtenido;
		}
	}

	@Override
	public boolean eliminarClienteById(int idCliente) {
		// TODO Auto-generated method stub
		
		return clienteImp.eliminarCliente(idCliente);
	}

	@Override
	public boolean registrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteImp.registrarCliente(cliente);
	}

	@Override
	public boolean eliminarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteImp.eliminarCliente(cliente);
	}

}
