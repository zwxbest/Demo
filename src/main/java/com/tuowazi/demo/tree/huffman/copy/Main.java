package com.tuowazi.demo.tree.huffman.copy;

public class Main {

    public static void main(String[] args) {

        Huffman huff = new Huffman();// 创建哈弗曼对象

        String data = "ABBACAC"; // 读取本地文件（自己写的方法，不想写可以自己随便定一个字符串）
        huff.creatHfmTree(data);// 构造树

        huff.output(); // 显示字符的哈夫曼编码

        // 将目标字符串利用生成好的哈夫曼编码生成对应的二进制编码
        String hufmCode = huff.toHufmCode(data);
        System.out.println("编码:" + hufmCode);

        // 将上述二进制编码再翻译成字符串
        System.out.println("解码：" + huff.CodeToString(hufmCode));
    }

}
