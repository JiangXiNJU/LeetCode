package ByteDance.ByteDance2019;

/**
 * Created by cycy on 2018/8/25.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static int find_root(int[] pre,int target){
        int r=target;
        while(pre[r]!=r) //find root
            r=pre[r];
        int i=target;
        int j;
        while(i!=r){//路径压缩
            j=pre[i];
            pre[i]=r;
            i=j;
        }
        return r;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] pre=new int[n+1];
        for(int i=1;i<=n;i++)
            pre[i]=i;
        for(int i=1;i<=n;i++){
            int tmp=0;
            while((tmp=scan.nextInt())!=0){
                int r1=find_root(pre,i);
                int r2=find_root(pre,tmp);
                pre[r2]=r1;
            }
        }

        for(int i=1;i<=n;i++)
            find_root(pre,i);

        int m=0;
        for(int i=1;i<=n;i++)
            if(pre[i]==i) m++;
        out.println(m);

    }
}

/**
 10
 0
 5 3 0
 8 4 0
 9 0
 9 0
 3 0
 0
 7 9 0
 0
 9 7 0
 */