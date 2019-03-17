/**
 * Created by zwxbest on 2018/6/10.
 * 1. 先执行父static{}，再执行子staic{}
 * 2.再执行Super{},Super()
 * 再执行{} CodeBlock（）
 * 1.如果多个构造函数都要初始化变量，可以用构造块，减少定义方法再调用的麻烦
 * 2.如果在A（）中调用A（String），{}只会执行一次
 * 3.静态构造代码块在new的时候也会执行，但只会执行一次，第二次不会执行了。
 */
public class CodeBlock extends CodeBlock_Super {

//    执行CodeBlock_Super的static{}
//    执行static{}
//    执行CodeBlock_Super的{}
//    执行CodeBlock_Super()
//    执行{}
//    执行CodeBlock（）
//    执行CodeBlock_Super的{}
//    执行CodeBlock_Super()
//    执行{}
//    执行CodeBlock(String,String)
//    执行CodeBlock(String)

    static {
        System.out.println("执行static{}");
    }
    {

        System.out.println("执行{}");
    }
    public CodeBlock()
    {
        System.out.println("执行CodeBlock（）");
    }

    //虽然用了this，并不会执行两次构造代码块
    public CodeBlock(String str)
    {
        this(str,null);
        System.out.println("执行CodeBlock(String)");
    }
    public CodeBlock(String str1,String str2)
    {

        System.out.println("执行CodeBlock(String,String)");
    }


    public static void main(String[] args) {
        CodeBlock codeBlock1=new CodeBlock();
        CodeBlock codeBlock2=new CodeBlock("str");
    }


}
