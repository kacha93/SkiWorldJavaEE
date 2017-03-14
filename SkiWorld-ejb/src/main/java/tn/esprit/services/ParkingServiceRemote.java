package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Hotel;
import tn.esprit.entities.Parking;

@Remote
public interface ParkingServiceRemote {
	
	public void create(Parking parking);
	public void edit (Parking parking);
	public void delete (Parking parking);
	public List<Parking> findAll();
	public Parking findById(int id);
	public Parking findByHotel(Hotel hotel);

}
