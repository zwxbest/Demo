package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class NioFlip {

    /**
     * 读和写都是从postion开始，所以读的时候postion设置为0，之前写的postion用limit保存
     * 写的时候用limit还原pos，limit赋值为capacity。
     * @param args
     */
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        System.out.println(buffer);
//        buffer.limit(buffer.position()).position(0);
        //将添加元素的状态翻转成准备读取元素的状态
        buffer.flip();
        System.out.println(buffer);
        System.out.println((char) buffer.get());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());

    }
}
