package 网易.大数据实习;

/**
 * Created by cycy on 2018/8/10.
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static long getPair(int n,int k){
        long sum=0;
        /**
         * x比y大
         */
        int max=(n-k)/(k+1);
        for(int i=1;i<=max;i++)
            sum+=(n-k)/i-k;
        return sum;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,k;
        n=scan.nextInt();
        k=scan.nextInt();
        long sum=0;
        sum+=(n-k)*(n-k+1)/2;
        for(int i=k;i<n;i++){
            sum+=getPair(n,i);
        }
        out.println(sum);
    }
}

