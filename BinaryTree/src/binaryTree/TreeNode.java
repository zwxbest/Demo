package binaryTree;

/**
 * User:zhangweixiao
 * Description:
 */
public class TreeNode<T> {

    private TreeNode lchild;
    private TreeNode rchild;
    private T data;

    public TreeNode(T data)
    {
        this.data=data;
    }

    public TreeNode getLchild() {
        return lchild;
    }

    public void setLchild(TreeNode lchild) {
        this.lchild = lchild;
    }

    public TreeNode getRchild() {
        return rchild;
    }

    public void setRchild(TreeNode rchild) {
        this.rchild = rchild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
