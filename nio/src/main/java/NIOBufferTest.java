import java.nio.CharBuffer;

/**
 * Created by zwxbest on 2018/6/1.
 */
public class NIOBufferTest {

    public static void main(String[] args) {
        //创建buffer
        CharBuffer buff=CharBuffer.allocate(8);
        System.out.println("capacity: "+buff.capacity());
        System.out.println("limit: "+buff.limit()+"，position: "+buff.position());
        //放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("limit: "+buff.limit()+"，position: "+buff.position());
        //相对put方法
        buff.put(new char[]{'d','e'});
        System.out.println("limit: "+buff.limit()+"，position: "+buff.position());
        System.out.println(buff.array());
        buff.put(new char[]{'f','g'},1,1);//看源码，加入'g'
        System.out.println(buff.array());
        buff.put(2,'z');//把index为2的c替换掉了
        System.out.println("limit: "+buff.limit()+"，position: "+buff.position());
        System.out.println(buff.array());

//        System.out.println("加入三个元素后，postion="+buff.position());
//        //调用flip方法
//        buff.flip();
//        System.out.println("执行flip()之后,limit = "+buff.limit());
//        System.out.println("position: "+buff.position());
//        //去除第一个元素
//        System.out.println("第一个元素(position=0): "+buff.get());
//        System.out.println("position = "+buff.position());
//       //调用rewind方法
//        buff.rewind();
//        System.out.println("调用rewind()方法后，limit="+buff.limit());
//        System.out.println("postion= "+buff.position());
//        //调用clear
//        buff.clear();
//        System.out.println("调用clear()之后limit="+buff.limit());
//        System.out.println("postion="+buff.position());


    }
}
