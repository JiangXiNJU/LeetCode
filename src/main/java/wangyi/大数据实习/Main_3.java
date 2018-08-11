package wangyi.大数据实习;

/**
 * Created by cycy on 2018/8/10.
 */
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static int CMN(int n,int m){
        if(m>n/2) return CMN(n,n-m);
        int sum=1;
        for(int i=n;i>=n-m+1;i--) sum*=i;
        for(int i=m;i>=2;i--) sum/=i;
        return sum;
    }
    public static int get(int n,int w,int[] v,int num){
        if(num<=2) return CMN(n,num);
        int sum_w=0;
        int index=n-1;
        //最大的num个都不会超过界限，可任选
        while(sum_w<=w&&index>=0){
            sum_w+=v[index];
            index--;
        }
        if(index==-1) return CMN(n,num);
        //最小的num个都会超过界限，无法选
        sum_w=0;
        index=0;
        while(sum_w<=w&&index<num){
            sum_w+=v[index];
            index++;
        }
        if(sum_w>w) return 0;
        /**
         * 存在不能任选num的情况
         */
        return sum_w;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),w=scan.nextInt();
        int[] v=new int[n];
        for(int i=0;i<n;i++)
            v[i]=scan.nextInt();
        Arrays.sort(v);
        int sum=0;
        for(int i=0;i<=n;i++){
            sum+=get(n,w,v,i);
        }
        out.println(sum);
    }
}
