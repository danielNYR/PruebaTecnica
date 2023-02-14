package com.prueba.tecnica.neoris.bank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.prueba.tecnica.neoris.bank.entity.Cuenta;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaRepository {

	
	@PersistenceContext
	EntityManager entityMan;
	
	public List<Cuenta> listarCuentas(){
		return entityMan.createQuery("from Cuenta").getResultList();
	}
	
	public Cuenta encontrarCuenta(int id) {
		return entityMan.find(Cuenta.class, id);
	}
	
	public boolean eliminarCuenta(Cuenta cuenta) {
		entityMan.remove(cuenta);
		return true;
	}
	
	public boolean registrarCuenta(Cuenta cuenta) {
		entityMan.persist(cuenta);
		return true;
	}
	
	@Transactional
	public void actualizarSaldoCuenta(Cuenta cuenta) {
		entityMan.persist(cuenta);
	}
}
