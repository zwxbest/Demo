package com.tuowazi.demo.nio.src.main.java.buffer;

import java.nio.CharBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class NioWrap {

    public static void main(String[] args) {
        CharBuffer charBuffer=CharBuffer.wrap(new char[]{'l','e','t','g','o'});
        System.out.println(charBuffer.position());
        System.out.println(charBuffer.limit());
        System.out.println(charBuffer.capacity());
        CharBuffer charBuffer2=CharBuffer.wrap(new char[]{'l','e','t','g','o'},1,2);
        //pos=offset
        //limit=offset+length
        //capacity=char[].length
        System.out.println(charBuffer2.position());
        System.out.println(charBuffer2.limit());
        System.out.println(charBuffer2.capacity());



    }
}
