package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	
	private int id;
	private String name;
	private Adress adress;
	private Date eventDate;
	private List<Planning> plannings;
	private EventManager eventManager;
	private Player player;
	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	@Temporal(TemporalType.DATE)
	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	@Embedded
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	@OneToMany(mappedBy="event",
			cascade=CascadeType.ALL)
	public List<Planning> getPlannings() {
		return plannings;
	}
	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	public EventManager getEventManager() {
		return eventManager;
	}
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
   
}
