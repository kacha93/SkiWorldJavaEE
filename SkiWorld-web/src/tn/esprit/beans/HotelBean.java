package tn.esprit.beans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import tn.esprit.entities.Hotel;

import tn.esprit.services.HotelServiceLocal;

@ManagedBean(name = "hotelBean")
@ViewScoped

public class HotelBean {

	public HotelBean() {

	}

	@EJB
	HotelServiceLocal ejb;
	
	private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country; 
    private String city;  
    private Map<String,String> countries;
    private Map<String,String> cities;
	
	private UploadedFile file ;

	private Hotel hotel = new Hotel();

	private List<Hotel> hotels;

	private boolean isAddVisble = false;
	private boolean isEditVisible = false;

	@PostConstruct
	public void init() {
		hotels = ejb.findAll();
		hotel = new Hotel();
		file = new UploadedFile() {
			
			@Override
			public void write(String arg0) throws Exception {
			}
			
			@Override
			public long getSize() {
				return 0;
			}
			
			@Override
			public InputStream getInputstream() throws IOException {
				return null;
			}
			
			@Override
			public String getFileName() {
				return null;
			}
			
			@Override
			public byte[] getContents() {
				return null;
			}
			
			@Override
			public String getContentType() {
				return null;
			}
		};
		
		countries  = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Canada", "Canada");
        countries.put("England", "England");
        countries.put("Switzerland", "Switzerland");
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);
         
        map = new HashMap<String, String>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);
         
        map = new HashMap<String, String>();
        map.put("Toronto", "Toronto");
        map.put("Montreal", "Montreal");
        map.put("Ottawa", "Ottawa");
        data.put("Canada", map);
        
        map = new HashMap<String, String>();
        map.put("Manchester", "manchester");
        map.put("Plymouth", "Plymouth");
        map.put("Southampton", "Southampton");
        data.put("England", map);
        
        
        map = new HashMap<String, String>();
        map.put("Lussane","lussane");
        map.put("Zürich","Zürich");
        map.put("Berne","Berne");
        map.put("Bâle", "Bâle");
        data.put("Switzerland", map);
		

	}
	
	public void upload(FileUploadEvent event) throws IOException{
//		InputStream is = null ;
//		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//
//		int nRead;
//		byte[] data = event.getFile().getContents();
//
//		while ((nRead = is.read(data, 0, data.length)) != -1) {
//				buffer.write(data, 0, nRead);
//				}
//
//		buffer.flush();

			hotel.setLogo(sun.misc.IOUtils.readFully(event.getFile().getInputstream(), -1, true));
		
		hotel.setLogoPath(event.getFile().getFileName());
	    String contentType = file.getContentType();
	    
        
    }

	public void prepareCreate() {
		init();
		setAddVisble(true);

	}

	public void prepareEdit(Hotel item) {
		hotel = item;
		setEditVisible(true);

	}

	public void edit() {

		ejb.edit(hotel);
		setEditVisible(false);
		init();

	}

	public void delete(Hotel hotel) {

		ejb.delete(hotel);
		init();

	}

	public void create() {
//		hotel.setLogo(file.getContents());
//		hotel.setLogoPath(file.getFileName());
		hotel.getAdress().setCountry(country);
		hotel.getAdress().setCity(city);
		ejb.create(hotel);
		setAddVisble(false);
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public void setData(Map<String, Map<String, String>> data) {
		this.data = data;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}
	
	public void onCountryChange() {
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<String, String>();
    }
	



}
