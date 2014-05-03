package br.com.hibernateservletjsp1p1.repository;

import javax.persistence.EntityManager;

import br.com.hibernateservletjsp1p1.entity.Person;

public class PersonRepositoryJPA extends RepositoryJPA<Person, Long> implements PersonRepository{

	public PersonRepositoryJPA(EntityManager em) {
		super(Person.class, em);
		// TODO Auto-generated constructor stub
	}

}
