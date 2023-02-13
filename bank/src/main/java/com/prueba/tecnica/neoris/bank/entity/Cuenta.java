package com.prueba.tecnica.neoris.bank.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cuenta")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numeroCuenta")
	private int numeroCuenta;
	
	@Column(name = "saldoInicialCuenta")
	private String saldoInicialCuenta;
	
	@Column(name = "estadoCuenta")
	private String estadoCuenta;
	
	@ManyToOne(targetEntity = Cliente.class)
	@JoinColumn (name="idCliente")
	private Cliente cuentaCliente;
	
	@OneToMany(mappedBy = "movimientoCuenta")
	private List<Movimiento> listaMovimientos;

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getSaldoInicialCuenta() {
		return saldoInicialCuenta;
	}

	public void setSaldoInicialCuenta(String saldoInicialCuenta) {
		this.saldoInicialCuenta = saldoInicialCuenta;
	}

	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public Cliente getCuentaCliente() {
		return cuentaCliente;
	}

	public void setCuentaCliente(Cliente cuentaCliente) {
		this.cuentaCliente = cuentaCliente;
	}
	
	
	
	

}
