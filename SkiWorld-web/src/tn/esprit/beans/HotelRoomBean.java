package tn.esprit.beans;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Hotel;
import tn.esprit.entities.HotelRoom;
import tn.esprit.services.HotelRoomServiceLocal;
import tn.esprit.services.HotelServiceLocal;

@ViewScoped
@ManagedBean(name="hotelRoomBean")
public class HotelRoomBean {

	public HotelRoomBean() {
		
	}
	
	@EJB
	HotelRoomServiceLocal ejb;
	
	
	
	private HotelRoom item = new HotelRoom();
	private List<HotelRoom> items;
	private boolean isEditVisible =false; 
	private boolean isAddVisible = false;
	
	@PostConstruct
	public void init(){
		item = new HotelRoom();
		item.setHotel(new Hotel());
		items = ejb.findAll();
	}
	
	public void prepareCreate(){
		
		init();
		this.setAddVisible(true);
	}
	
	public void create (){
		
		item.setAvailable(true);
		ejb.create(item);
		this.setAddVisible(false);
		init();
		
		
		
	}
	
	public void prepareEdit(HotelRoom hotelRoom){
		item = hotelRoom;
		setEditVisible(true);
		
	}
	
	public void edit(){
		ejb.edit(item);
		this.setEditVisible(false);
		init();
	}
	
	public void delete (HotelRoom hotelRoom){
		
		ejb.delete(hotelRoom);
		init();
		
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
