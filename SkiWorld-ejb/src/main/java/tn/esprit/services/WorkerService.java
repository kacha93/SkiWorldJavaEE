package tn.esprit.services;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.entities.Worker;

/**
 * Session Bean implementation class WorkerService
 */
@Singleton
public class WorkerService implements WorkerServiceRemote, WorkerServiceLocal {
	@PersistenceContext
	EntityManager em;

    
    public WorkerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddWorker(Worker w) {
		em.persist(w);
		
	}

	@Override
	public void UpdateWorker(Worker w) {
		em.merge(w);
		
	}

	@Override
	public void DeleteWorker(Worker w) {
		em.remove(em.merge(w));
		
	}

	@Override
	public List<Worker> findAll() {
		javax.persistence.Query q=em.createQuery("select e from Worker e");
		return q.getResultList();
	}

	@Override
	public Worker findById(Integer id) {
		Worker w=em.find(Worker.class,id);
		return w;
	}

	@Override
	public List<Worker> findByName(String name) {
		javax.persistence.Query query = em.createQuery("SELECT c FROM Worker c where c.name like:employe ")
				.setParameter("employe", name);
		List<Worker> neg = query.getResultList();
		return neg;
	}

}
