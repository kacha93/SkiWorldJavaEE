package tn.esprit.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.entities.Hotel;
import tn.esprit.entities.Parking;
import tn.esprit.services.ParkingServiceLocal;

@RequestScoped
@ManagedBean(name="parkingBean")

public class ParkingBean {


	public ParkingBean() {
	}
	
	@EJB
	ParkingServiceLocal ejb;
	
	private Parking item = new Parking();
	private List<Parking> items ;
	private boolean isEditVisible =false; 
	private boolean isAddVisible = false;
	
	
	@PostConstruct
	public void init(){
		item = new Parking();
		item.setHotel(new Hotel());
		items = ejb.findAll();
	}
	
public void prepareCreate(){
		
		
		this.setAddVisible(true);
		init();
	}
	
	public void create(){
		ejb.create(item);
	}
	
	public void prepareEdit(Parking park){
		item = park;
		setEditVisible(true);
		
	}
	
	public void edit(){
		ejb.edit(item);
		this.setEditVisible(false);
		init();
	}
	
	public void delete (Parking park){
		
		ejb.delete(park);
		init();
		
	}
	
	public List<Parking> getItems (){
		if(items == null){
			items=ejb.findAll();
		}
		return items;
	}

	public Parking getItem() {
		return item;
	}

	public void setItem(Parking item) {
		this.item = item;
	}

	public void setItems(List<Parking> items) {
		this.items = items;
	}
	
	
	public boolean isEditVisible() {
		return isEditVisible;
	}


	public void setEditVisible(boolean isEditVisible) {
		this.isEditVisible = isEditVisible;
	}


	public boolean isAddVisible() {
		return isAddVisible;
	}


	public void setAddVisible(boolean isAddVisible) {
		this.isAddVisible = isAddVisible;
	}
	

}
