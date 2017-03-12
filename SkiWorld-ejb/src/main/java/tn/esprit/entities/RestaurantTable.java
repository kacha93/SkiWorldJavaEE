package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RestaurantTable
 *
 */
@Entity

public class RestaurantTable implements Serializable {

	
	private int id;
	private static final long serialVersionUID = 1L;

	public RestaurantTable() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
