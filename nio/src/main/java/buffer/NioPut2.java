package buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class NioPut2 {

    public static void main(String[] args) {
        byte[] byteArray=new byte[]{1,2,3,4,5,6,7,8,9,10,11};
        ByteBuffer buffer=ByteBuffer.allocate(10);
        //超过大小会抛异常的
//        buffer.put(byteArray);
        buffer.put(byteArray,0,buffer.remaining());
        buffer.flip();
        while (buffer.hasRemaining())
        {
            System.out.print(buffer.get()+" ");
        }
    }
}
