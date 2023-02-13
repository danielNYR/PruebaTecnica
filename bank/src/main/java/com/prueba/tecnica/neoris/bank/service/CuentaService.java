package com.prueba.tecnica.neoris.bank.service;

import java.util.List;

import com.prueba.tecnica.neoris.bank.entity.Cuenta;

public interface CuentaService {
	public List<Cuenta>listarCuenta();
	public Cuenta encontrarCuentaById(int id);
	public boolean eliminarCuenta(Cuenta cuenta);
	public boolean registrarCuenta(Cuenta cuenta);
}
