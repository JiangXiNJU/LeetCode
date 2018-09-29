package 科大讯飞;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by cycy on 2018/9/7.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        while(t>0){
            int n=scan.nextInt(),X=scan.nextInt();
            int[] a=new int[n];
            int cur_sum=0;
            int need_tobe=n*X;
            for(int i=0;i<n;i++){
                a[i]=scan.nextInt();
                cur_sum+=a[i];
            }
            int ans=0;
            if(cur_sum>=need_tobe){
                out.println(ans);
                t--;
                continue;
            }
            Arrays.sort(a);
            for(int i=0;i<n;i++){
                cur_sum+=100-a[i];
                ans++;
                if(cur_sum>=need_tobe)
                    break;
            }
            out.println(ans);
            t--;
        }
    }
}
