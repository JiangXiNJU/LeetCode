package Google_kickstart.RoundD;

/**
 * Created by cycy on 2018/7/29.
 */
import java.util.*;
import java.io.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class C {
    public static void main(String[] args) {
        FileInputStream input=null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream("F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\input");
            output= new FileOutputStream("F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\output");

            Scanner in=new Scanner(input);

            /**
             * code
             */

            output.close();
        }catch (Exception e){
            out.println("读取文件出错");
        }
    }
}