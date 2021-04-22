package com.tuowazi.demo.log4j;


import org.apache.log4j.Logger;


public class Test2 {

    private static Logger log = Logger.getLogger(Test2.class);

    public static void main(String[] args) {
        log.debug("debug");
        log.error("error");
    }
}
