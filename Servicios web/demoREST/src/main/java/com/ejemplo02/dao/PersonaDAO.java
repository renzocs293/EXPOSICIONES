package com.ejemplo02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo02.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer>{
	public List<Persona> findPersonaById(Integer id);
}
