package com.tuowazi.demo.binary_tree;


import com.tuowazi.demo.binary_tree.binaryTree.BinaryTree;
import com.tuowazi.demo.binary_tree.threadedBinaryTree.ThreadedBinaryTree;

public class Main {

    public static void main(String[] args) {
       test_threaded_tree();
    }

    public static void test_BinaryTree()
    {
        BinaryTree<Integer> binaryTree=new BinaryTree<>(9,2,3,8,null,null,5);
        System.out.println(binaryTree.toString());
    }

    public static void test_threaded_tree()
    {
        ThreadedBinaryTree<Integer> binaryTree=new ThreadedBinaryTree<>(9,2,3,8,null,null,5);
        System.out.println(binaryTree.toString());
    }


}
