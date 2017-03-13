package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.User;

@Remote
public interface UserServiceRemote {
	
	public void create(User user);
	public void edit (User user);
	public User findById(int id);
	public void delete(User user);
	public List<User> findAll();

}
