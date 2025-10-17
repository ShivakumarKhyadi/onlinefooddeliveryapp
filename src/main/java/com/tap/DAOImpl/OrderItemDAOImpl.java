package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import com.tap.DAO.OrderItemDAO;
import com.tap.models.OrderItem;
import com.tap.util.DBconnection;

public class OrderItemDAOImpl implements OrderItemDAO{
	
	int res = 0;
	private String INSERT = "INSERT into `orderitem`(`orderID`,`menuID`,`quantity`,`totalPrice`)values(?,?,?,?)";
	private String GET_ORDERITEM = "SELECT * FROM `orderitem` WHERE orderItemID=?";
	private String DELETE_ORDERITEM = "DELETE FROM `orderitem` WHERE orderItemID=?";
	private String GET_ALL_ORDERITEM = "SELECT * FROM `orderitem`";
	private String UPDATE_ORDERITEM = "UPDATE `ORDERITEM` SET orderID=?,menuID=?,quantity=?,totalPrice=? WHERE orderItemID=?";
	private String GET_ALL_ORDERSITEM_BY_USER_ID="SELECT oi.* FROM `orderitem` oi INNER JOIN `Customer_order` o ON oi.orderID = o.orderID WHERE o.userID = ?\r\n"
			+ "ORDER BY o.orderDate DESC";
	Connection con = DBconnection.getConnection();
	
	@Override
	public void addOrderItem(OrderItem orderItem) {
		
		try {
			PreparedStatement pstmt= con.prepareStatement(INSERT);
			//pstmt.setInt(1, orderItem.getOrderItemID());
			pstmt.setInt(1, orderItem.getOrderID()); 
			pstmt.setInt(2, orderItem.getMenuID());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setInt(4, orderItem.getTotalPrice());
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updateOrderItem(OrderItem orderItem) {
		int res = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_ORDERITEM);
			pstmt.setInt(1, orderItem.getOrderItemID());
			pstmt.setInt(2, orderItem.getOrderID()); 
			pstmt.setInt(3, orderItem.getMenuID());
			pstmt.setInt(4, orderItem.getQuantity());
			pstmt.setInt(5, orderItem.getTotalPrice());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int deleteOrderItem(int id) {
		int res=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_ORDERITEM);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public OrderItem getOrderItem(int id) {
		OrderItem orderitem = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ORDERITEM);
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int orderItemID = res.getInt("orderItemID");
				int orderID = res.getInt("orderID");
				int menuID = res.getInt("menuID");
				int quantity = res.getInt("quantity");
				int totalPrice = res.getInt("totalPrice");
				
				orderitem = new OrderItem(orderItemID, orderID, menuID, quantity, totalPrice);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderitem;
	}

	@Override
	public List<OrderItem> getAllOrderItem() {
		OrderItem orderitem = null;
		ArrayList<OrderItem>list=new ArrayList<OrderItem>();
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(GET_ALL_ORDERITEM);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int orderItemID = res.getInt("orderItemID");
				int orderID = res.getInt("orderID");
				int menuID = res.getInt("menuID");
				int quantity = res.getInt("quantity");
				int totalPrice = res.getInt("totalPrice");
				
				orderitem = new OrderItem(orderItemID, orderID, menuID, quantity, totalPrice);
				list.add(orderitem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<OrderItem> getAllOrdersItemByUserId(int userId) {
		 List<OrderItem> orderItems = new ArrayList<>();
		    
         PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(GET_ALL_ORDERSITEM_BY_USER_ID);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderItemID(rs.getInt("orderItemId"));
				orderItem.setOrderID(rs.getInt("orderId"));
				orderItem.setMenuID(rs.getInt("menuId"));
				orderItem.setQuantity(rs.getInt("quantity"));
				orderItem.setTotalPrice(rs.getInt("totalPrice"));
				orderItems.add(orderItem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    return orderItems;
	}

}
