package iText;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zwxbest on 2018/3/1.
 */
public class BookmarksOperation {

    PdfReader reader;

    public void openPdf(String filename, String destName) throws Exception {
        Document content = new Document(PageSize.A4, 48, 48, 60, 65);
    }


    public void editBookmarks(String src, String dest) throws DocumentException, IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        List<HashMap<String, Object>> list = SimpleBookmark.getBookmark(reader);
        changeList(list);
        stamper.setOutlines(list);
        stamper.close();
        reader.close();
    }

    public void changeList(List<HashMap<String, Object>> list) {
        for (HashMap<String, Object> entry : list) {
            for (String key : entry.keySet()) {
                if ("Kids".equals(key)) {
                    Object o = entry.get(key);
                    changeList((List<HashMap<String, Object>>) o);
                } else if ("Page".equals(key)) {
                    String dest = (String) entry.get(key);
                    entry.put("Page", dest.replaceAll("\\b(Fit|FitV|FITB|FITBH|FITBV|FITH|FITR)\\b", "XYZ"));
                }
            }
        }
    }

    public void createBookmarks(List<BookMark> booksmarks, String src, String dest) throws Exception {
        Document document = new Document();
        reader=new PdfReader(src);
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(dest));
        document.open();

        PdfOutline root = copy.getRootOutline();

        copy.addDocument(reader);
        PdfDestination destination = new PdfDestination(
                PdfDestination.XYZ, -1, -1, 0);

        PdfAction action;
        copy.freeReader(reader);
        for(BookMark bookMark :booksmarks)
        {
             action = PdfAction.gotoLocalPage(bookMark.getNum(), destination, copy);
             new PdfOutline(root, action, bookMark.getTitle(), false);
        }
        copy.flush();
        copy.close();
        document.close();

    }

}




