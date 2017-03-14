package tn.esprit.beans;

import java.util.List;

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

	private Hotel item = new Hotel();
	private List<Hotel> items = ejb.findAll();

	public void create() {

		ejb.create(item);
	}

	public List<Hotel> getItems() {
		if (items == null) {
			items = ejb.findAll();
		}
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
