package com.tap;

import java.util.List;
import java.util.Scanner;

import com.tap.DAOImpl.Customer_orderDAOImpl;
import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.DAOImpl.OrderItemDAOImpl;
import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.DAOImpl.UserDAOImpl;
import com.tap.models.Customer_order;
import com.tap.models.Menu;
import com.tap.models.OrderItem;
import com.tap.models.Restaurant;
import com.tap.models.User;

public class Launch {
	static Scanner sc;

	public static void main(String[] args) {
		
		customer_OrderOperations();
		//menuOperations();
		//orderItemOperations();
		//restaurantOperations() ;
		//userOperations();
		
	}
	
	private static void customer_OrderOperations() {
		sc = new Scanner(System.in);

		while (true) {

			System.out.println("Choooose the Following:");

			System.out.println("1.Add Menu");

			System.out.println("2.Update Menu");

			System.out.println("3.Delete Menu");

			System.out.println("4.Get Menu");

			System.out.println("5.GetAll Menu");

			System.out.println("6.Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1: addCustomer_order(); break;

			case 2: updateCustomer_order(); break;

			case 3: deleteCustomer_order(); break;

			case 4: getCustomer_order(); break;

			case 5: getAllCustomer_order(); break;

			default: System.exit(0); break;

			}

		}
	}
	
	private static void menuOperations() {
		sc = new Scanner(System.in);

		while (true) {

			System.out.println("Choooose the Following:");

			System.out.println("1.Add Menu");

			System.out.println("2.Update Menu");

			System.out.println("3.Delete Menu");

			System.out.println("4.Get Menu");

			System.out.println("5.GetAll Menu");

			System.out.println("6.Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1: addMenu(); break;

			case 2: updateMenu(); break;

			case 3: deleteMenu(); break;

			case 4: getMenu(); break;

			case 5: getAllMenu(); break;

			default: System.exit(0); break;

			}

		}
	}
		
	private static void orderItemOperations() {
		sc = new Scanner(System.in);

		while (true) {

			System.out.println("Choooose the Following:");

			System.out.println("1.Add OrderItem");

			System.out.println("2.Update OrderItem");

			System.out.println("3.Delete OrderItem");

			System.out.println("4.Get OrderItem");

			System.out.println("5.GetAll OrderItem");

			System.out.println("6.Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1: addOrderItem(); break;

			case 2: updateOrderItem(); break;

			case 3: deleteOrderItem(); break;

			case 4: getOrderItem(); break;

			case 5: getAllOrderItem(); break;

			default: System.exit(0); break;

			}

		}
	}
	
	private static void userOperations() {
		sc = new Scanner(System.in);

		while (true) {

			System.out.println("Choooose the Following:");

			System.out.println("1.Add User");

			System.out.println("2.Update User");

			System.out.println("3.Delete User");

			System.out.println("4.Get User");

			System.out.println("5.GetAll User");

			System.out.println("6.Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1: addUser(); break;

			case 2: updateUser(); break;

			case 3: deleteUser(); break;

			case 4: getUser(); break;

			case 5: getAllUser(); break;

			default: System.exit(0); break;

			}

		}
	}
	
	private static void restaurantOperations() {
		sc = new Scanner(System.in);

		while (true) {

			System.out.println("Choooose the Following:");

			System.out.println("1.Add Restaurant");

			System.out.println("2.Update Restaurant");

			System.out.println("3.Delete Restaurant");

			System.out.println("4.Get Restaurant");

			System.out.println("5.GetAll Restaurant");

			System.out.println("6.Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1: addRestaurant(); break;

			case 2: updateRestaurant(); break;

			case 3: deleteRestaurant(); break;

			case 4: getRestaurant(); break;

			case 5: getAllRestaurant(); break;

			default: System.exit(0); break;

			}

		}
	}
	
