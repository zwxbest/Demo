package threadedBinaryTree;

import binaryTree.TreeNode;

/**
 * User:zhangweixiao
 * Description:
 */
public class ThreadedBinaryTree<T>{

    private ThreadedTreeNode root;
    private ThreadedTreeNode pre;

    public ThreadedBinaryTree(T... args)
    {
        T[] objs = args.clone();

        root = CreateByLevelOrder( 0, objs);

    }

    public ThreadedTreeNode CreateByLevelOrder(int i, T[] objs) {

        if( (i<objs.length&&objs[i]==null)&&
                ( (2*i+1<objs.length&&objs[2*i+1]!=null)||(2*i+2<objs.length&&objs[2*i+2]!=null))
                )
            throw  new RuntimeException("parent is null but child is not null?");

        if (i >= objs.length||objs[i]==null)
            return null;

        ThreadedTreeNode node=new ThreadedTreeNode(objs[i]);

        node.setLchild( CreateByLevelOrder( i * 2+1, objs));
        node.setRchild( CreateByLevelOrder( i * 2+2, objs));

        return node;
    }

    //In Order
    public void TraverseInOrderToThread(ThreadedTreeNode parent)
    {
        if (parent != null)
        {
            TraverseInOrderToThread(parent.getLchild());
            if (null == parent.getLchild())   // 左孩子为空
            {
                parent.setLThread(true);    // 将左孩子设置为线索
                if(pre==null)
                    parent.setLchild(root);
                else
                parent.setLchild(pre);
            }
            if (pre != null && null == pre.getRchild())  // 右孩子为空
            {
                pre.setRThread(true);
                pre.setRchild(parent);
            }
            pre = parent;
            TraverseInOrderToThread(parent.getRchild());       // 线索化右孩子
        }
    }


    public String InOrderThreadList(ThreadedTreeNode root)
    {
        StringBuilder sb=new StringBuilder();
        while (root != null)
        {
            while (root.isLThread()==false)    // 如果左孩子不是线索
            {
                root = root.getLchild();
            }
            sb.append(root.getData()+",");
            while (root.isRThread())
            {
                root=root.getRchild();
                sb.append(root.getData()+",");
            }
            root=root.getRchild();
        }
        return sb.toString();

    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        TraverseInOrderToThread(root);
        return InOrderThreadList(root).toString();

    }






}
