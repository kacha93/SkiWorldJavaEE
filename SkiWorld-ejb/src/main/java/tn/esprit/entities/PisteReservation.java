package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PisteReservation
 *
 */
@Entity

public class PisteReservation implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private PisteReservationPk pk ;
	private Date pisteReservationDate;
	
	
	

	@EmbeddedId
	public PisteReservationPk getPk() {
		return pk;
	}




	public void setPk(PisteReservationPk pk) {
		this.pk = pk;
	}




	public Date getPisteReservationDate() {
		return pisteReservationDate;
	}




	public void setPisteReservationDate(Date pisteReservationDate) {
		this.pisteReservationDate = pisteReservationDate;
	}




	public PisteReservation() {
		super();
	}
   
}
