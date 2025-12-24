package Model;
import java.util.*;

public class Order {
    private String id;
    private User user;
    private Restaurant restaurant;
    private Map<String, Integer> items;
    private OrderStatus status;

    public Order(String id, User user, Restaurant restaurant,
                 Map<String, Integer> items) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.status = OrderStatus.ACCEPTED;
    }

    public String getId() { return id; }
    public Restaurant getRestaurant() { return restaurant; }
    public OrderStatus getStatus() { return status; }

    public void markCompleted() {
        status = OrderStatus.COMPLETED;
        restaurant.completeOrder();
    }
}