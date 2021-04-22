package com.tuowazi.demo.list.linked;

//用双指针输出单链表倒数第 K 个节点
public class TheLastKNode {


    public Node findLastKNode(Node root, int k) {
        if (k < 1) {
            throw new IllegalArgumentException();
        }
        Node node2 = root;
        for (int i = 1; i < k; i++) {
            node2 = node2.next;
        }
        Node node1 = root;
        while (node2.next != null) {
            node1  = node1.next;
            node2 = node2.next;
        }
        return node1;

    }


    public static void main(String[] args) {

        Node cur;
        Node head;
        cur = head = new Node(1);
        cur = cur.next = new Node(2);
        cur = cur.next = new Node(3);
        cur = cur.next = new Node(4);
        cur.next = null;
        System.out.println(new TheLastKNode().findLastKNode(head, 2).value);//3
        System.out.println(new TheLastKNode().findLastKNode(head, 1).value);//3
    }


    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
