package tn.esprit.beans;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.HotelRoom;
import tn.esprit.services.HotelRoomServiceLocal;

@RequestScoped
@ManagedBean(name="hotelRoomBean")
public class HotelRoomBean {

	public HotelRoomBean() {
		
	}
	
	@EJB
	HotelRoomServiceLocal ejb;
	
	private HotelRoom item ;
	private List<HotelRoom> items;
	
	@PostConstruct
	public void init(){
		item = new HotelRoom();
		items = ejb.findAll();
	}
	
	
	public void create (){
		
		ejb.create(item);
		init();
	}
	
	public void delete (HotelRoom hotelRoom){
		init();
		ejb.delete(hotelRoom);
		
	}
	public List<HotelRoom> getItems(){

		return items;
	}

	public HotelRoom getItem() {
		return item;
	}

	public void setItem(HotelRoom item) {
		this.item = item;
	}

	public void setItems(List<HotelRoom> items) {
		this.items = items;
	}
	
	
	
	

}
