package Google_kickstart.RoundD;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/7/29.
 */
public class Judge {
    public static void main(String[] args) {
        long long1=Long.MAX_VALUE;
        int int1=Integer.MIN_VALUE;
        out.println(long1<int1);
        out.println(-2%2);
        FileInputStream input1=null;
        FileInputStream input2=null;
        try {
            String input_path1="F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\RoundD\\data\\output1";
            String input_path2="F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\RoundD\\data\\output2";

//            String output_path="F:\\Nowcoder\\src\\main\\java\\Google_kickstart\\RoundD\\data\\output";
            input1 = new FileInputStream(input_path1);
            input2=new FileInputStream(input_path2);
//            fw= new FileWriter(output_path);

            Scanner in1=new Scanner(input1);
            Scanner in2=new Scanner(input2);

            /**
             * code
             */
            int line=0;
            while(in1.hasNext()){
                String str1=in1.nextLine();
                String str2=in2.nextLine();
                if(!str1.equals(str2)) out.println("different: "+str1+" "+str2);
                line++;
            }
//            fw.close();
            out.println(line);
        }catch (Exception e){
            out.println("读取文件出错");
        }
    }
}
