package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: PisteManager
 *
 */
@Entity

public class PisteManager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public PisteManager() {
		super();
	}
   
}
