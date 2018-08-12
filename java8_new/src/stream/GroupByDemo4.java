package stream;

import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class GroupByDemo4 {

    public static void main(String[] args) {
        Map<Dish.Type, Integer> totalCaloriesByType =
                Dish.menu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));

    }
}
