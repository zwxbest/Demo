package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.CharBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class BufferDuplicate {

    //共享数据元素，但是每个缓冲区拥有各自的pos，lim，mark
    public static void main(String[] args) {

        CharBuffer charBuffer=CharBuffer.allocate(8);
        charBuffer.put("let go".toCharArray());
        charBuffer.position(3).limit(6).mark().position(5);
        System.out.println(charBuffer);
        CharBuffer dupCharBuffer=charBuffer.duplicate();
        dupCharBuffer.clear();
        System.out.println(dupCharBuffer);


    }
}
