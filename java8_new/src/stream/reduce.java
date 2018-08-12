package stream;

import javafx.scene.media.SubtitleTrack;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by zwxbest on 2018/7/30.
 */
public class reduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //第一个参数0为初始种子
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        Optional<Integer> sum1 = numbers.stream().reduce((a, b) -> (a + b));
        System.out.println(sum1.get());
    }
}
