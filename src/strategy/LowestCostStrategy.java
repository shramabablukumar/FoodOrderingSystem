package strategy;

import Model.Restaurant;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class LowestCostStrategy implements SelectionStrategy {

    @Override
    public Restaurant select(List<Restaurant> restaurants,
                             Map<String, Integer> items) {
        return restaurants.stream()
                .min(Comparator.comparing(r -> r.calculateBill(items)))
                .orElse(null);
    }


}
