package wangyi.W2018;

/**
 * Created by cycy on 2018/8/11.
 */
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.reflect.Array.get;

public class Main_2 {
    public static int get(int[] sum,int q){
        int f=0,b=sum.length-1;
        while(f<=b){
            int mid=(f+b)/2;
            if(sum[mid]==q) return mid+1;
            if(sum[mid]<q) f=mid+1;
            else if(sum[mid]>q){
                if(mid==0) return 1;
                if(sum[mid-1]<q) return mid+1;
                if(sum[mid-1]==q) return mid;
                b=mid-1;
            }
        }

        return f+1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        int m=scan.nextInt();
        int[] q=new int[m];
        for(int i=0;i<m;i++)
            q[i]=scan.nextInt();
        int[] sum=new int[n];
        sum[0]=a[0];
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+a[i];
        }
        for(int i=0;i<m;i++){
            out.println(get(sum,q[i]));
        }
//        out.println();
    }
}
