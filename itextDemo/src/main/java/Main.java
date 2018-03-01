import iText.BookMark;
import iText.BookMarkInput;
import iText.BookmarksOperation;
import pdfBox.Catalog;

import java.util.List;

/**
 * Created by zwxbest on 2018/3/1.
 */
public class Main {

    private static  BookmarksOperation bookmarks;
    public static void main(String[] args) throws Exception
    {

        int offset=22;
        String filename="E:\\PDF\\Java\\Spring\\SPRING攻略\\SPRING攻略++第2版(jb51.net).pdf";
         bookmarks=new BookmarksOperation();
        List<BookMark> bookMarks=BookMarkInput.read("bookmarks.txt",offset);
        bookmarks.createBookmarks(bookMarks,filename,"new.pdf");

    }

    public static void EditBookMarkToXYZ(String src,String dest) throws Exception
    {
                bookmarks.editBookmarks(src,"new.pdf");

    }

    //test pdfBox,now no use
    public static void test_pdfbox() throws Exception
    {
        String filename="E:\\PDF\\Node.js\\Node.js高级编程.pdf";
        Catalog catalog=new Catalog();
        catalog.OpenPdf(filename);
        catalog.AdjustCatalog();
    }

}
