package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 * 比较的是[pos,lim)区域，所以需要flip
 */
public class NioEquals {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        buffer1.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');
        ByteBuffer buffer2 = ByteBuffer.allocate(10);
        buffer2.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');
        ByteBuffer buffer3 = ByteBuffer.allocate(10);
        buffer3.put((byte) 'H').put((byte) 'f').put((byte) 'l').put((byte) 'l').put((byte) 'o');
        buffer1.flip();
        buffer2.flip();
        buffer3.flip();
        System.out.println(buffer1.equals(buffer2));
        System.out.println(buffer1.compareTo(buffer2));
        System.out.println(buffer1.compareTo(buffer3));
        System.out.println(buffer3.compareTo(buffer1));

    }
}
