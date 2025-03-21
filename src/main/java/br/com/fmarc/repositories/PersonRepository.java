package br.com.fmarc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fmarc.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
