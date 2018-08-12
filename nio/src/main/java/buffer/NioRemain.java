package buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class NioRemain {

    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        System.out.println(buffer);
        buffer.flip();
        int bufferSize=buffer.remaining();
        for(int i=0;i<bufferSize;i++)
        {
            System.out.println((char) buffer.get());
        }
    }
}
