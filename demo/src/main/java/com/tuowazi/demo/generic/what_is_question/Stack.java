package com.tuowazi.demo.generic.what_is_question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by zwxbest on 2018/3/15.
 * Java 泛型: 什么是PECS
 */
public  class  Stack<E>{
    public Stack(){}
    public void push(E e){}
    public E pop(){return null;}
    public boolean isEmpty(){return false;}
//    Iterable<E > src;//not suitable
    public void pushAll(Iterable<? extends  E > src){
        for(E e : src)
            push(e);
    }

//    解决的办法就是使用Collection<? super E>。这里的objects是消费者，因为是添加元素到objects集合中去。
//    使用Collection<? super E>后，无论objects是什么类型的集合，满足一点的是他是E的超类，所以不管这个参数化类型具体是什么类型都能将E装进objects集合中去。
    public void popAll(Collection<? super  E> dst){
        if(!isEmpty()){
            dst.add(pop());
        }
    }

    public static void main(String[] args)
    {
//        Stack<Number> numberStack = new Stack<Number>();
//        Iterable<Integer> integers = new ArrayList<Integer>();
//        //        这样就可以正确编译了，这里的<? extends E>就是所谓的 producer-extends。这里的Iterable就是生产者，要使用<? extends E>。
////        因为Iterable<? extends E>可以容纳任何E的子类。在执行操作时，可迭代对象的每个元素都可以当作是E来操作。
//        numberStack.pushAll(integers);
//
//        Stack<Number> numberStack2 = new Stack<Number>();
//        Collection<Object> objects = new ArrayList<>();
//        numberStack.popAll(objects);

        List<Integer> a=new ArrayList<>();
        List<String> str=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<?> b=a;
        b=str;
        List c=str;//
//        b.add(new Object());
        for (Object obj:b)
        {
            System.out.println(obj);
        }
    }

}