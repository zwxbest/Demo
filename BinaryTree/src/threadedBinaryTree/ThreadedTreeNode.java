package threadedBinaryTree;

import binaryTree.TreeNode;

/**
 * User:zhangweixiao
 * Description:
 */
public class ThreadedTreeNode<T> {
    private ThreadedTreeNode lchild;
    private ThreadedTreeNode rchild;
    private T data;
    private boolean isLThread;
    private boolean isRThread;

    public ThreadedTreeNode(T data)
    {
        this.data=data;
    }

    public ThreadedTreeNode getLchild() {
        return lchild;
    }

    public void setLchild(ThreadedTreeNode lchild) {
        this.lchild = lchild;
    }

    public ThreadedTreeNode getRchild() {
        return rchild;
    }

    public void setRchild(ThreadedTreeNode rchild) {
        this.rchild = rchild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    public boolean isLThread() {
        return isLThread;
    }

    public void setLThread(boolean LThread) {
        isLThread = LThread;
    }

    public boolean isRThread() {
        return isRThread;
    }

    public void setRThread(boolean RThread) {
        isRThread = RThread;
    }
}
