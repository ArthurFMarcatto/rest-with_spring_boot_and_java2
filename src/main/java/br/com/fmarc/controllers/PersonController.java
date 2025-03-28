package br.com.fmarc.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmarc.data.dto.PersonDTO;
import br.com.fmarc.services.PersonService;

@RestController
@RequestMapping("/api/person-v1")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<PersonDTO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonDTO findByID(@PathVariable("id") Long id) {
		var person = service.findById(id);
		return person;
		//return service.findById(id);
	}

	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonDTO createPerson(@RequestBody PersonDTO person) {
		return service.createPerson(person);
	}
	
	@PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonDTO updatePerson(@RequestBody PersonDTO person) {
		return service.updatePerson(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
		service.deletePerson(id);
		return ResponseEntity.noContent().build();
	}

}
