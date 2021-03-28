package com.tuowazi.demo.tree.custom;

public class Main {



    public static void main(String[] args) {

        HuffMan huffMan = new HuffMan();
        huffMan.createTree("AABCC");

        System.out.println();

        NoHuffMan noHuffMan = new NoHuffMan();
        noHuffMan.encodeNoHuffMan("AABCC");

    }

}
