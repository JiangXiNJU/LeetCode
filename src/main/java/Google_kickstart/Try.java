package Google_kickstart;

/**
 * Created by cycy on 2018/7/29.
 */
import java.util.*;
import java.io.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class Try {
    public static void main(String[] args) {
        FileInputStream input=null;
        FileWriter fw = null;
        try {
            String input_path="F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\input";
            String output_path="F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\RoundD\\data\\output";
            input = new FileInputStream(input_path);
            fw= new FileWriter(output_path);

            Scanner in=new Scanner(input);

            /**
             * code
             */

            fw.close();
        }catch (Exception e){
            out.println("读取文件出错");
        }
    }
}