package com.tuowazi.demo.tree.custom;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 非huffman编码，用来对比长度
 */
public class NoHuffMan {


    private Map<String, String> codeEncodeMappingTable = new Hashtable<>();
    private Map<String, String> codeDecodeMappingTable = new Hashtable<>();

    private int uniqueSize;

    private Character[] characters;

    public void encodeNoHuffMan(String str) {
        //计算不同的字符的数量
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        uniqueSize = set.size();
        //计算是2的多少次方
        int temp = uniqueSize;
        int len = 0;
        while (temp != 0) {
            len++;
            temp = temp >> 1;
        }
        //给set中的每个字符编码，按照位数
        characters = set.toArray(new Character[0]);
        updateCode(len, "");
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(codeEncodeMappingTable.getOrDefault(c + "", ""));
        }
        System.out.println("no huffman code is " + sb.toString());

        //解码
        StringBuilder encodeUnit = new StringBuilder();
        StringBuilder decodeStr = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            encodeUnit.append(c);
            if (codeDecodeMappingTable.get(encodeUnit.toString()) != null) {
                decodeStr.append((codeDecodeMappingTable.get(encodeUnit.toString())));
                encodeUnit = new StringBuilder();
            }
        }
        System.out.println("No huffman decode is " + decodeStr.toString());
    }

    private void updateCode(int len, String code) {
        if (len > 0) {
            updateCode(len - 1, code + "0");
            updateCode(len - 1, code + "1");
        } else {
            uniqueSize--;
            if (uniqueSize < 0) {
                return;
            }
            codeEncodeMappingTable.put(characters[uniqueSize] + "", code);
            codeDecodeMappingTable.put(code, characters[uniqueSize] + "");
        }
    }

    public static void main(String[] args) {
        NoHuffMan noHuffMan = new NoHuffMan();
        noHuffMan.updateCode(4, "");
    }
}
