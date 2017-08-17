import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

public class fileUtilsTest {
    public static void main(String[] args) throws IOException {
//        String srcPath = "D:\\迅雷下载\\_okdoed20170816北京讯胡歌周迅刘雯香奈儿新品香水发布会.mp4";
//        String destPath = "D:\\迅雷下载\\新建文件夹\\222222222.mp4";
//        File srcFile = new File(srcPath);
//        File destFile = new File(destPath);
//
//        FileUtils.copyFile(srcFile,destFile);


        List<String> suffixes = Arrays.<String>asList(".txt", ".doc", ".jpg");
        for (String suffixe:suffixes) {
            if (suffixe.equals(".txt")){
                System.out.println("true");
            };
        }

    }
}
