package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.HotelRoom;

@Remote
public interface HotelRoomServiceRemote {
	
	public void create(HotelRoom hotelRoom);
	public void edit(HotelRoom hotelRoom);
	public void delete(HotelRoom hotelRoom);
	public HotelRoom findById(int id);
	public List<HotelRoom>findAll ();

}
