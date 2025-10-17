package com.tap.models;

import java.sql.Timestamp;

public class Customer_order {
	
	private int orderID;
	private int userID;
	private int restaurantID;
	private Timestamp orderDate;
	private int totalAmount;
	private String status;
	private String paymentMode;
	private String address;
	
	public Customer_order() {
		
	}

	public Customer_order(int userID, int restaurantID,int totalAmount, String status,
			String paymentMode,String address) {
		super();
		this.userID = userID;
		this.restaurantID = restaurantID;
		//this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
		this.address = address;
	}

	public Customer_order(int orderID, int userID, int restaurantID, Timestamp orderDate, int totalAmount, String status,
			String paymentMode,String address) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.restaurantID = restaurantID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
		this.address = address;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "Customer_order [orderID=" + orderID + ", userID=" + userID + ", restaurantID=" + restaurantID
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMode="
				+ paymentMode + ", address=" + address + "]";
	}
	
}
