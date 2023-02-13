package com.prueba.tecnica.neoris.bank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.prueba.tecnica.neoris.bank.entity.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

	@PersistenceContext
	EntityManager entityMan;
	
	@Transactional
	public List<Cliente> listarCliente(){
		return entityMan.createQuery("from Cliente").getResultList();
	}
	
	@Transactional 
	public Cliente findClienteById(int id) {
		return entityMan.find(Cliente.class, id);
	}
	
	@Transactional
	public boolean eliminarCliente(int idCliente) {
		if(findClienteById(idCliente)!=null) {
		 entityMan.remove(findClienteById(idCliente));
		 	return true;
		}else {
			return false;
		}
	}
	
	@Transactional
	public boolean registrarCliente(Cliente cliente) {
		entityMan.persist(cliente);
		return true;
		
	}
	
	
	public boolean eliminarCliente(Cliente cliente){
		entityMan.remove(cliente);
		return true;
	}
}
