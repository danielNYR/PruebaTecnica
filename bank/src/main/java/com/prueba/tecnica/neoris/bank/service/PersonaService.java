package com.prueba.tecnica.neoris.bank.service;

import java.util.List;

import com.prueba.tecnica.neoris.bank.entity.Persona;

public interface PersonaService {

	public boolean registrarPersona(Persona persona);
	public List<Persona> listarPersonas();
}
