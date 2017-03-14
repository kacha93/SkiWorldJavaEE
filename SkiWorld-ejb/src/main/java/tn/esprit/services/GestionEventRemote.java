package tn.esprit.services;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Event;

@Remote
public interface GestionEventRemote {
	public Boolean add(Event e);
	public Boolean update(Event e);
	public Event findById(int id);
	public Boolean delete(Event e);
	public List<Event> findAll();

}
