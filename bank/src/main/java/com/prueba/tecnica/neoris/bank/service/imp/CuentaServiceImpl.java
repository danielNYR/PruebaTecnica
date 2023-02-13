package com.prueba.tecnica.neoris.bank.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.neoris.bank.entity.Cuenta;
import com.prueba.tecnica.neoris.bank.repository.CuentaRepository;
import com.prueba.tecnica.neoris.bank.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	CuentaRepository cuentaRepositoryImp;
	
	@Override
	public List<Cuenta> listarCuenta() {
		// TODO Auto-generated method stub
		return cuentaRepositoryImp.listarCuentas();
	}

	@Override
	public Cuenta encontrarCuentaById(int id) {
		// TODO Auto-generated method stub
		return cuentaRepositoryImp.encontrarCuenta(id);
	}

	@Override
	public boolean eliminarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return cuentaRepositoryImp.eliminarCuenta(cuenta);
	}

	@Override
	public boolean registrarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return cuentaRepositoryImp.registrarCuenta(cuenta);
	}

}
