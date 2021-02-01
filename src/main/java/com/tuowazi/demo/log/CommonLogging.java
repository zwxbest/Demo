package com.tuowazi.demo.log;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.invoke.MethodHandles;

/**
 * User:zhangweixiao
 * Description:
 */
public class CommonLogging {
    public static void main(String[] args) {

        Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass());
        log.info(" 我叫做酱爆。我从来mou有放弃,成为一果伟大噶作曲家噶理想!");
    }

}
