package linked;

import linked.node.Node;

import java.awt.*;
import java.util.List;

/**
 * User:zhangweixiao
 * Description:Simple com.nizouba.LinkedList
 */
public class LinkedList<T> {

    private int cur_count = 0;
    //the first's data means nothing
    private Node<T> first = new Node(null);

    public LinkedList(T... args) {

        first.setNext(CreateLinkedList(null,args));
    }

    public Node CreateLinkedList(Node<T> after_node,T... args)
    {
        Node node=after_node;
        T[] tmp = args.clone();
        for (int j = tmp.length - 1; j >= 0; j--) {
            Node temp=new Node(tmp[j]);
            temp.setNext(node);
            node=temp;
        }
        cur_count+=args.length;
        return node;
    }



    public void insert(int pos, T... objs) {
        if(pos<0||pos>cur_count)
            throw new IndexOutOfBoundsException();
        Node insert_after_this_node=first;
       for(int i=0;i<pos;i++)
       {
           insert_after_this_node=insert_after_this_node.getNext();
       }

        Node<T> inserted_node_first = CreateLinkedList(insert_after_this_node.getNext(),objs);
        insert_after_this_node.setNext(inserted_node_first);
    }

    public T delete(int pos)
    {
        if(pos<0||pos>=cur_count)
            throw new IndexOutOfBoundsException();
        Node<T> delete_after_this_node=first;
        for(int i=0;i<pos;i++)
        {
            delete_after_this_node=delete_after_this_node.getNext();
        }
        T ret=delete_after_this_node.getNext().getObj();
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
        Node curNode=first;
        Node nextNode=curNode.getNext();
        while (nextNode!=null)
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
        Node node = first.getNext();
        while (node != null) {
            sb.append(node.getObj() + ",");
            node = node.getNext();
        }
        return sb.toString();
    }

    public int Length() {
        return cur_count;
    }





}
