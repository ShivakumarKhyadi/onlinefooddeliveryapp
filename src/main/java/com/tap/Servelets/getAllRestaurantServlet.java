package com.tap.Servelets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.models.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAllRestaurantServlet")
public class getAllRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public getAllRestaurantServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RestaurantDAOImpl rdi = new RestaurantDAOImpl();
		List<Restaurant> restList = rdi.getAllRestaurant();
		
		request.setAttribute("restList", restList);
		RequestDispatcher rd = request.getRequestDispatcher("restaurant.jsp");
		
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
