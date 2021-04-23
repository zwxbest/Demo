package com.tuowazi.demo.slf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Test1 {

    private static final Logger log = LoggerFactory.getLogger(Test1.class);

    public static void main(String[] args) {

        log.debug("debug");
        log.error("error");

    }
}