	//all add methods of customer_order,menu,orderitem,restaurant,user
	private static void addCustomer_order() {
		//System.out.println("Enter the Order Id:");
		//int orderID = sc.nextInt();
		System.out.println("Enter the User Id:");
		int userID = sc.nextInt();
		System.out.println("Enter the Restaurant Id:");
		int restaurantID = sc.nextInt();
		System.out.println("Enter the orderDate");
		String orderDate = sc.next();
		System.out.println("Enter the totalAmount");
		int totalAmount = sc.nextInt();
		System.out.println("Enter the status");
		String status = sc.next();
		System.out.println("Enter the paymentMode");
		String paymentMode = sc.next();
		System.out.println("Enter the address");
		String address = sc.next();
		
		Customer_order customer_order = new Customer_order(userID, restaurantID, totalAmount, status, paymentMode,address);
		Customer_orderDAOImpl cdi = new Customer_orderDAOImpl();
		cdi.addCustomer_order(customer_order);
		System.out.println(customer_order);
	}
	
	private static void addMenu() {
		//System.out.println("Enter the Menu Id:");
		//int menuID = sc.nextInt();
		System.out.println("Enter the Restaurant Id:");
		int restaurantID = sc.nextInt();
		System.out.println("Enter the ItemName:");
		String itemName = sc.next();
		System.out.println("Enter the Description:");
		String description = sc.next();
		System.out.println("Enter the menu price:");
		int price = sc.nextInt();
		System.out.println("Enter the menu rating:");
		int rating = sc.nextInt();
		System.out.println("Enter the menu isAvailable");
		String isAvailable = sc.next();
		System.out.println("Enter the Restaurant imagePath:");
		String imagePath = sc.next();
		
		Menu menu = new Menu(restaurantID, itemName, description, price, rating, isAvailable, imagePath);
		MenuDAOImpl mdi = new MenuDAOImpl();
		mdi.addMenu(menu);
		System.out.println(menu);
	}
	
	private static void addOrderItem(){
		//System.out.println("Enter the OrderItem Id:");

		//int orderItemID = sc.nextInt();
		
		System.out.println("Enter the Order Id:");

		int orderID = sc.nextInt();
		System.out.println("Enter the Menu Id:");

		int menuID = sc.nextInt();
		
		System.out.println("Enter the Quantity");
		int quantity = sc.nextInt();
		System.out.println("Enter the TotalPrice");
		int totalPrice = sc.nextInt();
		
		OrderItem orderItem = new OrderItem(orderID, menuID, quantity, totalPrice);
		OrderItemDAOImpl odi = new OrderItemDAOImpl();
		odi.addOrderItem(orderItem);
		System.out.println(orderItem);
	}
	private static void addRestaurant(){
		//System.out.println("Enter the Restaurant Id:");
		//int restaurantID = sc.nextInt();
		System.out.println("Enter the Restaurant Name:");
		String name = sc.next();	
		System.out.println("Enter the Restaurant Address:");

		String address = sc.next();
		
		System.out.println("Enter the Restaurant Phone No:");

		String phone = sc.next();
		
		System.out.println("Enter the Restaurant Rating:");

		int rating = sc.nextInt();
		
		System.out.println("Enter the Restaurant cusineType:");

		String cusineType = sc.next();
		
		System.out.println("Enter the Restaurant isActive:");

		String isActive = sc.next();
		
		System.out.println("Enter the Restaurant eta:");

		String eta = sc.next();

		System.out.println("Enter the Restaurant adminUserID:");

		int adminUserID = sc.nextInt();
		
		System.out.println("Enter the Restaurant imagePath:");

		String imagePath = sc.next();
		
		Restaurant restaurant = new Restaurant(name, address, phone,rating, cusineType,isActive, eta, adminUserID, imagePath);
		
		RestaurantDAOImpl rdi = new RestaurantDAOImpl();
		
		rdi.addRestaurant(restaurant);
		System.out.println(restaurant);
	}
	
	private static void addUser() {
		//System.out.println("Enter the User Id:");

		//int userld = sc.nextInt();

		System.out.println("Enter the Name:");

		String name = sc.next();

		System.out.println("Enter the User-Name:");

		String username = sc.next();

		System.out.println("Enter the Password:");

		String password = sc.next();

		System.out.println("Enter the Email:");

		String email = sc.next();

		System.out.println("Enter the Phone No:");

		String phoneNumber = sc.next();

		System.out.println("Enter the Address:");

		String address = sc.next();

		System.out.println("Enter the role:");

		String role = sc.next();

		User user=new User(name, username, password, email, phoneNumber, address, role);

		UserDAOImpl udi = new UserDAOImpl();

		udi.addUser(user);

		System.out.println(user);
	}
	
