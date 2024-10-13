package br.com.fmarc.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fmarc.data.vo.v1.PersonVO;
import br.com.fmarc.exceptions.ResourceNotFoundException;
import br.com.fmarc.mapper.DozerMapper;
import br.com.fmarc.models.Person;
import br.com.fmarc.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {
		logger.info("Finding all people!");
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class) ;
	}

	public PersonVO findById(Long id) {
		logger.info("Finding one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapper.parseObject(entity, PersonVO.class);
	}

	public PersonVO createPerson(PersonVO person) {

		logger.info("Creating a person!");		
		var entity = DozerMapper.parseObject(person, Person.class);			
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVO updatePerson(PersonVO person) {

		logger.info("Updating a person!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;

	}

	public void deletePerson(Long id) {

		logger.info("Deleting a person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}



}
