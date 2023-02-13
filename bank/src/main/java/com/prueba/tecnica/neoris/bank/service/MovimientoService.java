package com.prueba.tecnica.neoris.bank.service;

import java.util.List;

import com.prueba.tecnica.neoris.bank.entity.Cliente;
import com.prueba.tecnica.neoris.bank.entity.Movimiento;

public interface MovimientoService {

	public boolean registrarMovimiento(Movimiento movimiento);
	public boolean eliminarMovimiento(Movimiento movimiento);
	public List<Movimiento> listarMovimientos();
	public Movimiento encontrarMovimientoById(int idMovimiento);
	public List<Movimiento> listarMovimientosCliente(Cliente cliente);
	public Movimiento realizarMovimiento(String movimiento, double valorEntrante, int numeroCuenta);
	public Movimiento realizarDeposito(double valorEntrante, int numeroCuenta);
	public Movimiento realizarRetiro(double valorEntrante, int numeroCuenta);
	
}
