package Tecent;

/**
 * Created by cycy on 2018/9/16.
 */

import java.util.*;

import static java.lang.System.out;

public class Main_3 {

    public static boolean judge(int a,int b,int c){
        for(int i=1;i<100;i++){
            if((a*i)%b==c) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt();
        for(int T=0;T<t;T++){
            int a=scan.nextInt(),b=scan.nextInt(),c=scan.nextInt();
            if(judge(a,b,c)) out.println("YES");
            else out.println("NO");
        }
    }
}
