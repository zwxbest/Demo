package stream;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class MultiGroupBy {
    public static void main(String[] args) {
        Map<Dish.Type, Map<Dish.Type, List<Dish>>> dishesByTypeCaloricLevel =
                Dish.menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return Dish.Type.FISH;
                                    else if (dish.getCalories() <= 700) return Dish.Type.OTHER;
                                    else return Dish.Type.MEAT;
                                } )
                        )
                );
    }
}
