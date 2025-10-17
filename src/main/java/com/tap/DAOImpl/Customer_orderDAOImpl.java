package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.Customer_orderDAO;
import com.tap.models.Customer_order;
import com.tap.util.DBconnection;

public class Customer_orderDAOImpl implements Customer_orderDAO{
	
	int res=0;
	private String INSERT = "INSERT into `customer_order`(`userID`,`restaurantID`,`orderDate`,`totalAmount`,`status`,`paymentMode`,`address`) values(?,?,?,?,?,?,?)";
	private String GET_CUSTOMER_ORDER = "SELECT * FROM `customer_order` WHERE `orderID` = ?";
	private String DELETE_CUSTOMER_ORDER = "DELETE FROM `customer_order` WHERE `orderID` = ?";
	private String GET_ALL_CUSTOMER_ORDER = "SELECT * FROM `customer_order`";
	private String UPDATE_CUSTOMER_ORDER = "UPDATE `customer_order` SET userID=?,restaurantID=?,orderDate=?,totalAmount=?,status=?,paymentMode=?,address=? WHERE `orderID` = ?";
	private String GET_ORDERS_BY_USER_ID="SELECT * FROM `customer_order` WHERE `userId`=?";;
	Connection con = DBconnection.getConnection();
	private int orderID;

	@Override
	public int addCustomer_order(Customer_order customerorder) {
		
		try {
			PreparedStatement pstmt= con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			//pstmt.setInt(1,customerorder.getOrderID());
			pstmt.setInt(1,customerorder.getUserID());
			pstmt.setInt(2,customerorder.getRestaurantID());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4,customerorder.getTotalAmount());
			pstmt.setString(5, customerorder.getStatus());
			pstmt.setString(6, customerorder.getPaymentMode());
			pstmt.setString(7, customerorder.getAddress());
			
			int res = pstmt.executeUpdate();
			
			ResultSet id = pstmt.getGeneratedKeys();
			while(id.next()) {
				 orderID = id.getInt(1);
			}
			
			System.out.println(res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderID;
	}

	@Override
	public int updateCustomer_order(Customer_order customerorder) {
		int res = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_CUSTOMER_ORDER);
			pstmt.setInt(1,customerorder.getOrderID());
			pstmt.setInt(2,customerorder.getUserID());
			pstmt.setInt(3,customerorder.getRestaurantID());
			pstmt.setInt(4,customerorder.getTotalAmount());
			pstmt.setString(5, customerorder.getStatus());
			pstmt.setString(6, customerorder.getPaymentMode());
			pstmt.setString(7, customerorder.getAddress());
			
			res = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteCustomer_order(int id) {
		int res=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_CUSTOMER_ORDER);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Customer_order getCustomer_order(int id) {
		Customer_order customer_order = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_CUSTOMER_ORDER);
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int orderID = res.getInt("orderID");
				int userID = res.getInt("userID");
				int restaurantID = res.getInt("restaurantID");
				Timestamp orderDate = res.getTimestamp("orderDate");
				int totalAmount = res.getInt("totalAmount");
				String status = res.getString("status");
				String paymentMode = res.getString("paymentMode");
				String address = res.getString("address");
				
				customer_order = new Customer_order(orderID, userID, restaurantID, orderDate, totalAmount, status, paymentMode,address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer_order;
	}

	@Override
	public List<Customer_order> getAllCustomer_order() {
		
		Customer_order customer_order = null;
		ArrayList<Customer_order>list = new ArrayList<Customer_order>();
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_CUSTOMER_ORDER);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int orderID = res.getInt("orderID");
				int userID = res.getInt("userID");
				int restaurantID = res.getInt("restaurantID");
				Timestamp orderDate = res.getTimestamp("orderDate");
				int totalAmount = res.getInt("totalAmount");
				String status = res.getString("status");
				String paymentMode = res.getString("paymentMode");
				String address = res.getString("address");
				
				customer_order = new Customer_order(orderID, userID, restaurantID, orderDate, totalAmount, status, paymentMode,address);
				
				list.add(customer_order);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Customer_order> getAllOrdersByUserId(int id) {
		Customer_order customer_order = null;
		// TODO Auto-generated method stub
		ArrayList<Customer_order> list=new ArrayList<Customer_order>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ORDERS_BY_USER_ID);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int orderId=res.getInt("orderId");
				int userId=res.getInt("userId");
				int restaurantId=res.getInt("restaurantId");
				Timestamp orderDate=res.getTimestamp("orderDate");
				int totalAmount=res.getInt("totalAmount");
				String status=res.getString("status");
				String paymentMode=res.getString("paymentMode");
				String address = res.getString("address");
				customer_order = new Customer_order(orderId, userId, restaurantId, orderDate, totalAmount, status, paymentMode,address);
				list.add(customer_order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
