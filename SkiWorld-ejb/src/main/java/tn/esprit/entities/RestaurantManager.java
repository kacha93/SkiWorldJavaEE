package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: RestaurantManager
 *
 */
@Entity

public class RestaurantManager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public RestaurantManager() {
		super();
	}
   
}