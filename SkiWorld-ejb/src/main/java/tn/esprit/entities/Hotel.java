package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findById", query = "SELECT h FROM Hotel h WHERE h.id = :id"),
    @NamedQuery(name = "Hotel.findByAdress", query = "SELECT h FROM Hotel h WHERE h.adress = :adress"),
    @NamedQuery(name = "Hotel.findByAvailableRooms", query = "SELECT h FROM Hotel h WHERE h.availableRooms = :availableRooms"),
    @NamedQuery(name = "Hotel.findByName", query = "SELECT h FROM Hotel h WHERE h.name = :name"),
    @NamedQuery(name = "Hotel.findByRoomNumber", query = "SELECT h FROM Hotel h WHERE h.roomNumber = :roomNumber"),
    @NamedQuery(name = "Hotel.findByStars", query = "SELECT h FROM Hotel h WHERE h.stars = :stars")})
public class Hotel implements Serializable {

	
	private int id;
	private String name ;
	private int stars;
	private int roomNumber ;
	private int availableRooms;
	private Adress adress;
	private byte[] logo ;
	private byte[] image;
	
	private Parking parking;
	private HotelManager hotelManager;
	
	private List<HotelRoom> hotelRoom;
	
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
	
	@OneToMany(mappedBy="hotel",
			cascade=CascadeType.ALL)
	public List<HotelRoom> getHotelRoom() {
		return hotelRoom;
	}
	public void setHotelRoom(List<HotelRoom> hotelRoom) {
		this.hotelRoom = hotelRoom;
	}
   
	
	
	
}
