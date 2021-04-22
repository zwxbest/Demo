package com.tuowazi.demo.linkedlist;

/**
 * 模拟多线程情况下并发创建链表会出现的问题
 */
public class JUCHeadLinkedList {

    private Node head;

    private static String LOCK = "lock";

    /**
     * 头插法,返回头节点的信息
     */
    public Node addNode(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        return head;
    }

    public void printNode() {
        Node node = head;
        while (node != null) {
            System.out.print(node.getVal() + "->");
            node = node.getNext();
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        JUCHeadLinkedList headLinkedList = new JUCHeadLinkedList();
        headLinkedList.addNode(1);
        headLinkedList.printNode();
    }

    public static class A{
        public static void main(String[] args) {
            //测试多线程下头插法会有什么问题

        }
    }
}
