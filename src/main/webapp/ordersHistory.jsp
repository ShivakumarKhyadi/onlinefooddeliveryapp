<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.models.Customer_order" %>
<%@ page import="com.tap.models.OrderItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Orders History </title>
    <link href="https://fonts.cdnfonts.com/css/kobo" rel="stylesheet">
	<link rel="stylesheet" href="CSS/ordersHistory.css">
</head>
<body>
	<nav>
        <a href="getAllRestaurantServlet" class="Logo">FoodExpress</a>
        <div class="nav-Links">
            <a href="getAllRestaurantServlet">Home</a>
	<!-- 		<a href="cart?action=show">Cart</a> -->
            <a href="profile.jsp">Profile</a>
        </div>
    </nav>
    <div class="container">
        <div class="header">
            <h1>Orders History</h1>
            <p>Track all your previous orders</p>
        </div>
        <div class="content">
            <%
                List<Customer_order> odList = (List<Customer_order>) request.getAttribute("odList");
                List<OrderItem> odiList = (List<OrderItem>) request.getAttribute("odiList");
                if (odList != null && !odList.isEmpty()) {
                    for (Customer_order order : odList) {
            %>
                        <div class="order-card">
                            <div class="order-header">
                                <div class="order-id">Order #<%= order.getOrderID() %></div>
                                <div class="order-status status">
                                    Delivered
                                </div>
                            </div>
                            <div class="order-details">
                                <div class="detail-group">
                                    <div class="detail-label">Order Date</div>
                                    <div class="detail-value">
                                        <%= order.getOrderDate() != null ? order.getOrderDate() : "N/A" %>
                                    </div>
                                </div>
                                <div class="detail-group">
                                    <div class="detail-label">Restaurant ID</div>
                                    <div class="detail-value"><%= order.getRestaurantID() %></div>
                                </div>
                                <div class="detail-group">
                                    <div class="detail-label">User ID</div>
                                    <div class="detail-value"><%= order.getUserID() %></div>
                                </div>
                                <div class="detail-group">
                                    <div class="detail-label">Sub Amount</div>
                                    <div class="detail-value total-amount">₹<%= order.getTotalAmount() %></div>
                                </div>
                                <div class="detail-group">
                                    <div class="detail-label">Total Amount</div>
                                    <div class="detail-value total-amount">₹<%= order.getTotalAmount() + 40%></div>
                                </div>
                                <div class="detail-group">
                                    <div class="detail-label">Payment Mode</div>
                                    <div class="detail-value"><%= order.getPaymentMode() != null ? order.getPaymentMode() : "N/A" %></div>
                                </div>
                                <div class="detail-group">
                                    <div class="detail-label">Delivery Address</div>
                                    <div class="detail-value"><%= order.getAddress() != null ? order.getAddress() : "N/A" %></div>
                                </div>
                            </div>
                            <%
                                boolean hasItems = false;
                                if (odiList != null) {
                                    for (OrderItem item : odiList) {
                                        if (item.getOrderID() == order.getOrderID()) {
                                            if (!hasItems) {
                                                hasItems = true;
                            %>
                                                <div class="items-section">
                                                    <div class="items-header">Order Items</div>
                                                    <table class="items-table">
                                                        <thead>
                                                            <tr>
                                                                <th>Item ID</th>
                                                                <th>Menu ID</th>
                                                                <th>Quantity</th>
                                                                <th>Total Price</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                            <%
                                            }
                            %>
                                                            <tr>
                                                                <td><%= item.getOrderItemID() %></td>
                                                                <td><%= item.getMenuID() %></td>
                                                                <td><%= item.getQuantity() %></td>
                                                                <td class="price">₹<%= item.getTotalPrice() %></td>
                                                            </tr>
                            <%
                                        }
                                    }
                                    if (hasItems) {
                            %>
                                                        </tbody>
                                                    </table>
                                                </div>
                            <%
                                    }
                                }
                                if (!hasItems) {
                            %>
                                    <div class="items-section">
                                        <div class="items-header">Order Items</div>
                                        <div style="padding: 20px; text-align: center; color: #6c757d;">
                                            No items found for this order
                                        </div>
                                    </div>
                            <%
                                }
                            %>
                        </div>
            <%
                    }
                } else {
            %>
                    <div class="no-orders">
                        <h2>No Orders Found</h2>
                        <p>You haven't placed any orders yet.</p>
                        <a href="menu.jsp" class="back-btn">Browse Menu</a>
                    </div>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>