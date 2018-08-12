package buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by zwxbest on 2018/7/17.
 * 数据元素视图，例如byteBuffer.getInt()
 */
public class DataElementView {

    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.wrap(new byte[]{1,2,3,4,5,6});
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.order(ByteOrder.BIG_ENDIAN).getInt());
        byteBuffer.clear();
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getInt());
    }
}
