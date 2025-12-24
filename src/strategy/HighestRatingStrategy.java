package strategy;

import Model.Restaurant;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class HighestRatingStrategy implements SelectionStrategy {

    @Override
    public Restaurant select(List<Restaurant> restaurants,
                             Map<String, Integer> items) {
        return restaurants.stream()
                .max(Comparator.comparing(Restaurant::getRating))
                .orElse(null);
    }


}