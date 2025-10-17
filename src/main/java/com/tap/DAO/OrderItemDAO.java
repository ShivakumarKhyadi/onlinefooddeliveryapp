package com.tap.DAO;

import java.util.List;

import com.tap.models.OrderItem;

public interface OrderItemDAO {
	
	void addOrderItem(OrderItem orderItem);
	int updateOrderItem(OrderItem orderItem);
	int deleteOrderItem(int id);
	OrderItem getOrderItem(int id);
	List<OrderItem> getAllOrderItem();
}
