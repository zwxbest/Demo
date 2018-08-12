package stream;

/**
 * Created by zwxbest on 2018/7/30.
 * anyMatch 、 allMatch 和 noneMatch 这三个操作都用到了我们所谓的短路
 */

public class noneMatchStream {
    public static void main(String[] args) {
        boolean isHealthy = Dish.menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
    }
}
