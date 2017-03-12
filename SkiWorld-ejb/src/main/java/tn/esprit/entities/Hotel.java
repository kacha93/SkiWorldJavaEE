package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity

public class Hotel implements Serializable {

	
	private int id;
	private String name ;
	private int stars;
	private int roomNumber ;
	private int availableRooms;
	private Adress adress;
	private byte[] logo ;
	private byte[] image;
	private List<HotelRoomReservation> reservations;
	private Parking parking;
	private HotelManager hotelManager;
	
	private static final long serialVersionUID = 1L;

	public Hotel() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getAvailableRooms() {
		return availableRooms;
	}
	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	
	@Embedded
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	@Lob
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	@Lob
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@OneToMany
	public List<HotelRoomReservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<HotelRoomReservation> reservations) {
		this.reservations = reservations;
	}
	
	@OneToOne
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	@ManyToOne
	public HotelManager getHotelManager() {
		return hotelManager;
	}
	public void setHotelManager(HotelManager hotelManager) {
		this.hotelManager = hotelManager;
	}
   
	
	
}
