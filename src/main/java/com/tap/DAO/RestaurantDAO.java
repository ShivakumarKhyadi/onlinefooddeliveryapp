package com.tap.DAO;

import java.util.List;

import com.tap.models.Restaurant;

public interface RestaurantDAO {
	
	void addRestaurant(Restaurant restaurant);
	int updateRestaurant(Restaurant restaurant);
	int deleteRestaurant(int id);
	Restaurant getRestaurant(int id);
	List<Restaurant> getAllRestaurant();
}
