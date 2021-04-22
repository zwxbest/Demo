package com.tuowazi.demo.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 二项分布-你卖三明治，70% 的人买鸡肉三明治，其他的买猪肉。 所以下 10个顾客里有 0、1、2、3、4、5、6、7、8、9、10个顾客会买鸡肉的概率
 */
public class BinomialDist {


    public static void main(String[] args) {

        double p = 0.7d;
        int n = 10;


        List<Double> allChances = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            //单个成功的概率

            double succChance = Math.pow(p, i) * Math.pow((1 - p), n - i);
            System.out.println(String.format("%d个顾客中有%d个买鸡肉汉堡，单个实验成功的概率:%s", n, i, succChance));

            int totalHappens = factor(n) / (factor(i) * factor(n - i));
            double chance = totalHappens * succChance;
            allChances.add(chance);
            System.out.println(String.format("%d个顾客中有%d个买鸡肉汉堡,概率:%%%s", n, i, (int) (chance * 100)));
            System.out.println();
        }

        double sum = 0d;
        for (Double chance : allChances) {
            sum += chance;
        }
        System.out.println("总概率是" + sum);

    }

    private static int factor(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factor(n - 1);
    }
}
