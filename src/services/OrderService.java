package services;

import Model.Order;
import Model.Restaurant;
import Model.User;
import exception.OrderCannotBeAssignedException;
import strategy.SelectionStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private Map<String, Order> orders = new HashMap<>();
    private int orderSeq = 1;

    public Order placeOrder(User user,
                            Map<String, Integer> items,
                            SelectionStrategy strategy,
                            List<Restaurant> restaurants) {

        List<Restaurant> eligible = new ArrayList<>();
        for (Restaurant r : restaurants) {
            if (r.canFulfill(items)) eligible.add(r);
        }

        if (eligible.isEmpty())
            throw new OrderCannotBeAssignedException("Cannot assign the order");

        Restaurant selected = strategy.select(eligible, items);
        selected.acceptOrder();

        Order order = new Order("ORD-" + orderSeq++, user, selected, items);
        orders.put(order.getId(), order);

        System.out.println("Order assigned to " + selected.getName());
        return order;
    }

    public void completeOrder(String orderId) {
        orders.get(orderId).markCompleted();
    }
}
