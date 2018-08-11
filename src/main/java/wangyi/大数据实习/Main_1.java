package wangyi.大数据实习;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/8/10.
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,symbol=0;
        n=scan.nextInt();
        if(n==0) out.println("N");
        scan.nextLine();
        String turn=scan.nextLine();
        char[] turn_c=turn.toCharArray();
        for(int i=0;i<n;i++){
            if(turn_c[i]=='L') symbol=(symbol+4-1)%4;
            else symbol=(symbol+1)%4;
        }
        switch(symbol){
            case 0:out.println("N");break;
            case 1:out.println("E");break;
            case 2:out.println("S");break;
            case 3:out.println("W");break;
        }
//        out.println();
    }
}
