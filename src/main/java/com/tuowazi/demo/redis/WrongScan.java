package com.tuowazi.demo.redis;

import com.tuowazi.demo.common.Tuple2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * java 实现redis的scan 命令，直接遍历的方式
 */
public class WrongScan {

    private Pool pool;

    public WrongScan(Pool pool) {
        this.pool = pool;
    }

    public Tuple2<Integer, List<String>> scan(int cursor, int limit) {
        List<String> res = new ArrayList<>();
        List<String> keys = pool.getKeys();
        if (cursor >= keys.size()) {
            return new Tuple2<>(0, res);
        }
        int i = cursor;
        int count = 0;
        for (; i < keys.size(); i++) {
            if(count >= limit){
                break;
            }
            res.add(keys.get(i));
            count++;
        }
        return new Tuple2<>(i, res);
    }

    static class Test {
        //如果没有缩容或者扩容是没有问题的
        public static void main(String[] args) {
            Pool pool = new Pool();
            pool.add("1", "1");
            pool.add("2", "2");
            pool.add("3", "3");
            pool.add("4", "4");

            WrongScan scan = new WrongScan(pool);
            Tuple2<Integer, List<String>> res = scan.scan(0, 1);
            while (res.getA() != 0){
                System.out.println(res);
                res = scan.scan(res.getA(), 1);
            }
        }
    }

    static class Test2 {
        //假如遍历的过程扩容了
        public static void main(String[] args) {
            Pool pool = new Pool();
            pool.add("1", "1");
            pool.add("2", "2");
            pool.add("3", "3");
            pool.add("4", "4");

            WrongScan scan = new WrongScan(pool);
            Tuple2<Integer, List<String>> res = scan.scan(0, 1);
            int index = 0;
            while (res.getA() != 0){
                if(index == 2){
                    //插入一个，模拟hash，在1和2中间插入
                    pool.add(1,"1.5","1.5");
                }
                System.out.println(res);
                res = scan.scan(res.getA(), 1);
                index ++;
            }
        }
    }
}
