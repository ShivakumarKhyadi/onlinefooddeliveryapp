<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.DAOImpl.RestaurantDAOImpl" %>
<%@ page import="com.tap.models.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodExpress - Discover Culinary Excellence</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@400;700;900&display=swap" rel="stylesheet">
      	<link rel="stylesheet" href="CSS/restaurant.css">
</head>
<body>
    <nav>
        <a href="getAllRestaurantServlet" class="Logo">FoodExpress</a>
        <div class="nav-Links">
            <a href="getAllRestaurantServlet">🏠 Home</a>
            <a href="OrdersHistory">📦 Orders</a>
            <a href="profile.jsp">👤 Profile</a>
        </div>
    </nav>
    
    <div class="hero-section">
        <h1>Explore Amazing Restaurants</h1>
        <p class="hero-subtitle">Discover culinary excellence at your fingertips</p>
        
        <div class="search-container">
            <input type="text" class="search-bar" placeholder="Search for restaurants, cuisines, or dishes..." autocomplete="off">
            <button class="search-btn">Search</button>
        </div>
    </div>
    
    <div class="grid-container">
        <%
            List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restList");
            
            if (restaurants != null && !restaurants.isEmpty()) {
                int cardIndex = 0;
                for (Restaurant restaurant : restaurants) {
                    cardIndex++;
        %>
            <a href="menu?restaurantId=<%= restaurant.getRestaurantID() %>">
                <div class="restaurant-card">
                    <div class="image-container">
                        <img src="<%= restaurant.getImagePath() %>" alt="<%= restaurant.getName() %> Restaurant" class="restaurant-image" loading="lazy">
                        <div class="image-badges">
                            <% if (cardIndex <= 3) { %>
                                <div class="badge trending">🔥 Trending</div>
                            <% } %>
                            <% if (cardIndex == 1 || cardIndex == 5) { %>
                                <div class="badge new">✨ New</div>
                            <% } %>
                        </div>
                    </div>
                    <div class="restaurant-details">
                        <div class="restaurant-name"><%= restaurant.getName() %></div>
                        <div class="restaurant-location"><%= restaurant.getAddress() %></div>
                        <div class="restaurant-stats">
                            <div class="stat-badge rating"><%= restaurant.getRating() %> / 5</div>
                            <div class="stat-badge cuisine"><%= restaurant.getCusineType() %></div>
                        </div>
                    </div>
                </div>
            </a>
        <%
                }
            } else {
        %>
            <div class="no-restaurants-message">
                <h2>🍽️ No Restaurants Available</h2>
                <p>We're currently updating our restaurant listings. Please check back shortly!</p>
                <p>In the meantime, why not explore our featured dishes or check out our blog for food inspiration?</p>
            </div>
        <%
            }
        %>
    </div>

    <script>
        // Enhanced Interactive Experience
        document.addEventListener('DOMContentLoaded', function() {
            // Advanced search functionality with debounce
            const searchBar = document.querySelector('.search-bar');
            const searchBtn = document.querySelector('.search-btn');
            let searchTimeout;
            
            function performSearch() {
                const query = searchBar.value.trim();
                if (query) {
                    // Add visual feedback
                    searchBtn.style.transform = 'translateY(-50%) scale(0.95)';
                    setTimeout(() => {
                        searchBtn.style.transform = 'translateY(-50%) scale(1.05)';
                    }, 100);
                    
                    console.log('Searching for:', query);
                    // Implement actual search functionality here
                }
            }
            
            searchBtn.addEventListener('click', performSearch);
            
            searchBar.addEventListener('keypress', function(e) {
                if (e.key === 'Enter') {
                    e.preventDefault();
                    performSearch();
                }
            });
            
            // Real-time search with debounce
            searchBar.addEventListener('input', function() {
                clearTimeout(searchTimeout);
                searchTimeout = setTimeout(() => {
                    const query = this.value.trim();
                    if (query.length > 2) {
                        // Add subtle glow to indicate live search
                        this.style.boxShadow = '0 0 0 2px rgba(50, 205, 50, 0.3), 0 0 20px rgba(50, 205, 50, 0.2)';
                        setTimeout(() => {
                            this.style.boxShadow = '';
                        }, 1000);
                    }
                }, 300);
            });
            
            // Enhanced card interactions
            const cards = document.querySelectorAll('.restaurant-card');
            
            cards.forEach(card => {
                let hoverTimeout;
                
                card.addEventListener('mouseenter', function() {
                    clearTimeout(hoverTimeout);
                    this.style.zIndex = '10';
                });
                
                card.addEventListener('mouseleave', function() {
                    hoverTimeout = setTimeout(() => {
                        this.style.zIndex = '1';
                    }, 300);
                });
                
                // Add touch support for mobile
                card.addEventListener('touchstart', function() {
                    this.classList.add('touch-active');
                });
                
                card.addEventListener('touchend', function() {
                    setTimeout(() => {
                        this.classList.remove('touch-active');
                    }, 200);
                });
            });
            
            // Smooth reveal animation with Intersection Observer
            const observerOptions = {
                threshold: 0.1,
                rootMargin: '0px 0px -50px 0px'
            };
            
            const cardObserver = new IntersectionObserver((entries) => {
                entries.forEach(entry => {
                    if (entry.isIntersecting) {
                        entry.target.style.animationPlayState = 'running';
                        cardObserver.unobserve(entry.target);
                    }
                });
            }, observerOptions);
            
            cards.forEach(card => {
                card.style.animationPlayState = 'paused';
                cardObserver.observe(card);
            });
            
            // Dynamic background particles
            function createFloatingParticle() {
                const particle = document.createElement('div');
                particle.style.cssText = `
                    position: fixed;
                    width: 4px;
                    height: 4px;
                    background: linear-gradient(45deg, #FF1493, #00BFFF);
                    border-radius: 50%;
                    pointer-events: none;
                    z-index: -1;
                    opacity: 0.6;
                    left: ${Math.random() * 100}vw;
                    top: 100vh;
                    animation: floatUp ${5 + Math.random() * 5}s linear forwards;
                `;
                
                document.body.appendChild(particle);
                
                setTimeout(() => {
                    particle.remove();
                }, 10000);
            }
            
            // Add floating particle animation
            const style = document.createElement('style');
            style.textContent = `
                @keyframes floatUp {
                    to {
                        transform: translateY(-100vh) rotate(360deg);
                        opacity: 0;
                    }
                }
                .touch-active {
                    transform: perspective(1000px) rotateX(5deg) translateY(-10px) scale(1.02) !important;
                }
            `;
            document.head.appendChild(style);
            
            // Create particles periodically
            setInterval(createFloatingParticle, 2000);
            
            // Enhanced keyboard navigation
            document.addEventListener('keydown', function(e) {
                if (e.key === 'Tab') {
                    document.body.classList.add('keyboard-nav');
                }
            });
            
            document.addEventListener('mousedown', function() {
                document.body.classList.remove('keyboard-nav');
            });
            
            // Performance optimization: Lazy load images
            if ('IntersectionObserver' in window) {
                const imageObserver = new IntersectionObserver((entries, observer) => {
                    entries.forEach(entry => {
                        if (entry.isIntersecting) {
                            const img = entry.target;
                            img.src = img.dataset.src || img.src;
                            img.classList.remove('loading-shimmer');
                            observer.unobserve(img);
                        }
                    });
                });
                
                document.querySelectorAll('img').forEach(img => {
                    img.classList.add('loading-shimmer');
                    imageObserver.observe(img);
                });
            }
        });
        
        // Add smooth page transitions
        window.addEventListener('beforeunload', function() {
            document.body.style.opacity = '0';
            document.body.style.transform = 'scale(0.98)';
        });
    </script>
</body>
</html>