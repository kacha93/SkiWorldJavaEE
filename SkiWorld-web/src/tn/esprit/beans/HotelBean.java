package tn.esprit.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tn.esprit.entities.Hotel;

import tn.esprit.services.HotelServiceLocal;

@ManagedBean(name = "hotelBean")
@ViewScoped

public class HotelBean {

	public HotelBean() {

	}

	@EJB
	HotelServiceLocal ejb;

	private Hotel hotel = new Hotel();

	private List<Hotel> hotels;

	private boolean isAddVisble = false;
	private boolean isEditVisible = false;

	@PostConstruct
	public void init() {
		hotels = ejb.findAll();
		hotel = new Hotel();

	}

	public void prepareCreate() {
		init();
		setAddVisble(true);

	}

	public void create() {
		

		
		ejb.create(hotel);
		setAddVisble(false);
		init();
		

	}

	public void prepareEdit(Hotel item) {
		hotel = item;
		setEditVisible(true);

	}

	public void edit() {
		FacesContext context = FacesContext.getCurrentInstance();

		

		ejb.edit(hotel);
		setEditVisible(false);
		init();

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

	public HotelServiceLocal getEjb() {
		return ejb;
	}

	/* Converter */

	// @FacesConverter(forClass = Hotel.class)
	// public static class HotelControllerConverter implements Converter {
	//
	// @Override
	// public Object getAsObject(FacesContext facesContext, UIComponent
	// component, String value) {
	// if (value == null || value.length() == 0) {
	// return null;
	// }
	// HotelBean controller = (HotelBean)
	// facesContext.getApplication().getELResolver().
	// getValue(facesContext.getELContext(), null, "hotelController");
	// return controller.getEjb().findById(getKey(value));
	// }
	//
	// int getKey(String value) {
	// int key;
	// key = Integer.parseInt(value);
	// return key;
	// }
	//
	// String getStringKey(int value) {
	// StringBuilder sb = new StringBuilder();
	// sb.append(value);
	// return sb.toString();
	// }
	//
	// @Override
	// public String getAsString(FacesContext facesContext, UIComponent
	// component, Object object) {
	// if (object == null) {
	// return null;
	// }
	// if (object instanceof Hotel) {
	// Hotel o = (Hotel) object;
	// return getStringKey(o.getId());
	// } else {
	// throw new IllegalArgumentException("object " + object + " is of type " +
	// object.getClass().getName() + "; expected type: " +
	// Hotel.class.getName());
	// }
	// }
	//
	// }

}
