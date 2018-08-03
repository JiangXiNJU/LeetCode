package PinDuoduo;

/**
 * Created by cycy on 2018/7/22.
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static int method(int target){
        if(Math.abs(target)<2) return Math.abs(target);
        int q=(int)Math.sqrt(Math.abs(target)*2);
        if(q*(q+1)==Math.abs(target)*2) return q;
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target=scan.nextInt();
        int res=method(target);
        out.println(res);
    }
}
