package com.tuowazi.demo.removeutfbob.src.main.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class RemoveUTFBOB {

//    Byte-order mark Description
//    EF BB BF UTF-8
//    FF FE UTF-16 aka UCS-2, little endian
//    FE FF UTF-16 aka UCS-2, big endian
//    00 00 FF FE UTF-32 aka UCS-4, little endian.
//    00 00 FE FF UTF-32 aka UCS-4, big-endian.


    static byte[][] bobs = new byte[][]{
            {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}, //utf-8
    };


    public static void main(String[] args) {

        convert(new File("E:\\GitHub\\Demo\\DesignPattern"), ".+\\.java");

    }


    public static void convert(File file, String regex) {

        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                convert(subFile, regex);
            }
        } else if (file.isFile()
                && file.getName().matches(regex)) {
            try {
                removeUtfBob(file);
            } catch (Exception e) {
                System.out.println(file + " convert error:" + e.getCause());
                e.printStackTrace();
            }
        } else {
// System.out.println(file + " --> 忽略的文件.");
        }
    }

    private static void removeUtfBob(File file) throws IOException {

        byte[] content = FileUtils.readFileToByteArray(file);

        byte[] bob = getMatchedBob(content);

        if (bob != null) {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(content, bob.length, content.length - bob.length);
            outputStream.flush();
            outputStream.close();
            System.out.println(file + " --> 已经转换.");
        }
    }

    private static byte[] getMatchedBob(byte[] content) {

        //保存bob的标志字节
        byte[] r = null;

        if (content == null || content.length == 0)
            return null;

        //判断是否符合bob标志
        for (byte[] bob : bobs) {
            r = bob;
            for (int i = 0; i < bob.length; i++) {
                if (bob[i] != content[i]) {
                    r = null;
                    break;
                }
            }

            if (r != null)
                break;
        }

        return r;
    }

}