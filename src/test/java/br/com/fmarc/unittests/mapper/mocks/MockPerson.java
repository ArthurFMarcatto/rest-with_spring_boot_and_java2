package br.com.fmarc.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.fmarc.data.dto.PersonDTO;
import br.com.fmarc.models.Person;

public class MockPerson {

	public Person mockEntity() {
		return mockEntity(0);
	}

	public PersonDTO mockVO() {
		return mockVO(0);
	}

	public List<Person> mockEntityList() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}

	public List<PersonDTO> mockVOList() {
		List<PersonDTO> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockVO(i));
		}
		return persons;
	}

	public Person mockEntity(Integer number) {
		Person person = new Person();
		person.setAddress("Addres Test" + number);
		person.setFirstname("First Name Test" + number);
		person.setGender(((number % 2) == 0) ? "Male" : "Female");
		person.setId(number.longValue());
		person.setLastname("Last Name Test" + number);
		return person;
	}

	public PersonDTO mockVO(Integer number) {
		PersonDTO person = new PersonDTO();
		person.setAddress("Addres Test" + number);
		person.setFirstname("First Name Test" + number);
		person.setGender(((number % 2) == 0) ? "Male" : "Female");
		person.setId(number.longValue());
		person.setLastname("Last Name Test" + number);
		return person;
	}

}
