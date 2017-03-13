package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Worker;

@Local
public interface WorkerServiceLocal {
	public void AddWorker(Worker w);
	 public void UpdateWorker(Worker w);
	 public void DeleteWorker(Worker w);
	 public List<Worker> findAll();
	 public Worker findById(Integer id);
	 public List<Worker> findByName(String name);

}
