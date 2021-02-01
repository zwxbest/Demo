package com.tuowazi.demo.concurrent.src.base;

/**
 * Created by zwxbest on 2018/8/29.
 */
public class TheadWithException {

   static Exception exception=new Exception("aa");
    public static void main(String[] args) throws Exception{
      aa();
    }

    public static  void aa() throws Exception
    {
        exception=new Exception("bb");
        new Thread(()->{
            exception.printStackTrace();
            throw new RuntimeException("111");
        }).start();
    }
}
