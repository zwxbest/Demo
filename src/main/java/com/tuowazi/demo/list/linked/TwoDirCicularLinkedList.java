package com.tuowazi.demo.list.linked;


import com.tuowazi.demo.list.linked.node.TwoDirNode;

/**
 * User:zhangweixiao
 * Description:
 */
public class TwoDirCicularLinkedList<T> {
    private int cur_count = 0;
    //the first's data means nothing
    private TwoDirNode<T> first = new TwoDirNode(null);

    public TwoDirCicularLinkedList(T... args) {

        first.setNext(CreateLinkedList(first,first,args));
    }


    /**
     *
     * @param before_List
     * @param after_list
     * @param args
     * @return
     */
    public TwoDirNode CreateLinkedList(TwoDirNode<T> before_List,TwoDirNode<T> after_list,T... args)
    {
        TwoDirNode after=after_list;
        TwoDirNode before=before_List;

        T[] tmp = args.clone();
        for (int j = tmp.length - 1; j >= 0; j--) {
            TwoDirNode cur=new TwoDirNode(tmp[j]);
            cur.setNext(after);
            if(j<tmp.length-1)
                cur.getNext().setPrior(after);
            after=cur;

        }
        if(after!=null)
            after.setPrior(before);
        cur_count+=args.length;
        return after;
    }



    public void insert(int pos, T... objs) {
        if(pos<0||pos>cur_count)
            throw new IndexOutOfBoundsException();
        TwoDirNode insert_after_this_node=first;
        for(int i=0;i<pos;i++)
        {
            insert_after_this_node=insert_after_this_node.getNext();
        }
        TwoDirNode<T> inserted_node_first = CreateLinkedList(insert_after_this_node,insert_after_this_node.getNext(),objs);
        insert_after_this_node.setNext(inserted_node_first);
    }

    public T delete(int pos)
    {
        if(pos<0||pos>=cur_count)
            throw new IndexOutOfBoundsException();
        TwoDirNode<T> delete_after_this_node=first;
        for(int i=0;i<pos;i++)
        {
            delete_after_this_node=delete_after_this_node.getNext();
        }
        T ret=delete_after_this_node.getNext().getObj();
        delete_after_this_node.getNext().setPrior(delete_after_this_node);
        delete_after_this_node.setNext(delete_after_this_node.getNext().getNext());
        cur_count--;
        return ret;
    }
    /**
     * I want to whether Java GC garbage can automatically delete the link,if the head is not pointer to the Link.
     * but now just set every TwoDirNode's next to null to make GC active.
     * @return
     */
    public boolean clear()
    {
        TwoDirNode curNode=first;
        TwoDirNode nextNode=curNode.getNext();
        while (nextNode!=first)
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
        TwoDirNode TwoDirNode = first.getNext();
        while (TwoDirNode != first) {
            sb.append(TwoDirNode.getObj() + ",");
            TwoDirNode = TwoDirNode.getNext();
        }
        return sb.toString();
    }

    public int Length() {
        return cur_count;
    }
}
