package com.prueba.tecnica.neoris.bank.controller;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.tecnica.neoris.bank.entity.Cliente;
import com.prueba.tecnica.neoris.bank.service.imp.ClienteServiceImpl;

@Controller
public class ClientesController {

	@Autowired
	ClienteServiceImpl clienteServ;
	
	@GetMapping(value = "/clientes/listarClientes", produces = "application/json")
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> listaClientes = new ArrayList<>(clienteServ.listarClientes());
		if(listaClientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(listaClientes, HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/clientes/registrarCliente")
	public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente){
		if(cliente==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(cliente, HttpStatus.CREATED);
		}
	}
	
	
	@DeleteMapping(value = "/clientes/eliminar/{id}", produces = "application/json")
	public Map<String, Boolean>deleteCliente(@PathVariable int id){
		boolean del = clienteServ.eliminarClienteById(id); //Validar del lado del servicio
		Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", del);
	    return response;
	}
	
	@GetMapping(value = "/clientes/consultar/{id}", produces = "application/json")
	public ResponseEntity<Cliente> consultarCliente(@PathVariable int id){
		return new ResponseEntity<>(clienteServ.obtenerClienteById(id), HttpStatus.OK);
	}
}
