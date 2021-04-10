package com.tuowazi.demo.generic.wipeout;

import java.util.ArrayList;
import java.util.List;

public class WipeOut {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();

        System.out.println(strList.getClass() == integerList.getClass());
    }
}
