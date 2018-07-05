package wangyi;

/**
 * 小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.

 输入描述:
 输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
 第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
 第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)


 输出描述:
 输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数,以空格分割。行末无空格

 如样例所示:
 对于1个棋子: 不需要操作
 对于2个棋子: 将前两个棋子放在(1, 1)中
 对于3个棋子: 将前三个棋子放在(2, 1)中
 对于4个棋子: 将所有棋子都放在(3, 1)中

 输入例子1:
 4
 1 2 4 9
 1 1 1 1

 输出例子1:
 0 1 3 10
 */
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static int get(int[] index,int[][] chese,int num){
        int[] x=new int[num];
        int[] y=new int[num];
        for(int i=0;i<num;i++){
            x[i]=chese[index[i]][0];
            y[i]=chese[index[i]][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int middle=num/2;
        int mid_x=x[middle];
        int mid_y=y[middle];
        int res=0;
        for(int i=0;i<num;i++){
            res+=x[i]-mid_x>=0?x[i]-mid_x:mid_x-x[i];
            res+=y[i]-mid_y>=0?y[i]-mid_y:mid_y-y[i];
        }
        return res;
    }
    public static int find(int[][] chese,int num){
        int len=chese.length;
        if(num==1) return 0;
        int[] index=new int[num];
        int min=Integer.MAX_VALUE;
        int len_mid=1;
        index[0]=0;
        while(len_mid<num){
            index[len_mid]=index[len_mid-1]+1;
            len_mid++;
        }
        while(len_mid>0){
            if(len_mid==num){
//                for(int i=0;i<num;i++)
//                    out.print(index[i]+" ");
//                out.println();
                int res=get(index,chese,num);
                if(res<min) min=res;
            }
            if(index[len_mid-1]+(num-len_mid)<len-1){
                index[len_mid-1]++;
                while(len_mid<num){
                    index[len_mid]=index[len_mid-1]+1;
                    len_mid++;
                }
            }
            else{
                len_mid--;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println();
        int len=scan.nextInt();
        int[][] chese=new int[len][2];
        for(int i=0;i<len;i++){
            chese[i]=new int[2];
            chese[i][0]=scan.nextInt();
        }
        for(int i=0;i<len;i++)
            chese[i][1]=scan.nextInt();
        for(int i=1;i<len;i++){
            out.print(find(chese,i)+" ");
        }
        out.println(find(chese,len));

    }
}
