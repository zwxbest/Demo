/**
 * Created by zwxbest on 2018/6/10.
 * 代码块
 * 1.如果多个构造函数都要初始化变量，可以用构造块，减少定义方法再调用的麻烦
 * 2.创建对象A之前需要确认B是否在，不再B则创建B再创建A，可在A内用构造块
 */
public class CodeBlock {
    {

        System.out.println("执行构造代码块");
    }
    public CodeBlock()
    {
        System.out.println("执行无参构造函数");
    }

    //虽然用了this，并不会执行两次构造代码块
    public CodeBlock(String str)
    {
        this(str,null);
        System.out.println("执行有参构造函数1");
    }
    public CodeBlock(String str1,String str2)
    {

        System.out.println("执行有参构造函数2");
    }


    public static void main(String[] args) {
        CodeBlock codeBlock1=new CodeBlock();
        CodeBlock codeBlock2=new CodeBlock("str");
    }





}