	//update methods of customerorder,menu,orderitem,restaurant,user
	private static void updateCustomer_order() {
		System.out.println("Enter the ID to Update detatils:");
		int id = sc.nextInt();
		Customer_orderDAOImpl cdi = new Customer_orderDAOImpl();
		Customer_order customer_order = cdi.getCustomer_order(id);
		System.out.println("We are Updating: \n Enter the value:");
		String value = sc.next();
		customer_order.setStatus(value);
		int res = cdi.updateCustomer_order(customer_order);
		if(res==1) {
			System.out.println("Succesful");
		}
		else {
			System.out.println("Failed");
		}
	}
	
	private static void updateMenu() {
		System.out.println("Enter the ID to Update detatils:");
		int id = sc.nextInt();
		MenuDAOImpl mdi = new MenuDAOImpl();
		Menu menu = mdi.getMenu(id);
		System.out.println("We are Updating: \n Enter the value:");
		String value = sc.next();
		menu.setIsAvailable(value);
		int res = mdi.updateMenu(menu);
		if(res==1) {
			System.out.println("Succesful");
		}
		else {
			System.out.println("Failed");
		}

	}
	
	private static void updateOrderItem() {
		System.out.println("Enter the ID to Update detatils:");
		int id = sc.nextInt();
		OrderItemDAOImpl odi = new OrderItemDAOImpl();
		OrderItem orderItem = odi.getOrderItem(id);
		System.out.println("We are Updating: \n Enter the value:");
		String value = sc.next();
		orderItem.setTotalPrice(id);
		
		int res = odi.updateOrderItem(orderItem);
		if(res==1) {
			System.out.println("Succesful");
		}
		else {
			System.out.println("Failed");
		}
	}
	
	private static void updateRestaurant() {
		System.out.println("Enter the ID to Update detatils:");
		int id = sc.nextInt();
		
		RestaurantDAOImpl rdi = new RestaurantDAOImpl();
		Restaurant restaurant = rdi.getRestaurant(id);
		System.out.println("We are Updating: \n Enter the value:");
		String value = sc.next();
		restaurant.setName(value);;
		
		int res = rdi.updateRestaurant(restaurant);
		if(res==1) {
			System.out.println("Succesful");
		}
		else {
			System.out.println("Failed");
		}
	}
	private static void updateUser() {
		System.out.println("Enter the ID to Update detatils:");
		int id = sc.nextInt();
		
		UserDAOImpl udi = new UserDAOImpl();
		User user = udi.getUser(id);
		System.out.println("We are Updating: \n Enter the value:");
		String value = sc.next();
		user.setName(value);
		
		int res = udi.updateUser(user);
		if(res==1) {
			System.out.println("Succesful");
		}
		else {
			System.out.println("Failed");
		}
	}
	
	//here all delete methods of customer_order,menu,orderitem,restaurant,user
	private static void  deleteCustomer_order() {
		System.out.println("Enter the ID which Customer_order data want to delete: ");
		int id = sc.nextInt();
		Customer_orderDAOImpl cdi = new Customer_orderDAOImpl();
		int res = cdi.deleteCustomer_order(id);
		if(res==1) {
			System.out.println("Menu data deleted Successfully");
		}
		else {
			System.out.println("Menu data is not deleted");
		}
	}
	
	private static void deleteMenu() {
		System.out.println("Enter the ID which Menu data want to delete: ");
		int id = sc.nextInt();
		MenuDAOImpl mdi = new MenuDAOImpl();
		int res = mdi.deleteMenu(id);
		if(res==1) {
			System.out.println("Menu data deleted Successfully");
		}
		else {
			System.out.println("Menu data is not deleted");
		}
	}
	
