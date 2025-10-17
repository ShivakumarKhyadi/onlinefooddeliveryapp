package com.tap.Servelets;

import java.io.IOException;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.models.Cart;
import com.tap.models.CartItem;
import com.tap.models.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServelet extends HttpServlet {
	
	private static final long serialVersionUID = -3860998832952027740L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart =(Cart) session.getAttribute("cart");



//		int newRestaurantId = Integer.parseInt(req.getParameter("restaurantId"));
//		Integer currentRestaurantId =(Integer) session.getAttribute("restaurantId");
//
//		if(cart==null || newRestaurantId != currentRestaurantId ) {
//			cart=new Cart();
//			session.setAttribute("cart", cart);
//			session.setAttribute("restaurantId", newRestaurantId);
//		}
		
		
		
		 String restaurantIdParam = req.getParameter("restaurantId");
	        if (restaurantIdParam != null) {
	            int newRestaurantId = Integer.parseInt(restaurantIdParam);
	            Integer currentRestaurantId = (Integer) session.getAttribute("restaurantId");

	            if (cart == null || newRestaurantId != currentRestaurantId) {
	                cart = new Cart();
	                session.setAttribute("cart", cart);
	                session.setAttribute("restaurantId", newRestaurantId);
	            }
	        }
		
		String action = req.getParameter("action");
		
		if(action.equals("add")) {
			addItemToCart(req,cart);
		}
		else if(action.equals("update")) {
			updateCartItem(req,cart);
		}
		else if(action.equals("remove")) {
			deleteItemFromCart(req,cart);
		}
		

		//		if(restaurantIdParam !=null) {
		//			int newRestaurantId=Integer.parseInt(restaurantIdParam);
		//			
		//			if(currentRestaurantId == null || !currentRestaurantId.equals(newRestaurantId)) {
		//				cart=new Cart();
		//				session.setAttribute("cart", cart);
		//				session.setAttribute("restaurantId", newRestaurantId);
		//			}
		//		}
		
		
		resp.sendRedirect("cart.jsp");


	}
	private void addItemToCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAOImpl mdi = new MenuDAOImpl();
		Menu menu = mdi.getMenu(itemId);
//		System.out.println(menu);
		
		if(menu !=null) {
			CartItem item = new CartItem(
					menu.getMenuID(),
					menu.getItemName(),
					menu.getPrice(),
					quantity
					);
			cart.addCartItem(item);;
		}
		
		
	}


	private void updateCartItem(HttpServletRequest req, Cart cart) {
			int itemId = Integer.parseInt(req.getParameter("itemId"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			cart.updateCartItem(itemId, quantity);;
	
	}
	
	

	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		cart.deleteCartItem(itemId);
		
		
	}

}