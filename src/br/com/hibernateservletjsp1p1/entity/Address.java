package br.com.hibernateservletjsp1p1.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAddress;
	private String streetAddress;
	private Integer numberAddress;
	private String districtAddress;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_person")
	private Person person;


	public Address(Long idAddress, String streetAddress, Integer numberAddress,
			String districtAddress, Person person) {
		super();
		this.idAddress = idAddress;
		this.streetAddress = streetAddress;
		this.numberAddress = numberAddress;
		this.districtAddress = districtAddress;
		this.person = person;
	}
	
	


	public Address(Long idAddress, String streetAddress, Integer numberAddress,
			String districtAddress) {
		super();
		this.idAddress = idAddress;
		this.streetAddress = streetAddress;
		this.numberAddress = numberAddress;
		this.districtAddress = districtAddress;
	}




	public Address() {
		super();
	}


	public Long getIdAddress() {
		return idAddress;
	}


	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public Integer getNumberAddress() {
		return numberAddress;
	}


	public void setNumberAddress(Integer numberAddress) {
		this.numberAddress = numberAddress;
	}


	public String getDistrictAddress() {
		return districtAddress;
	}


	public void setDistrictAddress(String districtAddress) {
		this.districtAddress = districtAddress;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

}
