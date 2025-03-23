package br.com.fmarc.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fmarc.data.dto.PersonDTO;
import br.com.fmarc.exceptions.ResourceNotFoundException;
import br.com.fmarc.mapper.ObjectMapper;
import br.com.fmarc.models.Person;
import br.com.fmarc.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonDTO> findAll() {
		logger.info("Finding all people!");
		return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);
	}

	public PersonDTO findById(Long id) {
		logger.info("Finding one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		return ObjectMapper.parseObject(entity, PersonDTO.class);
	}

	public PersonDTO createPerson(PersonDTO person) {

		logger.info("Creating a person!");
		var entity = ObjectMapper.parseObject(person, Person.class);
		var vo = ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
		return vo;
	}

	public PersonDTO updatePerson(PersonDTO person) {

		logger.info("Updating a person!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstname(person.getFirstname());
		entity.setLastname(person.getLastname());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		entity.setBirthday(person.getBirthday());
		entity.setPhonenumber(person.getPhonenumber());

		var vo = ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
		return vo;

	}

	public void deletePerson(Long id) {

		logger.info("Deleting a person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(entity);
	}

}
