package stream;

import java.util.Optional;

/**
 * Created by zwxbest on 2018/7/30.
 */
public class findAnyStream {

    public static void main(String[] args) {

                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny()
                        .ifPresent(d -> System.out.println(d.getName()));
    }
}
