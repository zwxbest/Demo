package com.tuowazi.demo.sort.src;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//      Bubble.com.nizouba.sort(new int[]{1,6,5,3,4});
//      SimpleSelect.Sort(new int[]{1,6,5,3,4});
        int[] array=new int[]{50,10,90,30,70,40,80,60,20};
        QuickSort.Sort(array);
        Arrays.stream(array).forEach(System.out::println);

    }


}
