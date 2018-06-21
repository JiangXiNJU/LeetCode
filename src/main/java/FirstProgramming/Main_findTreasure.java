package FirstProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

class MyComprator implements Comparator {
    public int compare(Object o1, Object o2) {
        int[] one = (int[]) o1;
        int[] two = (int[]) o2;
        if(one[2]<two[2]) return -1;
        else if(one[2]>two[2]) return 1;
        else {
            if(one[0]<two[0]) return -1;
            else if(one[0]>two[0]) return 1;
        }
        return 0;
    }
}

public class Main_findTreasure {

    public static int find(int[] pre,int target){
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
    public static void update_pre(int[] pre,int r,int new_r){
        for(int i=1;i<pre.length;i++){
            if(pre[i]==r) pre[i]=new_r;
        }
    }
    public static void join(int [] pre,int x,int y){
//        out.println("pre[x]: "+pre[x]+" pre[y]: "+pre[y]);
        if(find(pre,x)==find(pre,y)) return;
        if(x<=y) {
//            pre[y]=pre[x];
            update_pre(pre,pre[y],pre[x]);
        }
        else{
//            pre[x]=pre[y];
            update_pre(pre,pre[x],pre[y]);
        }
        return;
    }

    public static boolean testpre(int [] pre){
        int origin=pre[1];
        int index=1;
//        for(int i:pre) out.print(i+" ");
//        out.println();
        while(index<pre.length&&pre[index]==origin) index++;
//        out.println(index);
        if(index<pre.length) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        int[][] path=new int [m][3];
        for(int i=0;i<m;i++){
            path[i]=new int[3];
            path[i][0]=sc.nextInt();
            path[i][1]=sc.nextInt();
            path[i][2]=sc.nextInt();
        }
//        out.println("end input");
        Arrays.sort(path,new MyComprator());

        int min=path[0][2];
        int[] pre=new int[n+1];
        for(int i=0;i<=n;i++) pre[i]=i;
        join(pre,path[0][0],path[0][1]);
        int index=1;
        while(index<m&&!testpre(pre)){
            min=path[index][2];
            join(pre,path[index][0],path[index][1]);
//            out.println(min);
//            for(int i:pre) out.println(i+" ");
            index++;
        }
        out.println(min);

    }
}