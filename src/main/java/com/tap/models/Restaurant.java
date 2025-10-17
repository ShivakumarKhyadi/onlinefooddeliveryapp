package com.tap.models;

public class Restaurant {
	
	private int restaurantID;
	private String name;
	private String address;
	private String phone;
	private int rating;
	private String cusineType;
	private String isActive;
	private String eta;
	private int adminUserID;
	private String imagePath;
	
	public Restaurant(String name, String address, String phone, int rating, String cusineType, String isActive,
			String eta, int adminUserID, String imagePath) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cusineType = cusineType;
		this.isActive = isActive;
		this.eta = eta;
		this.adminUserID = adminUserID;
		this.imagePath = imagePath;
	}

	public Restaurant() {
		super();
	
	}
	
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCusineType() {
		return cusineType;
	}
	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public int getAdminUserID() {
		return adminUserID;
	}
	public void setAdminUserID(int adminUserID) {
		this.adminUserID = adminUserID;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	public Restaurant(int restaurantID, String name, String address, String phone, int rating, String cusineType,
			String isActive, String eta, int adminUserID, String imagePath) {
		super();
		this.restaurantID = restaurantID;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cusineType = cusineType;
		this.isActive = isActive;
		this.eta = eta;
		this.adminUserID = adminUserID;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantID=" + restaurantID + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", rating=" + rating + ", cusineType=" + cusineType + ", isActive=" + isActive + ", eta="
				+ eta + ", adminUserID=" + adminUserID + ", imagePath=" + imagePath + "]";
	}
	
}
