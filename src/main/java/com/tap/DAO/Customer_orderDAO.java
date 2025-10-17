package com.tap.DAO;

import java.util.List;

import com.tap.models.Customer_order;

public interface Customer_orderDAO {
	
	int addCustomer_order(Customer_order customerorder);
	int updateCustomer_order(Customer_order customerorder);
	int deleteCustomer_order(int id);
	Customer_order getCustomer_order(int id);
	List<Customer_order> getAllCustomer_order();
}
