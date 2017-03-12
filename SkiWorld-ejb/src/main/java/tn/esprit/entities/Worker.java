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

	private int experienceYears;
	private String function;
	
	private static final long serialVersionUID = 1L;

	public Worker() {
		super();
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	
   
}
