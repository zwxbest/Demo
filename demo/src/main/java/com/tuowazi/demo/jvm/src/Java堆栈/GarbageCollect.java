package com.tuowazi.demo.jvm.src.Java堆栈;

/**
 * Created by zwxbest on 2018/6/15.
 */
public class GarbageCollect {

    public void localVarGC1()
    {
        byte[] a=new byte[6*1024*1024];
        System.gc();
    }
    public void localVarGC2()
    {
        byte[] a=new byte[6*1024*1024];
        a=null;
        System.gc();
    }

    /**
     * a虽然过了作用域，但还占着坑，没回收
     */
    public void localVarGC3()
    {
        {
            byte[] a=new byte[6*1024*1024];
        }
        System.gc();
    }
    //c把a的坑抢到，把a挤走了，可以回收
    public void localVarGC4()
    {
        {
            byte[] a=new byte[6*1024*1024];
        }
        int c=10;
        System.gc();
    }

    public void localVarGC5()
    {
      localVarGC1();
        System.gc();
    }

    public static void main(String[] args) {
        GarbageCollect gc=new GarbageCollect();
//        gc.localVarGC1();
//        gc.localVarGC2();
//        gc.localVarGC3();
//        gc.localVarGC4();
        gc.localVarGC5();
    }

}
