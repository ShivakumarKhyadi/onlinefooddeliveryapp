package com.tap.Servelets;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.tap.DAOImpl.Customer_orderDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.models.Cart;
import com.tap.models.CartItem;
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

@WebServlet("/checkout")
public class ChechoutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Customer_order orders;
	private Customer_orderDAOImpl odi;
	private OrderItem ordersItem;
	private OrderItemDAOImpl oidi; 
	
	@Override
	public void init() throws ServletException {
		try {
			odi = new Customer_orderDAOImpl();
			orders= new Customer_order();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");

		if(user==null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

		if(user!=null && cart != null && !cart.getItems().isEmpty()) {

			//ORDERS TABLE
			String paymentMode = request.getParameter("paymentMode");
			String address = request.getParameter("address");

			orders.setUserID(user.getUserdID());
			orders.setRestaurantID((int) session.getAttribute("restaurantId"));
			//orders.setOrderDate(new Timestamp(new Date().getTime()).toString());
			orders.setOrderDate(new Timestamp(new Date().getTime()));
			orders.setStatus("preparing");

			int totalAmount=0;
			for(CartItem item: cart.getItems().values()) {
				totalAmount+=item.getQuantity()*item.getPrice();
			}

			orders.setTotalAmount(totalAmount);
			orders.setPaymentMode(paymentMode);
			orders.setAddress(address);

			int orderId = odi.addCustomer_order(orders);

			//ORDERSITEM TABLE
			for(CartItem item: cart.getItems().values()) {

				int itemId = item.getId();
				int quantity = item.getQuantity();
				int totalPrice = (item.getQuantity()*item.getPrice());


				ordersItem = new OrderItem(orderId, itemId, quantity, totalPrice);

				oidi = new OrderItemDAOImpl();
				oidi.addOrderItem(ordersItem);


			}
			
			/* int od = orders.getOrderId(); */

			/* session.removeAttribute("cart"); */
			session.setAttribute("orders", orders);
			session.setAttribute("ordersItem", ordersItem);
			/* session.setAttribute("od", od); */

//			response.sendRedirect("orders.jsp");
//			response.sendRedirect("PaymentProcessServlet");
			
			RequestDispatcher rd = request.getRequestDispatcher("orders.jsp");
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("cart.jsp");
		}

	}
}

