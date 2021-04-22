package com.tuowazi.demo.itext_demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zwxbest on 2018/3/1.
 */
public class BookMarkInput {

    //注意目录txt中的页码为书上标注的页码，不包括目录和前言，但是用pdf看页码是从目录便开始算。
    //去看一下偏差
    public static List<BookMark> read(String file,int offset) throws Exception {
        String regex = "(.*?([0-9.]+).*?[　\\s]+.*)[　\\s]+([0-9]+)";//注意半角空格
        String regexWithoutOrder = "(.*)[　\\s]+([0-9]+)";//注意半角空格
        BufferedReader fs = new BufferedReader(new FileReader(file));
        String line = fs.readLine();
        Pattern p = Pattern.compile(regex);
        Pattern p1 = Pattern.compile(regexWithoutOrder);
        List<BookMark> bookMarks=new ArrayList<>();
        Matcher m;
        int id=0;
        while (line!= null) {
            final BookMark bookMark=new BookMark();
            if(!line.equals(""))
            {
                m = p.matcher(line);
                bookMark.setParent(null);
                if (m.find())
                {
                    bookMark.setTitle(m.group(1));
                    bookMark.setOrder(m.group(2));
                    bookMark.setNum(Integer.valueOf(m.group(3))+offset);
                    for(int i=bookMarks.size()-1;i>=0;i--)
                    {
                        if(bookMark.getOrder().contains(bookMarks.get(i).getOrder()+"."))
                        {
                            bookMark.setParent(bookMarks.get(i));
                            break;
                        }
                    }
                }
                else
                {
                    m = p1.matcher(line);
                    if(m.find())
                    {
                        bookMark.setTitle(m.group(1));
                        bookMark.setNum(Integer.valueOf(m.group(2))+offset);
                    }
                    else
                    {
                        bookMark.setTitle(line);
                        bookMark.setNum(Integer.valueOf(1));
                    }

                }
                bookMarks.add(bookMark);
            }
            line = fs.readLine();
        }
        return bookMarks;
    }
}
