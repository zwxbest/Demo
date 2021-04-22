package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.CharBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class BufferReadOnlyDup {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(8);
        charBuffer.put("let go".toCharArray());
        charBuffer.position(3).limit(6).mark().position(5);
        CharBuffer dupCharBuffer = charBuffer.asReadOnlyBuffer();
        //因为是共享数据，且只读，这里会抛出异常
        dupCharBuffer.put('!');

    }
}
