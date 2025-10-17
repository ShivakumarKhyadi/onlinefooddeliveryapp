package com.tap.models;

import java.sql.Timestamp;

public class User {
	
	private int userdID;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String role;
	private Timestamp createdDate;
	private Timestamp lastLoginDate;
	
	
	public User(String name, String username, String password, String email, String phone, String address,
			String role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}
	public int getUserdID() {
		return userdID;
	}
	public void setUserdID(int userdID) {
		this.userdID = userdID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phone = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	
	public User(int userdID, String name, String username, String password, String email, String phone,
			String address, String role, Timestamp createdDate, Timestamp lastLoginDate) {
		super();
		this.userdID = userdID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}
	
	public User() {
		
	}
	
	public User(int userdID, String name, String username, String password, String email, String phone,
			String address, String role) {
		super();
		this.userdID = userdID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}
	

	@Override
	public String toString() {
		return "User [userdID=" + userdID + ", name=" + name + ", userName=" + username + ", password=" + password
				+ ", email=" + email + ", phoneNumber=" + phone + ", address=" + address + ", role=" + role
				+ ", createdDate=" + createdDate + ", lastLoginDate=" + lastLoginDate + "]";
	}
}
