import Model.Order;
import Model.Restaurant;
import Model.User;
import services.OrderService;
import services.RestaurantService;
import strategy.HighestRatingStrategy;
import strategy.LowestCostStrategy;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FoodOrderingApp {
    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();

        // Onboard Restaurants
        Restaurant r1 = new Restaurant("R1", 5, 4.5);
        r1.addMenuItem("Veg Biryani", 100);
        r1.addMenuItem("Chicken Biryani", 150);

        Restaurant r2 = new Restaurant("R2", 5, 4);
        r2.addMenuItem("Idli", 10);
        r2.addMenuItem("Dosa", 50);
        r2.addMenuItem("Veg Biryani", 80);
        r2.addMenuItem("Chicken Biryani", 175);

        Restaurant r3 = new Restaurant("R3", 1, 4.9);
        r3.addMenuItem("Idli", 15);
        r3.addMenuItem("Dosa", 30);
        r3.addMenuItem("Gobi Manchurian", 150);
        r3.addMenuItem("Chicken Biryani", 175);

        restaurantService.addRestaurant(r1);
        restaurantService.addRestaurant(r2);
        restaurantService.addRestaurant(r3);

        User ashwin = new User("Ashwin");
        User harish = new User("Harish");
        User shruthi = new User("Shruthi");

        Map<String, Integer> items = new HashMap<>();
        items.put("Idli", 3);
        items.put("Dosa", 1);

        Order o1 = orderService.placeOrder(
                ashwin, items,
                new LowestCostStrategy(),
                restaurantService.getRestaurants()
        );

        Order o2 = orderService.placeOrder(
                harish, items,
                new LowestCostStrategy(),
                restaurantService.getRestaurants()
        );

        Map<String, Integer> items2 = new HashMap<>();
        items2.put("Veg Biryani", 3);
        items2.put("Dosa", 1);

        orderService.placeOrder(
                shruthi, items2,
                new HighestRatingStrategy(),
                restaurantService.getRestaurants()
        );

        orderService.completeOrder(o1.getId());

        orderService.placeOrder(
                harish, items,
                new LowestCostStrategy(),
                restaurantService.getRestaurants()
        );
    }
}