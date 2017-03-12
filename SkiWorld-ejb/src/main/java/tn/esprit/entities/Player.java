package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity

public class Player extends User implements Serializable {
	
	private boolean isProfessional;
	private boolean isVip;
	private int experienceYears;

	
	private static final long serialVersionUID = 1L;

	public Player() {
		super();
	}

	public boolean isProfessional() {
		return isProfessional;
	}

	public void setProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
   
}
