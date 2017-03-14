package tn.esprit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HotelRoom
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "HotelRoom.findAll", query = "SELECT h FROM HotelRoom h"),
    @NamedQuery(name = "HotelRoom.findById", query = "SELECT h FROM HotelRoom h WHERE h.id = :id"),
    @NamedQuery(name = "HotelRoom.findByNumber", query = "SELECT h FROM HotelRoom h WHERE h.number = :number"),
    @NamedQuery(name = "HotelRoom.findByPrice", query = "SELECT h FROM HotelRoom h WHERE h.price = :price"),
    @NamedQuery(name = "HotelRoom.findByType", query = "SELECT h FROM HotelRoom h WHERE h.type = :type")})

public class HotelRoom implements Serializable {

	
	private int id;
	private int number ; 
	private float price ; 
	private String type;
	private List<HotelRoomReservation> hotelRoomReservations;
	private Hotel hotel ;
	private static final long serialVersionUID = 1L;

	public HotelRoom() {
		super();
		hotelRoomReservations = new ArrayList<HotelRoomReservation>();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@OneToMany(mappedBy="hotelRoom",
			cascade=CascadeType.ALL)
	public List<HotelRoomReservation> getHotelRoomReservations() {
		return hotelRoomReservations;
	}
	public void setHotelRoomReservations(List<HotelRoomReservation> hotelRoomReservations) {
		this.hotelRoomReservations = hotelRoomReservations;
	}
	
	@ManyToOne
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	
   
}
