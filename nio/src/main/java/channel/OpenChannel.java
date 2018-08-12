package channel;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by zwxbest on 2018/7/17.
 */
public class OpenChannel {

    public static void main(String[] args) throws Exception {
        SocketChannel sc=SocketChannel.open();
        sc.connect(new InetSocketAddress("127.0.0.1",8080));
        ServerSocketChannel ssc=ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(80));
        DatagramChannel datagramChannel=DatagramChannel.open();
        RandomAccessFile randomAccessFile=new RandomAccessFile("file","r");
        FileChannel fileChannel = randomAccessFile.getChannel();



    }
}
