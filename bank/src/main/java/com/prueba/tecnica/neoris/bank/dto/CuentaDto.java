package com.prueba.tecnica.neoris.bank.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.prueba.tecnica.neoris.bank.entity.Cliente;
import com.prueba.tecnica.neoris.bank.entity.Cuenta;
import com.prueba.tecnica.neoris.bank.entity.Persona;

//Respuestas de JSON
public class CuentaDto {
	
	private Cliente cliente;
	private List<Cuenta> cuentasCliente;
	
	/*
	  idCliente;
	  contrasenaCliente: ""
	  estadoCliente : ""
	  personaCliente {
	  
	     nombre: ""
	     apellido: ""
	  
	  }
	  cuentasCliente {
	   "cuenta" : ""
	   "estatus": ""
	  }
	  
	  */
}
