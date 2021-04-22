package com.tuowazi.demo.list;


import com.tuowazi.demo.list.linked.CircularLinkedList;
import com.tuowazi.demo.list.linked.LinkedList;
import com.tuowazi.demo.list.linked.TwoDirCicularLinkedList;
import com.tuowazi.demo.list.linked.TwoDirLinkedList;
import com.tuowazi.demo.list.sequence.CustomArrayList;

public class Main {

    public static void main(String[] args) {
//        Test_CustomArrayList();
//        test_linkedList();
//        test_circular_linkedList();
//        test_twodirLinkedlist();
        test_twoDirCicularLinkedList();
    }


    public static void test_twodirLinkedlist()
    {
        TwoDirLinkedList<Integer> twoDirLinkedList_empty=new TwoDirLinkedList<>();
        System.out.println("empty is "+twoDirLinkedList_empty.toString());
        TwoDirLinkedList<Integer> twoDirLinkedList=new TwoDirLinkedList<>(1,2,3,4,5,6);
        System.out.println(twoDirLinkedList.toString());
        twoDirLinkedList.insert(0,11,22);
        System.out.println(twoDirLinkedList.toString());
        twoDirLinkedList.delete(0);
        System.out.println(twoDirLinkedList.toString());
        twoDirLinkedList.delete(twoDirLinkedList.Length()-1);
        System.out.println(twoDirLinkedList.toString());
    }

    public static void test_twoDirCicularLinkedList()
    {
        TwoDirCicularLinkedList<Integer> twoDirCicularLinkedList_empty=new TwoDirCicularLinkedList<>();
        System.out.println("empty is  "+twoDirCicularLinkedList_empty);
        TwoDirCicularLinkedList<Integer> twoDirCicularLinkedList=new TwoDirCicularLinkedList<>(1,2,3,4,5,6);
        System.out.println(twoDirCicularLinkedList);
        twoDirCicularLinkedList.insert(0,11,22,33);
        System.out.println(twoDirCicularLinkedList);
        twoDirCicularLinkedList.delete(0);
        twoDirCicularLinkedList.delete(twoDirCicularLinkedList.Length()-1);
        System.out.println(twoDirCicularLinkedList);


    }


    public static void Test_CustomArrayList()
    {
        CustomArrayList<Integer> customArrayList_empty=new CustomArrayList();
        System.out.println("Length is "+customArrayList_empty.Length()+" ** "+customArrayList_empty.toString());
        CustomArrayList<Integer> customArrayList=new CustomArrayList(1,2,3,4,5,6);
        System.out.println("Length is "+customArrayList.Length()+" ** "+customArrayList.toString());
//        customArrayList.Insert(2,-1);//exception
//        customArrayList.Insert(2,customArrayList.Length());//exception
        customArrayList.Insert(0,2);//insert before the first
        System.out.println("Length is "+customArrayList.Length()+" ** "+customArrayList.toString());
        customArrayList.Insert(1,22);//insert before the pos 1
        System.out.println("Length is "+customArrayList.Length()+" ** "+customArrayList.toString());
        customArrayList.Insert(customArrayList.Length()-1,22);//insert before the last
        System.out.println("Length is "+customArrayList.Length()+" ** "+customArrayList.toString());
        customArrayList.Insert(customArrayList.Length(),222);//insert after the last
        System.out.println("Length is "+customArrayList.Length()+" ** "+customArrayList.toString());
//        customArrayList.delete(-1);//Exception
//        customArrayList.delete(customArrayList.Length());//Exception
        customArrayList.delete(0);//
        System.out.println("Length is "+customArrayList.Length()+" ** "+customArrayList.toString());
        customArrayList.delete(customArrayList.Length()-1);//Exception
        System.out.println("Length is "+customArrayList.Length()+" ** "+customArrayList.toString());
        customArrayList.delete(2);//
        System.out.println("Length is "+customArrayList.Length()+" ** "+customArrayList.toString());
    }

    public static void test_linkedList()
    {
        LinkedList<Integer> linkedList_empty=new LinkedList<>();
        System.out.println("empty linked list is "+linkedList_empty.toString());
        LinkedList<Integer> linkedList=new LinkedList<>(1,2,3,4,5,6);
        System.out.println(linkedList.toString());
//        linkedList.insert(-1,1,2,3);//Exception
//        linkedList.insert(7,1,2,3);//Exception
        linkedList.insert(linkedList.Length(),11,22,33);//insert after the last,that's mean,insert before null
        System.out.println(linkedList.toString());
        linkedList.insert(0,11,22,33);//insert before the first node.
        System.out.println(linkedList.toString());
        linkedList.insert(3,111,222,333);//insert before the 4th node
        System.out.println(linkedList.toString());
        linkedList.delete(0);
        System.out.println(linkedList.toString());
        linkedList.delete(3);
        System.out.println(linkedList.toString());
//        linkedList.delete(linkedList.Length());//Exception
        System.out.println(linkedList.toString());
        linkedList.delete(linkedList.Length()-1);
        System.out.println(linkedList.toString());
    }

    public static void test_circular_linkedList()
    {
        CircularLinkedList<Integer> circularLinkedList_empty=new CircularLinkedList<>();
        System.out.println("circularLinkedList_empty is "+circularLinkedList_empty.toString());
        CircularLinkedList<Integer> circularLinkedList=new CircularLinkedList<>(1,2,3,4,5,6);
        System.out.println(circularLinkedList.toString());
        circularLinkedList.insert(0,11,22,33);
        circularLinkedList.insert(circularLinkedList.Length(),11,22,33);
        System.out.println(circularLinkedList.toString());
        circularLinkedList.delete(0);
        System.out.println(circularLinkedList.toString());
        circularLinkedList.delete(circularLinkedList.Length()-1);
        System.out.println(circularLinkedList.toString());
        combineTwoCircularList(circularLinkedList,new CircularLinkedList<Integer>(1111,2222,3333));


    }

    //linked list combine,the use of circular list,O(1)
    public static void  combineTwoCircularList(CircularLinkedList c1,CircularLinkedList c2 )
    {
        c1.getLast().setNext(c2.getFirst().getNext());
        c1.setLast(c2.getLast());
        c2.getLast().setNext(c1.getFirst());
        System.out.println("combined list is "+c1.toString());
    }





}
