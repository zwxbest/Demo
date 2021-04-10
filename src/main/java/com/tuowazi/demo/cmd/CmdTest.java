package com.tuowazi.demo.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CmdTest {
    public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder();
        BufferedReader reader = null;
        builder.redirectErrorStream(true);
        Process process = null;
        System.out.println("哈啊哈");
        try {
            List<String> commands = new ArrayList<String>();
            commands.add("ping");
            commands.add("-n");
            commands.add("1000");
            commands.add("www.baidu.com");
            builder.command(commands);
            process = builder.start();
            InputStream inputStream = process.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            inputStream.close();
            process.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            process.destroy();
            reader.close();
        }
    }

}
