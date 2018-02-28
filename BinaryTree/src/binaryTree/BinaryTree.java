package binaryTree;


/**
 * User:zhangweixiao
 * Description:
 */
public class BinaryTree<T> {

    private TreeNode root;

    /**
     * create by level
     *
     * @param args
     */
    public BinaryTree(T... args) {
        T[] objs = args.clone();

        root = CreateByLevelOrder( 0, objs);

    }

    public TreeNode CreateByLevelOrder( int i, T[] objs) {

        if( (i<objs.length&&objs[i]==null)&&
                ( (2*i+1<objs.length&&objs[2*i+1]!=null)||(2*i+2<objs.length&&objs[2*i+2]!=null))
                )
            throw  new RuntimeException("parent is null but child is not null?");

        if (i >= objs.length||objs[i]==null)
            return null;

        TreeNode node=new TreeNode(objs[i]);

        node.setLchild( CreateByLevelOrder( i * 2+1, objs));
        node.setRchild( CreateByLevelOrder( i * 2+2, objs));

        return node;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        PreOrderTraverse(sb, root);
        return sb.toString();

    }

    public void PreOrderTraverse(StringBuilder sb, TreeNode node) {
        if (node == null)
            return;
        sb.append(node.getData()+" ");
        PreOrderTraverse(sb, node.getLchild());
        PreOrderTraverse(sb, node.getRchild());
    }

    public void InOrderTraverse(StringBuilder sb, TreeNode node) {
        if (node == null)
            return;
        InOrderTraverse(sb, node.getLchild());
        sb.append(node.getData());
        InOrderTraverse(sb, node.getRchild());
    }

    public void PostOrderTraverse(StringBuilder sb, TreeNode node) {
        if (node == null)
            return;
        PostOrderTraverse(sb, node.getLchild());
        PostOrderTraverse(sb, node.getRchild());
        sb.append(node.getData()+" ");
    }


}
