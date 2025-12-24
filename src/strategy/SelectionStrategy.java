package strategy;

import Model.Restaurant;
import java.util.*;

public interface SelectionStrategy {
    Restaurant select(List<Restaurant> restaurants,
                      Map<String, Integer> items);
}