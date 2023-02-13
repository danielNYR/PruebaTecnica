package com.prueba.tecnica.neoris.bank.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private int idCliente;
	
	@Column(name = "contrasenaCliente")
	private String contrasenaCliente;
	
	@Column(name = "estadoCliente")
	private String estadoCliente;
	
	@OneToOne
	@JoinColumn(name = "idPersona")
	private Persona personaCliente;
	//Relaciones
	@OneToMany(mappedBy = "cuentaCliente")
	private List<Cuenta> cuentasCliente;
	
	
	
	public Cliente(int idCliente, String contrasenaCliente, String estadoCliente, Persona personaCliente,
			List<Cuenta> cuentasCliente) {
		super();
		this.idCliente = idCliente;
		this.contrasenaCliente = contrasenaCliente;
		this.estadoCliente = estadoCliente;
		this.personaCliente = personaCliente;
		this.cuentasCliente = cuentasCliente;
	}
	
	

	public Cliente() {
		this.idCliente = 0;
		this.contrasenaCliente = "";
		this.estadoCliente = "";
		this.personaCliente = null;
		this.cuentasCliente = null;
	}



	//Metodos Getter y Setter
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getContrasenaCliente() {
		return contrasenaCliente;
	}

	public void setContrasenaCliente(String contrasenaCliente) {
		this.contrasenaCliente = contrasenaCliente;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
}
