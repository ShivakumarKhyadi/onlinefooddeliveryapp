package com.tap.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	private Map<Integer,CartItem> items;
	
	public Map<Integer, CartItem> getItems() {
		return items;
	}

	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}

	public Cart() {
		this.items = new HashMap<>();
	}
	
	public void addCartItem(CartItem cartitem) {
			
		  if (items.containsKey(cartitem.getId())) {
	            // If item already exists, increase quantity
	            CartItem existing = items.get(cartitem.getId());
	            existing.setQuantity(existing.getQuantity() + cartitem.getQuantity() + 1);
	        } else {
	            items.put(cartitem.getId(), cartitem);
	        }
	}
	
	  // 2. Update item
    public void updateCartItem(int id, int newQuantity) {
        if (items.containsKey(id)) {
        	if(newQuantity > 0) {
        		//CartItem cartItem = cart.get(id);
        		//cartItem.setQuantity(newQuantity);
        		items.get(id).setQuantity(newQuantity);
        	}
        	else {
        		items.remove(id);
        	}
        }
    }
    
    // 3. Remove item
    public void deleteCartItem(int id) {
        items.remove(id);
    }
    
    public List<CartItem> getCartItems(){
    	return new ArrayList<>(items.values());
    }
    
    // 4. Show cart contents
    public void showCart() {
        for (CartItem item : items.values()) {
            System.out.println(item.getId() + " - " + item.getName() + " | Price: " + item.getPrice() + " | Quantity: " + item.getQuantity());
        }
    }
    
    // 5. Get total price
    public double getTotalPrice() {
    	double total = 0;
    	for(CartItem cart : items.values()) {
    		total += cart.getPrice() * cart.getQuantity();
    	}
		return total;
    }

}
