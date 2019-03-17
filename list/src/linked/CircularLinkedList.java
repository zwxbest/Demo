package linked;

import linked.node.Node;

/**
 * User:zhangweixiao
 * Description:
 */
public class CircularLinkedList<T> {

    private int cur_count = 0;
    //the first's data means nothing
    private Node<T> first = new Node(null);
    private Node<T> last=null;

    public CircularLinkedList(T... args) {

        getFirst().setNext(CreateLinkedList(getFirst(),true,args));
    }

    public Node CreateLinkedList(Node<T> after_node, boolean updateLast,T... args)
    {
        Node node=after_node;
        T[] tmp = args.clone();
        for (int j = tmp.length - 1; j >= 0; j--) {

            Node temp=new Node(tmp[j]);
            temp.setNext(node);
            node=temp;
            if(j==tmp.length-1&&updateLast)
                setLast(temp);
        }
        cur_count+=args.length;
        return node;
    }

    public void insert(int pos, T... objs) {
        if(pos<0||pos>cur_count)
            throw new IndexOutOfBoundsException();
        Node insert_after_this_node= getFirst();
        for(int i=0;i<pos;i++)
        {
            insert_after_this_node=insert_after_this_node.getNext();
        }

        boolean update_last=pos==cur_count?true:false;
        Node<T> inserted_node_first = CreateLinkedList(insert_after_this_node.getNext(),update_last,objs);
        insert_after_this_node.setNext(inserted_node_first);
    }

    public T delete(int pos)
    {
        if(pos<0||pos>=cur_count)
            throw new IndexOutOfBoundsException();
        Node<T> delete_after_this_node= getFirst();
        for(int i=0;i<pos;i++)
        {
            delete_after_this_node=delete_after_this_node.getNext();
        }
        T ret=delete_after_this_node.getNext().getObj();
        if(pos==cur_count-1)//delete the last
            setLast(delete_after_this_node);
        delete_after_this_node.setNext(delete_after_this_node.getNext().getNext());
        cur_count--;
        return ret;
    }
    /**
     * I want to whether Java GC garbage can automatically delete the link,if the head is not pointer to the Link.
     * but now just set every Node's next to null to make GC active.
     * @return
     */
    public boolean clear()
    {
        Node curNode= getFirst();
        Node nextNode=curNode.getNext();
        while (nextNode!= getFirst())
        {
            nextNode=curNode.getNext();
            curNode.setNext(null);
            curNode=nextNode;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = getFirst().getNext();
        while (node != getFirst()) {
            sb.append(node.getObj() + ",");
            node = node.getNext();
        }
        return sb.toString();
    }

    public int Length() {
        return cur_count;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }
}

