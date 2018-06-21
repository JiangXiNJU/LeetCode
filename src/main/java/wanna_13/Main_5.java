package wanna_13;
/**
 * 链接：https://www.nowcoder.com/acm/contest/80/E
 来源：牛客网

 题目描述
 VVQ 最近迷上了线段这种东西
 现在他手上有 n 条线段，他希望在其中找到两条有公共点的线段，使得他们的异或值最大。 定义线段的异或值为它们并的长度减他们交的长度

 输入描述:
 第一行包括一个正整数 n，表示 VVQ 拥有的线段条数。
 接下来 n 行每行包括两个正整数 l,r，表示 VVQ 拥有的线段的 左右端点。
 输出描述:
 一行一个整数，表示能得到的最大异或值
 示例1
 输入

 3
 10 100
 1 50
 50 100
 输出

 99
 说明

 选择第二条和第三条，99-0=99
 备注:
 1<=n<=200000，1<=l<=r<=1e8
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;
class Mycomparator implements Comparator {
    public int compare(Object o1,Object o2){
        int[] a1=(int[]) o1;
        int[] a2=(int[]) o2;
        if(a1[0]<a2[0]) return -1;
        else if(a1[0]>a2[0]) return 1;
        else{
            if(a1[1]<a2[1]) return -1;
            else return 1;
        }
    }
}
public class Main_5 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[][] lines=new int[n][2];
        for(int i=0;i<n;i++){
            lines[i]=new int[2];
            lines[i][0]=scan.nextInt();
            lines[i][1]=scan.nextInt();
//            out.println(lines[i][0]+" "+lines[i][1]);
        }
        Arrays.sort(lines,new Mycomparator());

        int max=0;
        int lastend=0;
        for(int i=0;i<n-1;i++){
            int index=Math.max(lastend+1,i+1);
            while(index<n&&lines[index][0]<=lines[i][1]) index++;
            if(index==n){
//                out.println("to end");
//                out.println(lines[index-1][0]+" "+lines[index-1][1]+" "+lines[i][0]+" "+lines[i][1]);
//                out.println(lines[index-1][1]-lines[i][0]-lines[i][1]+lines[index-1][0]);
                max=Math.max(max,lines[index-1][1]-lines[i][0]-lines[i][1]+lines[index-1][0]);
                break;
            }
            else{
                lastend=index-1;
//                out.println("lastend: "+lastend);
                max=Math.max(max,lines[index-1][1]-lines[i][0]-lines[i][1]+lines[index-1][0]);
            }
        }
        out.println(max);
    }
}
