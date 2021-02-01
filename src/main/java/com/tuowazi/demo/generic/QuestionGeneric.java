package com.tuowazi.demo.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwxbest on 2018/3/15.
 * 一直对泛型中的？一知半解
 */
public class QuestionGeneric {


    public static void main(String[] args)
    {
        List<? extends Base> list1=new ArrayList<Base>();
//        list1.add(new Base());
//        list1.add(new subClass());
        List<Integer> list2=new ArrayList<>();
        list2.add(11);

    }

}
 class Base
{

}
  class subClass extends Base
{

}
