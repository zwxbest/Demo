package stream;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class maxColories {

    public static void main(String[] args) {

        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish =
                Dish.menu.stream()
                        .collect(maxBy(dishCaloriesComparator));
    }
}
