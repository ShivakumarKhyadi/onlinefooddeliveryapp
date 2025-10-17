package com.tap.DAO;

import java.util.Map;
import com.tap.models.CartItem;

public interface CartItemDAO {
	
	void addItemtoCart(CartItem cartitem);
	int updateItemtoCart(CartItem cartitem,int quantity);
	int deleteItemtoCart(CartItem cartitem);
	public static Map<Integer, CartItem> items = null;
}
