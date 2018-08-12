package channel;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zwxbest on 2018/7/17.
 * 一个通道可以是单向的，也可以是双向的
 * 单向的分为read和write。
 */
public class UseChannel {

    public static void main(String[] args) throws Exception{

        ByteBuffer byteBuffer=ByteBuffer.wrap(new byte[]{1,2,3,4,5,6});
        //只读
        FileInputStream inputStream=new FileInputStream("pom.xml");
        FileChannel fileChannel=inputStream.getChannel();
        //因为inputstream是只读的，所以write直接抛出NonWritableChannel的异常
        fileChannel.write(byteBuffer);
    }
}
