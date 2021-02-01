package com.tuowazi.demo.advice.src.main.java;

import java.text.NumberFormat;

/**
 * Created by zwxbest on 2018/5/24.
 * 不定长参数作为重载
 */
public class OverloadAndArgs {

    public void calPrice(int price,int discount)
    {
        float realPrice=price*discount/100F;
        System.out.println(NumberFormat.getIntegerInstance().format(realPrice/100));
    }

    public void calPrice(int price,int... discounts)
    {
        System.out.println("in ...");
    }
    public static void main(String[] args)
    {
        OverloadAndArgs oa=new OverloadAndArgs();
        oa.calPrice(10,1000000);
    }
}
