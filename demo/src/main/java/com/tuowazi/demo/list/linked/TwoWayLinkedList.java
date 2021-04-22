package com.tuowazi.demo.list.linked;

/**
 * 双向链表
 */
public class TwoWayLinkedList<T> {

    private Node head = new Node();
    private Node tail = new Node();
    private int count = 0;

    public class Node {

        public T val;
        public Node pre;
        public Node next;

        public Node() {
        }

        public Node(T val) {
            this.val = val;
        }
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }

    /**
     * Initialize your data structure here.
     */
    public TwoWayLinkedList() {
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 获取链表第几个元素的值 如果找不到，返回null
     */
    public T getVal(int index) {
        Node node = getNode(index);
        if (node == null) {
            return null;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(T val) {
        insertNode(val, head.next);
    }

    /**
     * 在node之后插入
     */
    public void insertAfter(T val, Node node) {
        insertNode(val, node.next);
    }

    /**
     * 在node之前插入
     * @param val
     * @param node
     */
    public void insertBefore(T val, Node node) {
        insertNode(val, node);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(T val) {
        insertNode(val, tail);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the
     * length of linked list, the node will be appended to the end of linked list. If index is
     * greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, T val) {
        if (index > count) {
            return;
        }
        if (index < 0) {
            addAtHead(val);
        } else if (index == count) {
            addAtTail(val);
        } else {
            Node node = getNode(index);
            if (node == null) {
                return;
            }
            insertNode(val, node);
        }
    }

    /**
     * 删除node
     * @param node
     */
    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node cur = getNode(index);
        if (cur == null) {
            return;
        }
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        count--;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        int i = 0;
        Node cur = head.next;
        while (cur != tail) {
            if (i >= index) {
                break;
            }
            cur = cur.next;
            i++;
        }
        return cur;
    }

    /**
     * 在next之前插入一个节点
     */
    private void insertNode(T val, Node next) {
        Node node = new Node(val);
        next.pre.next = node;
        node.pre = next.pre;
        //双向
        node.next = next;
        next.pre = node;
        count++;
    }

    public int getCount() {
        return count;
    }

    private void print() {
        Node cur = head.next;
        while (cur != tail) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TwoWayLinkedList<Integer> linkedList = new TwoWayLinkedList<>();
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.addAtIndex(0, -1);
        linkedList.deleteAtIndex(linkedList.getCount() - 1);
        linkedList.deleteAtIndex(linkedList.getCount() - 1);
        System.out.println(linkedList.getVal(0));
        linkedList.print();

    }
}
