package iText;

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
        String regex = "(.*)[　\\s]+([0-9]+)";//注意半角空格
        BufferedReader fs = new BufferedReader(new FileReader(file));
        String line = fs.readLine();
        Pattern p = Pattern.compile(regex);
        List<BookMark> bookMarks=new ArrayList<>();
        Matcher m;
        while (line != null) {
            m = p.matcher(line);
            if (m.find())
            {
                if(m.groupCount()==2)
                {
                    BookMark bookMark=new BookMark();
                    bookMark.setNum(Integer.valueOf(m.group(2))+offset);
                    bookMark.setTitle(m.group(1));
                    bookMarks.add(bookMark);
                }

            }
            line = fs.readLine();
        }
        return bookMarks;
    }
}
