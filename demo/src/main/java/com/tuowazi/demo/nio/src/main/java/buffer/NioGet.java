package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/19.
 */
public class NioGet {

    public static void main(String[] args) {

        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put(new byte[]{1,2,3,4,5,6});
        System.out.println(buffer);
        //puty也是pos+1
        buffer.put((byte) 7);
        System.out.println(buffer);
        //get相当于pos+1
        buffer.get();
        System.out.println(buffer);


    }
}
