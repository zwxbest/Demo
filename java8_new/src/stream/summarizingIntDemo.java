package stream;

import java.util.IntSummaryStatistics;

import static java.util.stream.Collectors.summarizingInt;

/**
 * Created by zwxbest on 2018/7/31.
 */
public class summarizingIntDemo {

    public static void main(String[] args) {
        IntSummaryStatistics menuStatistics =
                Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
        menuStatistics.getAverage();
        menuStatistics.getMax();
    }
}
