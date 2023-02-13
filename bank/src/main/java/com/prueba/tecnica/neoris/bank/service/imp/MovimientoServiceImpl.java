package com.prueba.tecnica.neoris.bank.service.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.neoris.bank.entity.Cliente;
import com.prueba.tecnica.neoris.bank.entity.Cuenta;
import com.prueba.tecnica.neoris.bank.entity.Movimiento;
import com.prueba.tecnica.neoris.bank.repository.CuentaRepository;
import com.prueba.tecnica.neoris.bank.repository.MovimientoRepository;
import com.prueba.tecnica.neoris.bank.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{

	@Autowired
	MovimientoRepository movimientoRepositoryImp;
	
	@Autowired
	CuentaRepository cuentaRepository;
	
	@Override
	public boolean registrarMovimiento(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return movimientoRepositoryImp.registrarMovimiento(movimiento);
	}

	@Override
	public boolean eliminarMovimiento(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return movimientoRepositoryImp.eliminarMovimiento(movimiento);
	}

	@Override
	public List<Movimiento> listarMovimientos() {
		// TODO Auto-generated method stub
		return movimientoRepositoryImp.listarMovimientos();
	}

	@Override
	public Movimiento encontrarMovimientoById(int idMovimiento) {
		// TODO Auto-generated method stub
		return movimientoRepositoryImp.encontrarMovimiento(idMovimiento);
	}

	@Override
	public List<Movimiento> listarMovimientosCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return movimientoRepositoryImp.listarMovimientos();
	}

	@Override
	public Movimiento realizarDeposito(double valorEntrante, int numeroCuenta) {
		return realizarMovimiento("deposito", valorEntrante, numeroCuenta);
	}

	@Override
	public Movimiento realizarRetiro(double valorEntrante, int numeroCuenta) {
		return realizarMovimiento("retiro", valorEntrante, numeroCuenta);
	}

	@Override
	public Movimiento realizarMovimiento(String movimiento, double valorEntrante, int numeroCuenta) {
		String valorMovimiento = String.valueOf(valorEntrante);
		Cuenta accountMovement = movimientoRepositoryImp.encontrarCuenta(numeroCuenta);
		double flagQuant = Double.parseDouble(accountMovement.getSaldoInicialCuenta());
		String saldo = "";
		switch(movimiento) {
		case "deposito": 
			saldo = ""+(flagQuant+valorEntrante);
			break;
		case "retiro":
			if(flagQuant<valorEntrante) {
				saldo = flagQuant+"";
			}else {
				saldo = ""+(flagQuant-valorEntrante);
			}
			break;
		case "cobro":
			if(flagQuant<valorEntrante) {
				saldo = flagQuant+"";
			}else {
				saldo = ""+(flagQuant-valorEntrante);
			}
			
			break;
		default:
			saldo = flagQuant+"";
			break;
		}
		String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		accountMovement.setSaldoInicialCuenta(saldo); 
		cuentaRepository.actualizarSaldoCuenta(accountMovement);
		Movimiento movement = new Movimiento(fecha, movimiento, valorMovimiento, saldo, accountMovement );
		registrarMovimiento(movement);//Registrar el valor
		return movement;
	}

}
