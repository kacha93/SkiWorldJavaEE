package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: ShopManager
 *
 */
@Entity

public class ShopManager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public ShopManager() {
		super();
	}
   
}
