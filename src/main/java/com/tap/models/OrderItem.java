package com.tap.models;

public class OrderItem {
	
	private int orderItemID;
	private int orderID;
	private int menuID;
	private int quantity;
	private int totalPrice;
	public OrderItem() {
		super();
		
	}
	
	public OrderItem(int orderID, int menuID, int quantity, int totalPrice) {
		super();
		this.orderID = orderID;
		this.menuID = menuID;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public OrderItem(int orderItemID, int orderID, int menuID, int quantity, int totalPrice) {
		super();
		this.orderItemID = orderItemID;
		this.orderID = orderID;
		this.menuID = menuID;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getOrderItemID() {
		return orderItemID;
	}

	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemID=" + orderItemID + ", orderID=" + orderID + ", menuID=" + menuID + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "]";
	}
}
