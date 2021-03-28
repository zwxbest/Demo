package com.tuowazi.demo.tree.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HNode {

    private HNode left;
    private HNode right;
    private String data;
    private int weight;//权重
    private String code;

    public HNode(String data,int weight){
        this.data = data;
        this.weight = weight;
    }
}
