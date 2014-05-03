package br.com.hibernateservletjsp1p1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPerson;
		
	private String namePerson;
	
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL)
	private Address address;

	public Person(Long idPerson, String namePerson, Address address) {
		super();
		this.idPerson = idPerson;
		this.namePerson = namePerson;
		this.address = address;
	}
	
	

	public Person(Long idPerson, String namePerson) {
		super();
		this.idPerson = idPerson;
		this.namePerson = namePerson;
	}
	
	


    //Contrutor só com idPerson para poder deletar resgatando só o id da página
	public Person(Long idPerson) {
		super();
		this.idPerson = idPerson;
	}



	public Person() {
		super();
	}

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((idPerson == null) ? 0 : idPerson.hashCode());
		result = prime * result
				+ ((namePerson == null) ? 0 : namePerson.hashCode());
		return result;
	}


}
