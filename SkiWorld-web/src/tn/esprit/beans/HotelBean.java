package tn.esprit.beans;


import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.entities.Hotel;

import tn.esprit.services.HotelServiceLocal;

@ManagedBean(name="hotelBean")
@RequestScoped

public class HotelBean {

	public HotelBean() {
	
	}

	@EJB
	HotelServiceLocal ejb;

	private Hotel item ;
	private List<Hotel> items ;
	
	@PostConstruct
	public void init(){
		items = ejb.findAll();
		item  = new Hotel();
	}

	public void create() {

		ejb.create(item);
	}
	
	public void delete(Hotel hotel){
		
		ejb.delete(hotel);
		init();
		
	}
	
	public void view(Hotel hotel){
		
	}

	public List<Hotel> getItems() {
		
		return items;
	}

	public Hotel getItem() {
		return item;
	}

	public void setItem(Hotel item) {
		this.item = item;
	}

	public void setItems(List<Hotel> items) {
		this.items = items;
	}
	
	

}
