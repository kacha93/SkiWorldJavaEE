package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Planning
 *
 */
@Entity

public class Planning implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private PlanningPk pk ;
	private Date planningDate ;
	
	
	@EmbeddedId
	public PlanningPk getPk() {
		return pk;
	}


	public void setPk(PlanningPk pk) {
		this.pk = pk;
	}


	public Planning() {
		super();
	}


	@Temporal(TemporalType.DATE)
	public Date getPlanningDate() {
		return planningDate;
	}


	public void setPlanningDate(Date planningDate) {
		this.planningDate = planningDate;
	}
   
}
