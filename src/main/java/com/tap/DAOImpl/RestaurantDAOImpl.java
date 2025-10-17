package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.models.Restaurant;
import com.tap.util.DBconnection;

public class RestaurantDAOImpl implements RestaurantDAO{
	
	int res = 0;
	private String INSERT = "INSERT into `restaurant`(`name`,`address`,`phone`,`rating`,`cusineType`,`isActive`,`eta`,`adminUserID`,`imagePath`)values(?,?,?,?,?,?,?,?,?)";
	private String GET_RESTAURANT = "SELECT * FROM `restaurant` WHERE restaurantID=?";
	private String DELETE_RESTAURANT = "DELETE FROM `restaurant` WHERE restaurantID=?";
	private String GET_ALL_RESTAURANT = "SELECT * FROM `restaurant`";
	private String UPDATE_RESTAURANT = "UPDATE `restaurant` SET name=?,address=?,phone=?,rating=?,cusineType=?,isActive=?,eta=?,adminUserID=?,imagePath=? WHERE restaurantID=?";
	Connection con = DBconnection.getConnection();
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		try {
			PreparedStatement pstmt= con.prepareStatement(INSERT);
			//pstmt.setInt(1, restaurant.getRestaurantID());
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhone());
			pstmt.setInt(4, restaurant.getRating());
			pstmt.setString(5, restaurant.getCusineType());
			pstmt.setString(6, restaurant.getIsActive());
			pstmt.setString(7, restaurant.getEta());
			pstmt.setInt(8, restaurant.getAdminUserID());
			pstmt.setString(9, restaurant.getImagePath());
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int updateRestaurant(Restaurant restaurant) {
		int res = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_RESTAURANT);
			pstmt.setInt(1, restaurant.getRestaurantID());
			pstmt.setString(2, restaurant.getName());
			pstmt.setString(3, restaurant.getAddress());
			pstmt.setString(4, restaurant.getPhone());
			pstmt.setInt(5, restaurant.getRating());
			pstmt.setString(6, restaurant.getCusineType());
			pstmt.setString(7, restaurant.getIsActive());
			pstmt.setString(8, restaurant.getEta());
			pstmt.setInt(9, restaurant.getAdminUserID());
			pstmt.setString(10, restaurant.getImagePath());

			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteRestaurant(int id) {
		int res=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_RESTAURANT);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Restaurant getRestaurant(int id) {
		Restaurant restaurant = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_RESTAURANT);
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int restaurantID = res.getInt("restaurantID");
				String name = res.getString("name");
				String address = res.getString("address");
				String phone = res.getString("phone");
				int rating = res.getInt("rating");
				String cusineType = res.getString("cusineType");
				String isActive = res.getString("isActive");
				String eta = res.getString("eta");
				int adminUserID = res.getInt("adminUserID");
				String imagePath = res.getString("imagePath");
				
				restaurant = new Restaurant(restaurantID, name, address, phone, rating, cusineType, isActive, eta, adminUserID, imagePath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		Restaurant restaurant = null;
		ArrayList<Restaurant>list = new ArrayList<Restaurant>();
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(GET_ALL_RESTAURANT);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int restaurantID = res.getInt("restaurantID");
				String name = res.getString("name");
				String address = res.getString("address");
				String phone = res.getString("phone");
				int rating = res.getInt("rating");
				String cusineType = res.getString("cusineType");
				String isActive = res.getString("isActive");
				String eta = res.getString("eta");
				int adminUserID = res.getInt("adminUserID");
				String imagePath = res.getString("imagePath");
				
				restaurant = new Restaurant(restaurantID, name, address, phone, rating, cusineType, isActive, eta, adminUserID, imagePath);
				list.add(restaurant);
		
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
