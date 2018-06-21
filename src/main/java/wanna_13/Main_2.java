package wanna_13;


/**
 * Created by cycy on 2018/4/6.
 */

import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static long multimod(long mod,long n2){
        long k=0;
        long mod_new=mod%n2;
        long sum=1;
        while(sum%n2!=0){
            k++;
            sum=(sum+mod_new)%n2;
        }
        return k;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int n2=n*n;
        long mod=998244353;
        long a=n2-m;
        long k=multimod(mod,n2);
        long p=(mod*k+1)/n2;
        long res=(p%mod*a)%mod;
        out.println(res);
    }
}
