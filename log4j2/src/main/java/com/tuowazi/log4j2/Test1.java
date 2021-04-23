package com.tuowazi.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test1 {

    private static Logger logger = LogManager.getLogger(Test1.class);

    public static void main(String[] args) {

        logger.error("test1");

    }
}
