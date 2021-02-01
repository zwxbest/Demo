package com.tuowazi.demo.jvm.src.Java堆栈;

/**
 * 局部变量表槽位复用
 * Created by zwxbest on 2018/6/15.
 */
public class CycleInStack {

    public void localVar1()
    {
        int a=0;
        System.out.println(a);
        int b=0;
    }
    public void localVar2()
    {
        {
            int a=0;
            System.out.println(a);
        }
        int b=0;

    }
}
