package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: HotelRoomReservation
 *
 */
@Entity

public class HotelRoomReservation implements Serializable {

	private HotelRoomReservationPk pk ;
	private Date reservationDate ; 
	private Date checkIn;
	private Date checkOut ; 
	private int customerNumber ;
	private boolean withParking ;
	private boolean isEffective ;
	
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
	
	
   
}
