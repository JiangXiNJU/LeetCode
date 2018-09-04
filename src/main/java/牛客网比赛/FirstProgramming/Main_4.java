package 牛客网比赛.FirstProgramming;

/**
 * Created by cycy on 2018/6/20.
 * [编程题] 美丽的项链
 时间限制：1秒
 空间限制：32768K
 妞妞参加了Nowcoder Girl女生编程挑战赛, 但是很遗憾, 她没能得到她最喜欢的黑天鹅水晶项链。
 于是妞妞决定自己来制作一条美丽的项链。一条美丽的项链需要满足以下条件:
 1、需要使用n种特定的水晶宝珠
 2、第i种水晶宝珠的数量不能少于li颗, 也不能多于ri颗
 3、一条美丽的项链由m颗宝珠组成
 妞妞意识到满足条件的项链种数可能会很多, 所以希望你来帮助她计算一共有多少种制作美丽的项链的方案。

 输入描述:
 输入包括n+1行, 第一行包括两个正整数(1 <= n <= 20, 1 <= m <= 100), 表示水晶宝珠的种数和一条美丽的项链需要的水晶宝珠的数量。
 接下来的n行, 每行两个整数li, ri(0 <= li <= ri <= 10), 表示第i种宝珠的数量限制区间。


 输出描述:
 输出一个整数, 表示满足限定条件的方案数。保证答案在64位整数范围内。

 输入例子1:
 3 5
 0 3
 0 3
 0 3

 输出例子1:
 12

 10 20
 1 5
 1 3
 1 5
 1 5
 1 5
 1 1
 1 3
 1 2
 1 2
 1 1

 2655
 */
import java.util.Scanner;

import static java.lang.System.out;

public class Main_4 {
    public static long recur(int[][] range,int start,int end,int m){
        if(start==end){
            if(m>=range[start][0]&&m<=range[start][1]) return 1;
            else return 0;
        }
        if(start<end&&m<range[start][0]) return 0;
        long sum=0;
        for(int i=range[start][0];i<=range[start][1]&&i<=m;i++){
            sum+=recur(range,start+1,end,m-i);
        }
        return sum;
    }
    public static long dp(int [][] range,int n,int m){
        long[][] dp=new long[n][m];

        return dp[n-1][m-1];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long sum=0;
        int n=scan.nextInt();
        int m=scan.nextInt();
        int[][] range=new int[n][2];
        for(int i=0;i<n;i++){
            range[i]=new int[2];
            range[i][0]=scan.nextInt();
            range[i][1]=scan.nextInt();
        }
        out.println(dp(range,n,m));
    }
}
