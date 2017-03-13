package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Hotel;

@Remote
public interface HotelServiceRemote {

	public void create (Hotel hotel);
	public void edit (Hotel hotel);
	public void delete (Hotel hotel);
	public List<Hotel> findAll();
	public Hotel findById(int id);


}
