package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/30.
 * 如何扩展前一个例子，只返回总和能被3整除的数对呢？例如(2, 4)和(3, 3)是可以的。
 */
public class FlatMapStream2 {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i ->
                                numbers2.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
    }
}
