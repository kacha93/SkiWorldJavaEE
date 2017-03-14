package tn.esprit.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.entities.Parking;
import tn.esprit.services.ParkingServiceLocal;

@RequestScoped
@ManagedBean(name="parkingBean")

public class ParkingBean {


	public ParkingBean() {
	}
	@EJB
	ParkingServiceLocal ejb;
	
	Parking item = new Parking();
	List<Parking> items=ejb.findAll() ;
	
	public void create(){
		ejb.create(item);
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
	
	

}
