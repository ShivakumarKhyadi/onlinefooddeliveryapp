package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.models.Menu;
import com.tap.util.DBconnection;

public class MenuDAOImpl implements MenuDAO{
	
	int res=0;
	private String INSERT = "INSERT into `menu`(`restaurantID`,`itemName`,`description`,`price`,`rating`,`isAvailable`,`imagePath`) values(?,?,?,?,?,?,?)";
	private String GET_MENU = "SELECT * FROM `menu` WHERE `menuID` = ?";
	private String DELETE_MENU = "DELETE FROM `menu` WHERE `menuID` = ?";
	private String GET_ALL_MENU = "SELECT * FROM `menu`";
	private String UPDATE_MENU = "UPDATE `menu` SET restaurantID=?,itemName=?,description=?,price=?,isAvailable=?,imagePath=? WHERE `menuID` = ?";
	Connection con = DBconnection.getConnection();
	private String GET_ALL_MENU_BYRESTAURANT_ID = "SELECT * FROM `menu` WHERE `restaurantID` = ?";
	@Override
	public void addMenu(Menu menu) {
		
		try {
			PreparedStatement pstmt= con.prepareStatement(INSERT);
		//	pstmt.setInt(1, menu.getMenuID());
			pstmt.setInt(1, menu.getRestaurantID());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setInt(4, menu.getPrice());
			pstmt.setInt(5, menu.getRating());
			pstmt.setString(6, menu.getIsAvailable());
			pstmt.setString(7, menu.getImagePath());
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public int updateMenu(Menu menu) {
		int res = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_MENU);
			pstmt.setInt(1, menu.getMenuID());
			pstmt.setInt(2, menu.getRestaurantID());
			pstmt.setString(3, menu.getItemName());
			pstmt.setString(4, menu.getDescription());
			pstmt.setInt(5, menu.getPrice());
			pstmt.setInt(6, menu.getRating());
			pstmt.setString(7, menu.getIsAvailable());
			pstmt.setString(8, menu.getImagePath());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int deleteMenu(int id) {
		int res=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_MENU);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Menu getMenu(int id) {
		Menu menu = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_MENU);
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int menuID = res.getInt("menuID");
				int restaurantID = res.getInt("restaurantID");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				int price = res.getInt("price");
				int rating = res.getInt("rating");
				String isAvailable = res.getString("isAvailable");
				String imagePath = res.getString("imagePath");
				
				menu = new Menu(menuID, restaurantID, itemName, description, price, rating, isAvailable, imagePath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public List<Menu> getAllMenu() {
		Menu menu = null;
		ArrayList<Menu>list = new ArrayList<Menu>();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(GET_ALL_MENU);
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				int menuID = res.getInt("menuID");
				int restaurantID = res.getInt("restaurantID");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				int price = res.getInt("price");
				int rating = res.getInt("rating");
				String isAvailable = res.getString("isAvailable");
				String imagePath = res.getString("imagePath");
				
				menu = new Menu(menuID, restaurantID, itemName, description, price, rating, isAvailable, imagePath);
				list.add(menu);

		} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
							
		return list;
	}

	@Override
	public List<Menu> getAllMenuByRestaurantID(int id) {
		
		Menu menu = null;
		ArrayList<Menu>list = new ArrayList<Menu>();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(GET_ALL_MENU_BYRESTAURANT_ID );
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				int menuID = res.getInt("menuID");
				int restaurantID = res.getInt("restaurantID");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				int price = res.getInt("price");
				int rating = res.getInt("rating");
				String isAvailable = res.getString("isAvailable");
				String imagePath = res.getString("imagePath");
				
				menu = new Menu(menuID, restaurantID, itemName, description, price, rating, isAvailable, imagePath);
				list.add(menu);

		} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
							
		return list;
	}
	
}
