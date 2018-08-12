package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/29.
 */
public class FlatMapStream {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("Hello","World");
//        List<String[]> collect = words.stream()
//                .map(word -> word.split(""))
//                .distinct()
//                .collect(toList());
//        System.out.println(collect);

//        List<Stream<String>> collect = words.stream()
//                .map(word -> word.split(""))
//                .map(Arrays::stream)
//                .distinct()
//                .collect(toList());

        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(uniqueCharacters);
    }
}
