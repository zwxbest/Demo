package com.tuowazi.demo.concurrent.src.reorder;

import lombok.Getter;

public  class Singleton {
    static Singleton instance = null;
    @Getter
    private String data;
    private Singleton() {
        data = "data";
    }

    public static Singleton getInstance() {
        if (instance == null) { //第一次检测
            synchronized (Singleton.class) { //加锁
                if (instance == null) { //第二次检测
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}