	private static void deleteOrderItem(){
		System.out.println("Enter the ID which OrderItem data want to delete: ");
		int id = sc.nextInt();
		OrderItemDAOImpl odi = new OrderItemDAOImpl();
		int res = odi.deleteOrderItem(id);
		if(res==1) {
			System.out.println("OrderItem data deleted Successfully");
		}
		else {
			System.out.println("OrderItem data is not deleted");
		}
	}
	
	private static void deleteRestaurant() {
		System.out.println("Enter the ID which restaurant data want to delete: ");
		int id = sc.nextInt();
		RestaurantDAOImpl rdi = new RestaurantDAOImpl();
		int res = rdi.deleteRestaurant(id);
		if(res==1) {
			System.out.println("Restaurant data deleted Successfully");
		}
		else {
			System.out.println("Restaurant data is not deleted");
		}
	}
	
	private static void deleteUser() {
		System.out.println("Enter the ID which user data want to delete: ");
		int id = sc.nextInt();
		
		UserDAOImpl udi = new UserDAOImpl();
		int res = udi.deleteUser(id);
		
		if(res==1) {
			System.out.println("User data deleted Successfully");
		}
		else {
			System.out.println("User data is not deleted");
		}
	}
	
	//get methods of customer_order,menu,orderitem,restaurant,user
	private static void getCustomer_order() {
		System.out.println("Enter the ID to get Customer_order details: ");
		int id = sc.nextInt();
		Customer_orderDAOImpl cdi = new Customer_orderDAOImpl();
		Customer_order customer_order = cdi.getCustomer_order(id);
		System.out.println(customer_order);
	}
	
	private static void getMenu() {
		System.out.println("Enter the ID to get menu details: ");
		int id = sc.nextInt();
		MenuDAOImpl mdi = new MenuDAOImpl();
		Menu menu = mdi.getMenu(id);
		System.out.println(menu);
	}
	
	private static void getOrderItem(){
		System.out.println("Enter the ID to get OrderItem details: ");
		int id = sc.nextInt();
		OrderItemDAOImpl odi = new OrderItemDAOImpl();
		OrderItem orderItem = odi.getOrderItem(id);
		System.out.println(orderItem);
	}
	
	private static void getRestaurant() {
		System.out.println("Enter the ID to get Restaurant details: ");
		int id = sc.nextInt();
		RestaurantDAOImpl rdi = new RestaurantDAOImpl();
		Restaurant restaurant = rdi.getRestaurant(id);
		System.out.println(restaurant);
	}
	
	private static void getUser() {
		System.out.println("Enter the ID to get User details: ");
		int id = sc.nextInt();
		
		UserDAOImpl udi = new UserDAOImpl();
		User user = udi.getUser(id);
		System.out.println(user);
	}
	
	//getAlldetails of main java files
	
	private static void getAllCustomer_order() {
		Customer_orderDAOImpl cdi = new Customer_orderDAOImpl();
		List<Customer_order>list = cdi.getAllCustomer_order();
		for(Customer_order customer_order:list) {
			System.out.println(customer_order);
		}
	}
	
	private static void getAllMenu() {
		MenuDAOImpl mdi = new MenuDAOImpl();
		List<Menu>list = mdi.getAllMenu();
		for(Menu menu:list) {
			System.out.println(menu);
		}
	}
	
	private static void  getAllOrderItem() {
		OrderItemDAOImpl odi = new OrderItemDAOImpl();
		List<OrderItem>list = odi.getAllOrderItem();
		for(OrderItem orderItem:list) {
			System.out.println(orderItem);
		}
	} 
	
	private static void getAllRestaurant() {
		RestaurantDAOImpl rdi = new RestaurantDAOImpl();
		List<Restaurant>list = rdi.getAllRestaurant();
		for(Restaurant restaurant:list) {
			System.out.println(restaurant);
		}
	}
	
	private static void getAllUser() {
		UserDAOImpl udi = new UserDAOImpl();
		List<User>list = udi.getAllUsers();
		
		for(User user : list) {
			System.out.println(user);
		}
	}
	
}
