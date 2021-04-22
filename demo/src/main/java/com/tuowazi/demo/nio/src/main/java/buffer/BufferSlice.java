package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.CharBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class BufferSlice {

    public static void main(String[] args) {

        CharBuffer charBuffer=CharBuffer.allocate(8);
        charBuffer.put("let go".toCharArray());
//        charBuffer.position(3).limit(6).mark().position(5);
        System.out.println(charBuffer.limit());
        System.out.println(charBuffer.position());
        CharBuffer sliceCharBuffer=charBuffer.slice();
        //也是共享数据
        //但是是pos=0，limit=origin_limit-pos
        System.out.println(sliceCharBuffer.limit());
        System.out.println(sliceCharBuffer.position());

    }
}
