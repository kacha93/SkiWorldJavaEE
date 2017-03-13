package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Restaurant;

@Remote
public interface RestaurantServiceRemote {
	public interface RestaurantServiceLocal {
		public void AddRestaurant(Restaurant r);
		 public void UpdateRestaurant(Restaurant r);
		 public void DeleteRestaurant(Restaurant r);
		 public List<Restaurant> findAll();
		 public Restaurant findById(Integer id);
		 public List<Restaurant> findByName(String name);
	}

}
