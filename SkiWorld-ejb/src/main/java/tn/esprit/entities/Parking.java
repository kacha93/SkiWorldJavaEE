package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Parking
 *
 */
@Entity

public class Parking implements Serializable {

	
	private int id;
	private int placesNumber;
	private int occupiedPlaces;
	private Hotel hotel;
	private static final long serialVersionUID = 1L;

	public Parking() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getPlacesNumber() {
		return placesNumber;
	}
	public void setPlacesNumber(int placesNumber) {
		this.placesNumber = placesNumber;
	}
	public int getOccupiedPlaces() {
		return occupiedPlaces;
	}
	public void setOccupiedPlaces(int occupiedPlaces) {
		this.occupiedPlaces = occupiedPlaces;
	}
	
	@OneToOne(mappedBy="parking")
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	 
	
	
	
   
	
}
