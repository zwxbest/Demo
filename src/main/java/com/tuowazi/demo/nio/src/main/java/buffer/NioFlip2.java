package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 * 翻转两次会变成什么样子
 */
public class NioFlip2 {

    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        System.out.println(buffer);
        //将添加元素的状态翻转成准备读取元素的状态
        //pos为0，limit变成pos
        buffer.flip();
        System.out.println(buffer);
        buffer.flip();
        System.out.println(buffer);
//        System.out.println((char) buffer.get());
//        System.out.println((char)buffer.get());
//        System.out.println((char)buffer.get());
    }
}
