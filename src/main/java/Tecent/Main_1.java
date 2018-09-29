package Tecent;

/**
 * Created by cycy on 2018/9/16.
 */

import java.util.*;

import static java.lang.System.out;

public class Main_1 {

    public static boolean isP(int n){
        int tmp=(int)Math.sqrt(n);
        for(int i=2;i<=tmp;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static int prime(int n){
        for(int i=n;i>=1;i--){
            if(isP(i)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        if(n<=3) out.println(n+1);
        else {
            int p = prime(n);
            if (p == -1) out.println(n + 1);
            else {
                int i;
                for (i = n + 1; i <= 2 * n; i++) {
                    if (i % p == 0) break;
                }
                out.println(i);
            }
        }
    }
}
