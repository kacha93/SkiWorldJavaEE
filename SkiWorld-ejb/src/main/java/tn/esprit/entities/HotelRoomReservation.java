package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: HotelRoomReservation
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Hotelroomreservation.findAll", query = "SELECT h FROM Hotelroomreservation h"),
    @NamedQuery(name = "Hotelroomreservation.findByHotelRoomId", query = "SELECT h FROM Hotelroomreservation h WHERE h.hotelroomreservationPK.hotelRoomId = :hotelRoomId"),
    @NamedQuery(name = "Hotelroomreservation.findByUserId", query = "SELECT h FROM Hotelroomreservation h WHERE h.hotelroomreservationPK.userId = :userId"),
    @NamedQuery(name = "Hotelroomreservation.findByCheckIn", query = "SELECT h FROM Hotelroomreservation h WHERE h.checkIn = :checkIn"),
    @NamedQuery(name = "Hotelroomreservation.findByCheckOut", query = "SELECT h FROM Hotelroomreservation h WHERE h.checkOut = :checkOut"),
    @NamedQuery(name = "Hotelroomreservation.findByCustomerNumber", query = "SELECT h FROM Hotelroomreservation h WHERE h.customerNumber = :customerNumber"),
    @NamedQuery(name = "Hotelroomreservation.findByEffective", query = "SELECT h FROM Hotelroomreservation h WHERE h.effective = :effective"),
    @NamedQuery(name = "Hotelroomreservation.findByReservationDate", query = "SELECT h FROM Hotelroomreservation h WHERE h.reservationDate = :reservationDate"),
    @NamedQuery(name = "Hotelroomreservation.findByWithParking", query = "SELECT h FROM Hotelroomreservation h WHERE h.withParking = :withParking")})

public class HotelRoomReservation implements Serializable {

	private HotelRoomReservationPk pk ;
	private Date reservationDate ; 
	private Date checkIn;
	private Date checkOut ; 
	private int customerNumber ;
	private boolean withParking ;
	private boolean isEffective ;
	
	private Client client ; 
	private HotelRoom hotelRoom;
	
	private static final long serialVersionUID = 1L;

	public HotelRoomReservation() {
		super();
	}

	@EmbeddedId
	public HotelRoomReservationPk getPk() {
		return pk;
	}

	public void setPk(HotelRoomReservationPk pk) {
		this.pk = pk;
	}

	@Temporal(TemporalType.DATE)
	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	@Temporal(TemporalType.DATE)
	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public boolean isWithParking() {
		return withParking;
	}

	public void setWithParking(boolean withParking) {
		this.withParking = withParking;
	}

	public boolean isEffective() {
		return isEffective;
	}

	public void setEffective(boolean isEffective) {
		this.isEffective = isEffective;
	}

	@ManyToOne
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne
	public HotelRoom getHotelRoom() {
		return hotelRoom;
	}

	public void setHotelRoom(HotelRoom hotelRoom) {
		this.hotelRoom = hotelRoom;
	}
	
	
	
   
}
