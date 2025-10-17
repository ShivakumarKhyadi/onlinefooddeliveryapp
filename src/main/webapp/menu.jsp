
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.DAOImpl.MenuDAOImpl" %>
<%@ page import="com.tap.models.Menu" %>
<%@ page import="com.tap.models.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodExpress - Menu</title>
 	<link rel="stylesheet" href="CSS/menu.css">
</head>
<body>
    <nav>
        <a href="getAllRestaurantServlet" class="Logo">FoodExpress</a>
        <div class="nav-Links">
            <a href="getAllRestaurantServlet">Home</a>
            <a href="OrdersHistory">Orders</a>
            <a href="cart.jsp">Cart</a>
            <a href="profile.jsp">Profile</a>
        </div>
    </nav>
    
    <a href="getAllRestaurantServlet" class="back-button">Back to Restaurants</a>
    
    <%
        Restaurant restaurant = (Restaurant) request.getAttribute("restaurant");
        if (restaurant != null) {
    %>
    <div class="restaurant-header">
        <h1 class="restaurant-title"><%= restaurant.getName() %></h1>
        <div class="restaurant-info">
            <div class="info-item">
                <span class="info-label">Location</span>
                <span class="info-value">📍 <%= restaurant.getAddress() %></span>
            </div>
            <div class="info-item">
                <span class="info-label">Rating</span>
                <span class="info-value">⭐ <%= restaurant.getRating() %> / 5</span>
            </div>
            <div class="info-item">
                <span class="info-label">Cuisine</span>
                <span class="info-value">🍽 <%= restaurant.getCusineType() %></span>
            </div>
        </div>
    </div>
    <% } %>
    
    <h2 class="section-header">Our Delicious Menu</h2>
    
    <div class="menu-container">
        <%
            List<Menu> menuItems = (List<Menu>) request.getAttribute("menuList");
            
            if (menuItems != null && !menuItems.isEmpty()) {
                for (Menu item : menuItems) {
        %>
            <div class="menu-item-card">
                <img src="<%= item.getImagePath() != null ? item.getImagePath() : "images/default-food.jpg" %>" 
                     alt="<%= item.getItemName() %>" class="menu-image">
                <div class="menu-details">
                    <div>
                        <div class="menu-name"><%= item.getItemName() %></div>
                        <div class="menu-description"><%= item.getDescription() != null ? item.getDescription() : "Delicious item from our kitchen" %></div>
                    </div>
                    <div>
                        <div class="menu-price"><%= item.getPrice() %></div>
                      <form action="cart" method="post">
                            <input type="hidden" name="itemId" value="<%= item.getMenuID() %>">
                            <input type="hidden" name="quantity" value="1">
                            <input type="hidden" name="restaurantId" value="<%= item.getRestaurantID() %>">
                            <input type="hidden" name="action" value="add">
                            <input type="submit" value="Add To Cart">
                        </form>
                    </div>
                </div>
            </div>
        <%
                }
            } else {
        %>
            <div class="no-menu-message">
                <h2>🍽 Menu Coming Soon</h2>
                <p>This restaurant is currently updating their menu. Please check back shortly!</p>
            </div>
        <%
            }
        %>
    </div>

    <script>
        function addToCart(menuId, itemName, price) {
            // Add your cart functionality here
            alert(Added ${itemName} (₹${price}) to cart!);
            
            // You can implement actual cart functionality here
            // For example, making an AJAX call to add item to session cart
            /*
            fetch('addToCart', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    menuId: menuId,
                    quantity: 1
                })
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert(Added ${itemName} to cart!);
                } else {
                    alert('Failed to add item to cart. Please try again.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('An error occurred. Please try again.');
            });
            */
        }
    </script>
</body>
</html>