package com.tuowazi.demo.log4j.other;

import com.tuowazi.demo.log4j.Test1;

import org.apache.log4j.Logger;

public class Test {
    private static Logger log = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        log.debug("debug");
        log.error("error");
    }
}
