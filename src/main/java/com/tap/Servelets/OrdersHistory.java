package com.tap.Servelets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImpl.Customer_orderDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.models.Customer_order;
import com.tap.models.OrderItem;
import com.tap.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OrdersHistory")
public class OrdersHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userId=user.getUserdID();
		
		Customer_orderDAOImpl odi = new Customer_orderDAOImpl();
		 List<Customer_order> odList = odi.getAllOrdersByUserId(userId);
		 		
		OrderItemDAOImpl oidi = new OrderItemDAOImpl();
		 List<OrderItem> odiList = oidi.getAllOrdersItemByUserId(userId);
		 
		 request.setAttribute("odList", odList);
		 request.setAttribute("odiList", odiList);
		 

	
		RequestDispatcher rd = request.getRequestDispatcher("ordersHistory.jsp");
		
		rd.forward(request, response);
	}

}
