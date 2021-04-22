package com.tuowazi.demo.advice.src.main.java;

import java.util.Random;

/**
 * Created by zwxbest on 2018/5/24.
 * Random赋值给CONST
 */
public class ConstAndRandom {

  static   final int CONST=new Random().nextInt();
    public static void main(String[] args)
    {
        System.out.println(CONST);
    }
}
