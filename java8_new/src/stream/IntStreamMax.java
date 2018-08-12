package stream;

import java.util.OptionalInt;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class IntStreamMax {

    public static void main(String[] args) {
        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max=maxCalories.orElse(1);
    }
}
