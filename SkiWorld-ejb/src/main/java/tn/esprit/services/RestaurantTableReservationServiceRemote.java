package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.RestaurantTableReservation;

@Remote
public interface RestaurantTableReservationServiceRemote {
	public void AddRestaurantTableReservation(RestaurantTableReservation res);
	 public void UpdateRestaurantTableReservation(RestaurantTableReservation res);
	 public void DeleteRestaurantTableReservation(RestaurantTableReservation res);
	 public List<RestaurantTableReservation> findAll();

}
