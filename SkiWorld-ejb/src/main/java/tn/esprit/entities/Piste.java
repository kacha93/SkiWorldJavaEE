package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Piste
 *
 */
@Entity

public class Piste implements Serializable {

	
	private int id;
	private Adress adress;
	private String difficuly;
	private int totalPlaces;
	
	private static final long serialVersionUID = 1L;

	public Piste() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Embedded
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public String getDifficuly() {
		return difficuly;
	}
	public void setDifficuly(String difficuly) {
		this.difficuly = difficuly;
	}
	public int getTotalPlaces() {
		return totalPlaces;
	}
	public void setTotalPlaces(int totalPlaces) {
		this.totalPlaces = totalPlaces;
	}
   
	
}
