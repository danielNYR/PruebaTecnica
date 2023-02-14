package com.prueba.tecnica.neoris.bank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.prueba.tecnica.neoris.bank.entity.Cuenta;
import com.prueba.tecnica.neoris.bank.entity.Movimiento;

import org.springframework.stereotype.Repository;

@Repository
public class MovimientoRepository {

	@PersistenceContext
	EntityManager entityMan;
	
	@Transactional
	public boolean registrarMovimiento(Movimiento movimiento) {
		entityMan.merge(movimiento);
		return true;
	}
	
	@Transactional
	public List<Movimiento> listarMovimientos(){
		return entityMan.createQuery("from Movimiento").getResultList();
	}
	
	public Movimiento encontrarMovimiento(int id) {
		return entityMan.find(Movimiento.class, id);
	}
	
	@Transactional
	public boolean eliminarMovimiento(Movimiento movimiento) {
		entityMan.remove(movimiento);
		return true;
	}
	
	
	public Cuenta encontrarCuenta(int id) {
		return entityMan.find(Cuenta.class, id);
	}
}
