package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PisteType
 *
 */
@Entity

public class PisteType implements Serializable {

	
	private int id;
	private String type;
	private static final long serialVersionUID = 1L;

	public PisteType() {
		super();
	}   
	@Id    
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
