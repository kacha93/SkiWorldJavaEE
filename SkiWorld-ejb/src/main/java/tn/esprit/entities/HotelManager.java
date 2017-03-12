package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: HotelManager
 *
 */
@Entity

public class HotelManager extends User implements Serializable {

	private int exprinceYears;
	
	private List<Hotel> hotel ;
	
	private static final long serialVersionUID = 1L;

	public HotelManager() {
		super();
	}

	public int getExprinceYears() {
		return exprinceYears;
	}

	public void setExprinceYears(int exprinceYears) {
		this.exprinceYears = exprinceYears;
	}

	@OneToMany(mappedBy="hotelManager",
			cascade=CascadeType.ALL)
	public List<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}
	
	
   
}
