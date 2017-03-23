package tn.esprit.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.entities.Client;
import tn.esprit.entities.User;
import tn.esprit.services.UserServiceLocal;


@ManagedBean
@SessionScoped
public class ClientBean {

	public ClientBean() {
	}
	
	@EJB
	private UserServiceLocal ejb;
	
	private Client client = new Client(); 
	private List<User> clients;
	
	
	@PostConstruct
	public void init(){
		client = new Client();
		clients = ejb.findAll();
	}


	

	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}




	public List<User> getClients() {
		return clients;
	}




	public void setClients(List<User> clients) {
		this.clients = clients;
	}




	public UserServiceLocal getEjb() {
		return ejb;
	}
	
	

	public void create(){
		
		
		ejb.create(client);
		init();
	}
}
