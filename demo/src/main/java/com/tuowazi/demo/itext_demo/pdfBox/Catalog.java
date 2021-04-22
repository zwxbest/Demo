package com.tuowazi.demo.itext_demo.pdfBox;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.*;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;

import java.io.FileInputStream;

/**
 * User:zhangweixiao
 * Description:
 * NO Use,Pdf Box have a bug,some getDestination get null,but in pdf view,looks normal ,and itext looks normal
 */
public class Catalog {


    private Log log= LogFactory.getLog(this.getClass());
    private  PDDocument document=null;

    public void OpenPdf(String filename)  throws Exception
    {
        FileInputStream fs=null;
        try
        {
             fs = new   FileInputStream(filename);
            document=PDDocument.load(fs);

        }
        catch (Exception e)
        {
            log.error("Open error,please check the file");
        }
        finally {
            fs.close();
        }
    }
    //set scale to inherit
    public void AdjustCatalog() throws Exception
    {
        //获取PDDocumentCatalog文档目录对象
        PDDocumentCatalog catalog=document.getDocumentCatalog();
        //获取PDDocumentOutline文档纲要对象
        PDDocumentOutline outline=catalog.getDocumentOutline();
        for (PDOutlineItem item:outline.children())
        {
            System.out.println(item.getTitle()+item.getDestination());
            AdjustCatalogRecurse(item);
        }
    }
    public void AdjustCatalogRecurse(PDOutlineItem item) throws Exception
    {
//        PDPageXYZDestination xyzDestination=new PDPageXYZDestination();
        System.out.println(item.getDestination()==null?"null":item.getDestination().getClass());
        System.out.println(item.getTitle());
//        UpdatePageDestination(item.getDestination(),xyzDestination);
//        item.setDestination(xyzDestination);
        for (PDOutlineItem item_child:item.children())
        {
            AdjustCatalogRecurse(item_child);
        }
    }

    //remember close pdf file.
    public void save(String filename) throws Exception
    {
        document.save(filename);
    }

    /**
     * retrievePageNumber always get number small than findPageNumber by 1,getpageNumber is always -1
     * eg.origin pdf catalog is 56,findPageNumber get 56,retrievePageNumber get 55,getpageNumber get -1
     * I don't know why,sometimes I have time to com.nizouba.search the question.
     * @param destination
     * @param xyzDestination
     */
    public void UpdatePageDestination(PDDestination destination,PDPageXYZDestination xyzDestination)
    {

        if(destination instanceof PDPageXYZDestination)
            return;
        if(destination instanceof  PDPageFitDestination)
            xyzDestination.setPageNumber( ((PDPageDestination)destination).findPageNumber());
        //Page Fit means one page content can entirely seen on the screen,means left and top is fixed,equal the page size
         if(destination instanceof PDPageFitDestination)
         {
             UpdatePageDestination(destination,xyzDestination);
             xyzDestination.setLeft(-1);
             xyzDestination.setTop(-1);
         }
         //Fit Width means all content from left to right can be seen ,left is fixed.
         else  if(destination instanceof PDPageFitWidthDestination)
        {
            UpdatePageDestination(destination,xyzDestination);
            xyzDestination.setLeft(-1);
            xyzDestination.setTop(((PDPageFitWidthDestination)destination).getTop());
        }
        //Fit Width means all content from buttom to top can be seen ,top is fixed.
        //but left is always 0,because it's strange to look pdf from left to right .
        else if(destination instanceof PDPageFitHeightDestination)
        {
            UpdatePageDestination(destination,xyzDestination);
            xyzDestination.setLeft(((PDPageFitHeightDestination)destination).getLeft());
            xyzDestination.setTop(-1);
        }

    }



}
