package com.tuowazi.demo.tree.custom;

import com.tuowazi.demo.list.linked.TwoWayLinkedList;

import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class HuffMan {


    /**
     * 权重列表
     */
    private Map<Character, Integer> charWeightMap = new HashMap<>();

    private HNode root;
    /**
     * 双向链表
     */
    private TwoWayLinkedList<HNode> sortedList = new TwoWayLinkedList<>();

    /**
     * 正向转换表
     */
    private Map<String, String> huffmanEncodeTable = new HashMap<>();

    private Map<String, String> huffmanDecodeTable = new HashMap<>();


    public void createTree(String str) {
        System.out.println("input str is " + str);
        //先统计权重
        calcWeight(str);
        //根据权重从小到大排序成为一个链表
        genSortList();
        genTree();//构造的树为sortedList
        //树已经构造好，更新每个节点的huffman编码
        root = sortedList.getHead().next.val;
        updateCode(root, "0");
        String s = encodeHuff(str);
        decodeHuff(s);
        System.out.println(1);
    }

    /**
     * 编码
     */
    private String encodeHuff(String str) {
        //根据code进行huffman编码
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(huffmanEncodeTable.get(c + ""));
        }
        System.out.println("encode is " + sb.toString());
        return sb.toString();
    }

    /**
     * 解码
     */
    private void decodeHuff(String encodeStr) {
        StringBuilder finalStr = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (char c : encodeStr.toCharArray()) {
            sb.append(c);
            String s = huffmanDecodeTable.get(sb.toString());
            if (s != null) {
                finalStr.append(s);
                sb = new StringBuilder();
            }
        }
        System.out.println("decode is " + finalStr.toString());
    }

    //更新huffman编码，用先序遍历
    private void updateCode(HNode node, String code) {
        //每个节点肯定有两个子节点
        if (node != null) {
            node.setCode(code);
            if (node.getData() != null) {
                huffmanEncodeTable.put(node.getData(), code);
                huffmanDecodeTable.put(code, node.getData());
            }
            updateCode(node.getLeft(), code + "0");
            updateCode(node.getRight(), code + "1");
        }
        System.out.println("huffman table mapping");
        for (Map.Entry<String, String> entry : huffmanEncodeTable.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 构建树，每次取最小的两个节点，然后
     */
    private void genTree() {
        TwoWayLinkedList<HNode>.Node node = sortedList.getHead().next;
        while (node.next != null && node.next.val != null) {
            HNode parent = new HNode(null, node.val.getWeight() + node.next.val.getWeight());
            parent.setLeft(node.val);
            parent.setRight(node.next.val);
            //删除这两个节点,先删除next，再删除node
            sortedList.deleteNode(node.next);
            sortedList.deleteNode(node);
            //添加这个新的节点并排序
            insertNodeSeq(parent);
            node = sortedList.getHead().next;
        }
        System.out.println(1);
    }


    //先统计权重
    private void calcWeight(String src) {
        for (char c : src.toCharArray()) {
            charWeightMap.put(c, charWeightMap.getOrDefault(c, 0) + 1);
        }
    }

    /**
     * 按顺序插入node
     */
    private void insertNodeSeq(HNode node2Insert) {
        TwoWayLinkedList<HNode>.Node node = sortedList.getTail();
        while (node != null) {
            HNode hNode = node.val;
            if (node.val != null) {
                //找到第一个比当前weight小的，插到
                if (hNode.getWeight() <= node2Insert.getWeight()) {
                    //插入到hnode之后
                    sortedList.insertAfter(node2Insert, node);
                    break;
                }
            }
            node = node.pre;
        }
        if (node == null) {
            sortedList.insertAfter(node2Insert, sortedList.getHead());
        }

    }

    //根据权重排序，用插入排序表
    private void genSortList() {
        for (Map.Entry<Character, Integer> entry : charWeightMap.entrySet()) {
            Integer curWeight = entry.getValue();
            HNode curHNode = new HNode(entry.getKey().toString(), curWeight);
            insertNodeSeq(curHNode);
        }
        System.out.println(1);
    }


}
