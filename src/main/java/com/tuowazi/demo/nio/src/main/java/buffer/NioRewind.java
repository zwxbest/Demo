package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 * 重读已经被flip过的缓冲区的内容
 */
public class NioRewind {

    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        System.out.println(buffer);
        //相比flip，pos都是为0，但是rewind的lim不变。
        buffer.rewind();
        System.out.println(buffer);
        System.out.println((char) buffer.get());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
    }
}
