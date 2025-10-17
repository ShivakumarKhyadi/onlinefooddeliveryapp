package com.tap.Servelets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.models.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet("/menu")
public class getAllMenuByRestaurantID extends HttpServlet {
	   
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		MenuDAOImpl mdi = new MenuDAOImpl();
		
		List<Menu> menuList = mdi.getAllMenuByRestaurantID(restaurantId);
		
		req.setAttribute("menuList", menuList);
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
	}

}

