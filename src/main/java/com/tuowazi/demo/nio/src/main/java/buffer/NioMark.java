package com.tuowazi.demo.nio.src.main.java.buffer;

import javax.sound.midi.Soundbank;
import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class NioMark {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        buffer.position(2).mark().position(4);
        System.out.println(buffer);
        buffer.reset();
        System.out.println(buffer);
    }
}
