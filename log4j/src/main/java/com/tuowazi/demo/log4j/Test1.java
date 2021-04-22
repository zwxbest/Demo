package com.tuowazi.demo.log4j;


import org.apache.log4j.Logger;


public class Test1 {


//    这个不会打印到console里了。
    private static Logger log = Logger.getLogger(Test1.class);

    //    同时写到两个文件中
    private static Logger log2 = Logger.getLogger(Test2.class);

    public static void main(String[] args) {

        log.debug("debug");
        log.error("error");

        log2.error("error");
    }
}
