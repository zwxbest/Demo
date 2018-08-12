package buffer;

import java.nio.ByteBuffer;

/**
 * Created by zwxbest on 2018/7/17.
 * 配合flip一起用
 */
public class NioCompact {

    public static void main(String[] args) {

        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        byteBuffer.put(new byte[]{'M','e','l','l','o','w'});
        byteBuffer.flip();
//        byteBuffer.position(2);
        System.out.println(byteBuffer);
        //compact是flip的反向操作，用来写的
        byteBuffer.compact();
        System.out.println(byteBuffer);
//        byteBuffer.flip();
//        System.out.println(byteBuffer);

    }
}
