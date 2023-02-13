package com.prueba.tecnica.neoris.bank.controller;

import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prueba.tecnica.neoris.bank.entity.Movimiento;
import com.prueba.tecnica.neoris.bank.service.imp.MovimientoServiceImpl;

@Controller
public class OperationsController {

	private static org.jboss.logging.Logger logger = LoggerFactory.logger(OperationsController.class);
	
	@Autowired
	MovimientoServiceImpl movimientoServ;
	
	@PostMapping(value = "/movimiento/deposito", consumes = "application/json")
	public ResponseEntity<Movimiento> registrarDeposito(@RequestParam("monto") String monto, @RequestParam("numeroCuenta") String numeroCuenta){
		logger.info("Monto: "+monto + ": "+numeroCuenta);
		return new ResponseEntity<>(movimientoServ.realizarDeposito(Double.parseDouble(monto), Integer.parseInt(numeroCuenta)), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/movimiento/retiro")
	public ResponseEntity<Movimiento>registrarRetiro(@RequestAttribute double monto, @RequestAttribute int numeroCuenta){
		return new ResponseEntity<>(movimientoServ.realizarRetiro(monto, numeroCuenta), HttpStatus.CREATED);
	}
	
	//Operaciones: 
	/*
	 * 1. Deposito
	 * 2. Retiro
	 * 4. Cobro
	 * 
	 * */
}
