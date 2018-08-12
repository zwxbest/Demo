package stream;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zwxbest on 2018/7/29.
 */
public class DebugStream {

    //不是应该前面两个输出了，发现limit超过3了吗？
    //为什么不输出第四个
    public static void main(String[] args) {
        List<String> names =
                Dish.menu.stream()
                        .filter(d -> {
                            System.out.println("filtering-" + d.getName());
                            return d.getCalories() > 300;
                        })
                        .map(d -> {
                            System.out.println("mapping-" + d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .collect(toList());
        System.out.println(names);
    }
}
