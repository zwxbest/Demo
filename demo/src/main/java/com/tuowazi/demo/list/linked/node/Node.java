package com.tuowazi.demo.list.linked.node;

/**
 * User:zhangweixiao
 * Description:
 */
public class Node<T> {
    private T obj;
    private Node next = null;

    public Node(T obj) {
        this.setObj(obj);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }


}