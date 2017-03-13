package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.HotelRoomReservation;

@Remote
public interface HotelRoomReservationServiceRemote {
	
	public void create (HotelRoomReservation hotelRoomReservation);
	public void edit (HotelRoomReservation hotelRoomReservation);
	public void delete(HotelRoomReservation hotelRoomReservation);
	public HotelRoomReservation findById(int id);
	public List<HotelRoomReservation> findByUserId(int userId);
	public List<HotelRoomReservation>findAll();

}
