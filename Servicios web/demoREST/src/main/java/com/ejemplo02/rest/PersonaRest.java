package com.ejemplo02.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo02.dao.PersonaDAO;
import com.ejemplo02.model.Persona;

@RestController
@RequestMapping("personas")
public class PersonaRest {
	
	@Autowired
	private PersonaDAO personaDAO;
	
	//METODOS HTTP SOLICITUD AL SERVIDOR
	
	@PostMapping("/save")
	public void save(@RequestBody Persona persona) {
		personaDAO.save(persona);
		System.out.println("Persona: " + persona.getNombre()+ " " + persona.getApellido() + " creada con exito");
	}
	
	@GetMapping("/list")
	public List<Persona> list(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id){
		personaDAO.deleteById(id);
		System.out.println("Persona eliminada satisfactoriamente");
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Persona persona) {
		personaDAO.save(persona);
		System.out.println("Ahora la persona se llama: " + persona.getNombre() + " " + persona.getApellido());
	}
	
	@GetMapping("/obtener/{id}")
	public List<Persona> getPersona(@PathVariable("id") Persona per){
		List<Persona> lista = personaDAO.findPersonaById(per.getId());
		System.out.println("Persona: " + lista);
		return lista;
	}
}
