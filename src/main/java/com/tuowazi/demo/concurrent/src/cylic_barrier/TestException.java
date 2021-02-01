package com.tuowazi.demo.concurrent.src.cylic_barrier;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by zwxbest on 2018/12/23.
 */
public class TestException {

    public static final String DEFAULT_FILE_NAME ="~";
    public static void main(String[] args) {
        File file = new File("~\\学习资料\\movies\\不让看\\别再往里看了\\让你别看你还看\\再看我喊police了");
    }

    public static void readFile(File file) throws Exception{
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        }
        catch (Exception e){
            inputStream = new FileInputStream(DEFAULT_FILE_NAME);
        }
    }
}
