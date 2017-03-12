package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: HotelManager
 *
 */
@Entity

public class HotelManager extends User implements Serializable {

	private int exprinceYears;
	
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
   
}
