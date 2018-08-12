package buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 * Get和Put可以是相对的，也可以是绝对的
 * 超过上下界都会抛异常
 */
public class NioPutGet {

    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        System.out.println(buffer);
        buffer.put(0,(byte)'M');
    }
}
