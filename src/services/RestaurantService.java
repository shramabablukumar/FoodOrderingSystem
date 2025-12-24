package services;

import Model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant r) {
        restaurants.add(r);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
