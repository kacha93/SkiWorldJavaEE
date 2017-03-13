package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Worker;

@Remote
public interface WorkerServiceRemote {
	public void AddWorker(Worker w);
	 public void UpdateWorker(Worker w);
	 public void DeleteWorker(Worker w);
	 public List<Worker> findAll();
	 public Worker findById(Integer id);
	 public List<Worker> findByName(String name);

}
