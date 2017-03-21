package tn.esprit.beans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
@SessionScoped

public class HotelBean {

	public HotelBean() {

	}

	@EJB
	HotelServiceLocal ejb;
	
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
	
	



}
