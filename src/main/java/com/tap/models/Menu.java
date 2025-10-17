package com.tap.models;

public class Menu {
	
	private int menuID;
	private int restaurantID;
	private String itemName;
	private String description;
	private int price;
	private int rating;
	private String isAvailable;
	private String imagePath;
	
	public Menu(int restaurantID, String itemName, String description, int price, int rating, String isAvailable,
			String imagePath) {
		super();
		this.restaurantID = restaurantID;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public Menu() {
		
	}
	
	@Override
	public String toString() {
		return "Menu [menuID=" + menuID + ", restaurantID=" + restaurantID + ", itemName=" + itemName + ", descrption="
				+ description + ", price=" + price + ", rating=" + rating + ", isAvailable=" + isAvailable
				+ ", imagePath=" + imagePath + "]";
	}
	
	public int getMenuID() {
		return menuID;
	}
	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	public Menu(int menuID, int restaurantID, String itemName, String description, int price, int rating,
			String isAvailable, String imagePath) {
		super();
		this.menuID = menuID;
		this.restaurantID = restaurantID;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}
	
}
