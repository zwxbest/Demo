package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamAdvanced {

    public static void main(String...args){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In","In", "Action","Java8");
        Map<String,Long> result=names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(result);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);
    }
}