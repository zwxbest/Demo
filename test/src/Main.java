import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String pathname="J:\\MV";
        File file=new File(pathname);
//        File[] files=file.listFiles((dir,name)->name.matches("(\\d+\\-.*)|(.*@gdxl\\.mp4)"));
        File[] files=file.listFiles((dir,name)->name.matches("(.*\\.mp)"));
//        Arrays.stream(files).forEach(System.out::println);
        for (File file1:files)
        {
//            String filename=file1.getName().replaceFirst("\\d+\\-?","").replaceFirst("@gdxl","");
            String filename=file1.getName().replaceFirst("\\.mp","\\.mp4");
            System.out.println(new File( file1.getParent(),filename).getPath());
            file1.renameTo(new File( file1.getParent(),filename));
        }
    }
}

