package com.prueba.tecnica.neoris.bank.entity;

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
@Table(name = "movimiento")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMovimiento")
	private int idMovimiento;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "valor")
	private String valor;
	
	@Column(name = "saldo")
	private String saldo;
	
	@ManyToOne(targetEntity = Cuenta.class)
	@JoinColumn (name="numeroCuenta")
	private Cuenta movimientoCuenta;

	
	
	public Movimiento() {
	}

	
	public Movimiento(int idMovimiento, String fecha, String tipo, String valor, String saldo,
			Cuenta movimientoCuenta) {
		//super();
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.tipo = tipo;
		this.valor = valor;
		this.saldo = saldo;
		this.movimientoCuenta = movimientoCuenta;
	}
	
	
	public Movimiento(String fecha, String tipo, String valor, String saldo, Cuenta movimientoCuenta) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
		this.valor = valor;
		this.saldo = saldo;
		this.movimientoCuenta = movimientoCuenta;
	}


	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public Cuenta getMovimientoCuenta() {
		return movimientoCuenta;
	}

	public void setMovimientoCuenta(Cuenta movimientoCuenta) {
		this.movimientoCuenta = movimientoCuenta;
	}
	
	
	
}
