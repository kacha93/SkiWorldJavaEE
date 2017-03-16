package tn.esprit.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Hotel;

import tn.esprit.services.HotelServiceLocal;

@ManagedBean(name = "hotelBean")
@ViewScoped

public class HotelBean {

	public HotelBean() {

	}

	@EJB
	HotelServiceLocal ejb;

	private Hotel hotel= new Hotel();
	
	
	private List<Hotel> hotels;
	
	
	private boolean isAddVisble = false ;
	private boolean isEditVisible = false;

	@PostConstruct
	public void init() {
		hotels = ejb.findAll();
		hotel = new Hotel();
		
	}

	public void prepareCreate() {
		setAddVisble(true);
		init();
		
	}
	
	public void create() {
		ejb.create(hotel);
		setAddVisble(false);
		init();
		
	}
	
	public void prepareEdit(Hotel item){
		hotel = item;
		setEditVisible(true);
		
		
	}
	
	public void edit(){
		
		ejb.edit(hotel);
		setEditVisible(false);
		
	}


	public void delete(Hotel hotel) {

		
		ejb.delete(hotel);
		init();
		

	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}



	public boolean isAddVisble() {
		return isAddVisble;
	}

	public void setAddVisble(boolean isAddVisble) {
		this.isAddVisble = isAddVisble;
	}

	public boolean isEditVisible() {
		return isEditVisible;
	}

	public void setEditVisible(boolean isEditVisible) {
		this.isEditVisible = isEditVisible;
	}
	

}
