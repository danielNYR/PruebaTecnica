package com.prueba.tecnica.neoris.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persona")

public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersona")
	private int idPersona;
	
	@Column(name = "nombrePersona")
	private String nombrePersona;
	
	@Column(name = "generoPersona")
	private String generoPersona;
	
	@Column(name = "edadPersona")
	private String edadPersona;
	
	@Column(name = "identificacionPersona")
	private String identificacionPersona;
	
	@Column(name = "direccionPersona")
	private String direccionPersona;
	
	@Column(name = "telefonoPersona")
	private String telefonoPersona;
	
	//relaciones con otras clases.
	@OneToOne(mappedBy="personaCliente")
	private Cliente clientePersona;

	//Metodos getter y setter
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getGeneroPersona() {
		return generoPersona;
	}

	public void setGeneroPersona(String generoPersona) {
		this.generoPersona = generoPersona;
	}

	public String getEdadPersona() {
		return edadPersona;
	}

	public void setEdadPersona(String edadPersona) {
		this.edadPersona = edadPersona;
	}

	public String getIdentificacionPersona() {
		return identificacionPersona;
	}

	public void setIdentificacionPersona(String identificacionPersona) {
		this.identificacionPersona = identificacionPersona;
	}

	public String getDireccionPersona() {
		return direccionPersona;
	}

	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}

	public String getTelefonoPersona() {
		return telefonoPersona;
	}

	public void setTelefonoPersona(String telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}
	
	
	
}
