package wangyi.W2018;

/**
 * Created by cycy on 2018/8/11.
 */
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_1 {
    public static int[] find(int[] a){
        int[] h=new int[2];
        int max=0,min=Integer.MAX_VALUE;
        int max_index=-1,min_index=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
                max_index=i;
            }
            if(a[i]<min){
                min=a[i];
                min_index=i;
            }
        }
        h[0]=min_index;
        h[1]=max_index;
        return h;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=scan.nextInt();
        int[] h=new int[2];
        ArrayList<int[]> path=new ArrayList<int[]>();
        for(int i=0;i<k;i++){
            h=find(a);
            if(a[h[0]]==a[h[1]])  break;
            if(a[h[0]]==a[h[1]]-1) break;
            int[] p=new int[2];
            p[0]=h[1]+1;
            p[1]=h[0]+1;
            path.add(p);
            a[h[1]]--;
            a[h[0]]++;
        }
        out.println(a[h[1]]-a[h[0]]+" "+path.size());
        for(int i=0;i<path.size();i++)
            out.println(path.get(i)[0]+" "+path.get(i)[1]);
    }
}
