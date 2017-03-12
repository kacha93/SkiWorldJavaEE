package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: Instructor
 *
 */
@Entity

public class Instructor extends User implements Serializable {

	private int experienceYears;
	private static final long serialVersionUID = 1L;

	public Instructor() {
		super();
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
   
}
