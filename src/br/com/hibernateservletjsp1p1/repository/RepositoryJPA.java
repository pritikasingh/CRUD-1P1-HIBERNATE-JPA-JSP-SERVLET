package br.com.hibernateservletjsp1p1.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class RepositoryJPA<T, ID extends Serializable> implements
		GenericRepository<T, ID> {

	private Class<T> type;
	private EntityManager em;

	public RepositoryJPA(Class<T> type, EntityManager em) {
		super();
		this.type = type;
		this.em = em;
	}

	@Override
	public void save(T instance) throws Exception {
		getEm().persist(instance);
	}

	@Override
	public void update(T instance) throws Exception {
		getEm().merge(instance);
	}

	@Override
	public void remove(T instance) throws Exception {
		getEm().remove(instance);

	}

	@Override
	public T findById(ID id) throws Exception {
		// TODO Auto-generated method stub
		return getEm().find(type, id);
	}

	public List<T> findAll() throws Exception {

		CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(type);
		cq.select(cq.from(type));
		return getEm().createQuery(cq).getResultList();

	}

	public List<T> findAll(Integer begin, Integer end) throws Exception {
		CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(type);
		cq.select(cq.from(type));
		return getEm().createQuery(cq).setFirstResult(begin).setMaxResults(end)
				.getResultList();
	}

	@Override
	public void refresh(T instance) {
		getEm().refresh(instance);

	}

	@Override
	public void flush() {
		getEm().flush();

	}

	@Override
	public void clear() {
		getEm().clear();

	}

	@Override
	public EntityManager getEm() {
		// TODO Auto-generated method stub
		return em;
	}

	@Override
	public void commit() {
		getEm().getTransaction().begin();
		getEm().getTransaction().commit();

	}

}
