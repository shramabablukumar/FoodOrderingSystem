# Food Ordering System

## Description
An **Online Food Ordering System** implemented in Java using in-memory data structures.  
This system allows users to place orders from multiple restaurants based on **selection strategies** such as **Lowest Cost** or **Highest Rating**.  
The system is fully functional without any database and demonstrates core object-oriented design, separation of concerns, and pluggable strategies.

---

## Features
- Onboard new restaurants with a menu and rating.
- Update restaurant menu (addition only, no deletion).
- Track maximum concurrent orders per restaurant.
- Place orders with multiple items.
- Automatic order assignment based on:
  - Lowest total bill cost.
  - Highest restaurant rating.
- Mark orders as **COMPLETED** to free up restaurant capacity.
- Proper exception handling for unavailable restaurants or items.
- Fully in-memory (no database required).

---

## Technologies
- Java 21
- Maven (for dependency management)
- JUnit 5 (for unit testing)
- In-memory data structures (HashMap, List)

---

## Project Structure
food-ordering-system/
│
├─ src/
│ ├─ main/
│ │ └─ java/
│ │ └─ com/
│ │ └─ foodordering/
│ │ ├─ model/ # Entities: User, Restaurant, Order, MenuItem
│ │ ├─ services/ # Business logic: OrderService, RestaurantService
│ │ ├─ strategy/ # Selection strategies: LowestCost, HighestRating
│ │ ├─ exceptions/ # Custom exceptions
│ │ └─ FoodOrderingApplication.java # Main driver class
│
├─ .gitignore
├─ pom.xml
└─ README.md

