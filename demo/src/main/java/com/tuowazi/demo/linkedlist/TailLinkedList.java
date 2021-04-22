package com.tuowazi.demo.linkedlist;

public class TailLinkedList {

    private Node head;
    private Node tail;

    /**
     * 头插法,返回头节点的信息
     */
    public Node addNode(int... vals) {
        for (int val : vals) {
            Node node = new Node(val);
            if (head == null) {
                head = tail = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
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
        TailLinkedList headLinkedList = new TailLinkedList();
        headLinkedList.addNode(1, 2, 3, 4, 5, 6);
        headLinkedList.printNode();
    }
}
