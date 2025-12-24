package Model;
import java.util.*;

public class Restaurant {
    private String name;
    private double rating;
    private int maxOrders;
    private int currentOrders = 0;
    private Map<String, MenuItem> menu = new HashMap<>();

    public Restaurant(String name, int maxOrders, double rating) {
        this.name = name;
        this.maxOrders = maxOrders;
        this.rating = rating;
    }

    public String getName() { return name; }
    public double getRating() { return rating; }
    public int getCurrentOrders() { return currentOrders; }
    public int getMaxOrders() { return maxOrders; }

    public void addMenuItem(String item, double price) {
        menu.put(item, new MenuItem(item, price));
    }

    public void updateMenuItem(String item, double price) {
        if (!menu.containsKey(item))
            throw new IllegalArgumentException("Item not present");
        menu.get(item).setPrice(price);
    }

    public boolean canFulfill(Map<String, Integer> items) {
        return menu.keySet().containsAll(items.keySet())
                && currentOrders < maxOrders;
    }

    public double calculateBill(Map<String, Integer> items) {
        double total = 0;
        for (String item : items.keySet()) {
            total += menu.get(item).getPrice() * items.get(item);
        }
        return total;
    }

    public void acceptOrder() {
        currentOrders++;
    }

    public void completeOrder() {
        currentOrders--;
    }
}