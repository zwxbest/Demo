package com.tuowazi.demo.advice.src.main.java;

/**
 * Created by zwxbest on 2018/7/16.
 */
public class CodeBlock_Super {
    static {
        System.out.println("执行CodeBlock_Super的static{}");
    }
    {

        System.out.println("执行CodeBlock_Super的{}");
    }
    public CodeBlock_Super()
    {
        System.out.println("执行CodeBlock_Super()");
    }

    //虽然用了this，并不会执行两次构造代码块
    public CodeBlock_Super(String str)
    {
        this(str,null);
        System.out.println("执行CodeBlock_Super(String)");
    }
    public CodeBlock_Super(String str1, String str2)
    {

        System.out.println("执行CodeBlock_Super(String,String)");
    }
}
