package com.tuowazi.demo.linkedlist;

public class HeadLinkedList {

    private Node head;

    /**
     * 头插法,返回头节点的信息
     */
    public Node addNode(int... vals) {
        for (int val : vals) {
            Node node = new Node(val);
            if (head == null) {
                head = node;
            } else {
                node.setNext(head);
                head = node;
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
        HeadLinkedList headLinkedList = new HeadLinkedList();
        headLinkedList.addNode(1, 2, 3, 4, 5, 6);
        headLinkedList.printNode();
    }

    public static class A{
        public static void main(String[] args) {
            //测试多线程下头插法会有什么问题

        }
    }
}
