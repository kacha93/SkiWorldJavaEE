package tn.esprit.beans;



import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import tn.esprit.entities.HotelRoom;

import tn.esprit.services.HotelRoomService;

@Named("hotelRoomBean")
@RequestScoped
public class HotelRoomBean {

	public HotelRoomBean() {
		
	}
	
	@EJB
	HotelRoomService ejb;
	
	private HotelRoom item = new HotelRoom();
	private List<HotelRoom> items;
	
	
	public void create (){
		ejb.create(item);
	}
	
	public List<HotelRoom> getItems(){
		if(items==null){
			items = ejb.findAll();
		}
		
		return items;
	}
	
	
	
	

}
