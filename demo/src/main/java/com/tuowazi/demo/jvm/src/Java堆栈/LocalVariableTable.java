package com.tuowazi.demo.jvm.src.Java堆栈;

/**
 * 局部变量表
 */
public class LocalVariableTable {

    private static int count=0;
    public static void recursion(long a,long b,long c)
    {
        long e=1,f=2,g=3,h=4,i=5,k=6;
        count++;
        recursion(a,b,c);
    }

    public static void recursion()
    {
        count++;
        recursion();
    }

    //-Xss128K
    public static void main(String[] args) {
        try {
//            recursion();
            recursion(0L,0L,0L);
        }
        catch (Throwable e)
        {
            System.out.println("deep of calling "+count);
//            e.printStackTrace();
        }

    }
}
