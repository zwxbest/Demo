package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class NioGet2 {

    public static void main(String[] args) {

        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put(new byte[]{1,2,3,4,5,6});
        buffer.flip();
        byte[] byteArray=new byte[10];
        buffer.get(byteArray,0,buffer.remaining());
        for(int i=0;i<byteArray.length;i++)
        {
            System.out.println(byteArray[i]);
        }
    }
}
