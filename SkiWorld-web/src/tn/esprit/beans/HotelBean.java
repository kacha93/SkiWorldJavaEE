package tn.esprit.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import tn.esprit.entities.Hotel;
import tn.esprit.services.HotelService;

@Named("hotelBean")
@RequestScoped
public class HotelBean {

	@EJB
	HotelService ejb;
	
	private Hotel item = new Hotel();
	private List<Hotel> items;
	public HotelBean() {
		
	}
	
	public void create (){
		
		ejb.create(item);
	}
	
    public List<Hotel> getItems() {
        if (items == null) {
            items = ejb.findAll();
        }
        return items;
    }

	
}
