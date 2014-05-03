package br.com.hibernateservletjsp1p1.repository;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;

public interface GenericRepository<T, ID extends Serializable> {
	
	public void save(T instance) throws Exception;
	
	public void update(T instance) throws Exception;
	
	public void remove(T instance) throws Exception;
	
	public void commit();
	
	public T findById(ID id) throws Exception;
	
	public Collection<T> findAll() throws Exception;
	
	public void refresh(T instance);
	
	public void flush();
	
	public void clear();

	public EntityManager getEm();
		
}
