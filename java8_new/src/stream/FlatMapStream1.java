package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/30.
 * 给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
 该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代
 表数对。
 */
public class FlatMapStream1 {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})
                        ).collect(toList());
        System.out.println(pairs);
    }
}
