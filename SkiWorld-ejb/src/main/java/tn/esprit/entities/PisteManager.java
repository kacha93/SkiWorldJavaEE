package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: PisteManager
 *
 */
@Entity

public class PisteManager extends User implements Serializable {

	
	private List<PisteReservation> pisteReservations;
	
	private static final long serialVersionUID = 1L;

	public PisteManager() {
		super();
	}

	@OneToMany(cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	public List<PisteReservation> getPisteReservations() {
		return pisteReservations;
	}

	public void setPisteReservations(List<PisteReservation> pisteReservations) {
		this.pisteReservations = pisteReservations;
	}
	
	
	
   
}
