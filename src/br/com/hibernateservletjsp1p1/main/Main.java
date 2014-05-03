package br.com.hibernateservletjsp1p1.main;

import javax.persistence.EntityManager;

import br.com.hibernateservletjsp1p1.entity.Address;
import br.com.hibernateservletjsp1p1.entity.Person;
import br.com.hibernateservletjsp1p1.repository.JPA;
import br.com.hibernateservletjsp1p1.repository.PersonRepository;
import br.com.hibernateservletjsp1p1.repository.PersonRepositoryJPA;

public class Main {
	
	
	public static void main(String[] args) {
		
		Person p = new Person(null,"Renan da Main");
		Address a = new Address(null,"Rua da Main",10,"Bairro da Main");
		
		
		p.setAddress(a);
		a.setPerson(p);
		
		
		PersonRepositoryJPA prj = new PersonRepositoryJPA(JPA.em());
		PersonRepository pr = prj;
		
		try {
			
			pr.save(p);
			pr.commit();
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		
		
		
	}

}
