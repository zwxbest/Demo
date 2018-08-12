package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/29.
 */
public class MapStream {
    public static void main(String[] args) {
        //好像getName第一个参数算是this
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(toList());
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        List<Integer> dishNameLengths = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
    }
}
