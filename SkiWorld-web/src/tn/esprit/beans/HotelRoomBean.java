package tn.esprit.beans;



import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.entities.HotelRoom;
import tn.esprit.services.HotelRoomServiceLocal;

@RequestScoped
@ManagedBean(name="hotelRoomBean")
public class HotelRoomBean {

	public HotelRoomBean() {
		
	}
	
	@EJB
	HotelRoomServiceLocal ejb;
	
	private HotelRoom item = new HotelRoom();
	private List<HotelRoom> items= new ArrayList<HotelRoom>();
	
	
	public void create (){
		
		ejb.create(item);
	}
	
	public List<HotelRoom> getItems(){
		if(items==null){
			items = ejb.findAll();
		}
		
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
