package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: Worker
 *
 */
@Entity

public class Worker extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Worker() {
		super();
	}
   
}
