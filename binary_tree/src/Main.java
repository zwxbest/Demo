import binaryTree.BinaryTree;
import threadedBinaryTree.ThreadedBinaryTree;

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
