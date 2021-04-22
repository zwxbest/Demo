package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 * clear和flip都是pos设置为0，也就是可以覆盖写，
 * 区别是flip的limit是原pos，clear的limit为capacity
 */
public class NioClear {

    public static void main(String[] args) {

        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        System.out.println(buffer);
        buffer.clear();
        System.out.println(buffer);
    }
}
