package com.tuowazi.demo.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Node {

    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }
}
