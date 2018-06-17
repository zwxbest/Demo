package 类加载;

/**
 * Created by zwxbest on 2018/6/17.
 * 针对Final字段，直接把常量池的引用放到main中
 */
public class FinalFieldClassLoader {
    public static class  FinalClass
    {
        public static final String constStr="FINAL";
        static {
            System.out.println("init");
        }
    }

    public static class  UseFinalField
    {
        public static void main(String[] args) {
            System.out.println(FinalClass.constStr);
        }
    }

}
