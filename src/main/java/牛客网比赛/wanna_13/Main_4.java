package 牛客网比赛.wanna_13;


/**
 * 链接：https://www.nowcoder.com/acm/contest/80/D
 来源：牛客网

 题目描述
   最可爱的applese生日啦，他准备了许多个质量不同的蛋糕，想请一些同学来参加他的派对为他庆生，为了不让一部分同学感到不爽，他决定把每个蛋糕都分割成几份（也可以不分割），使得最小的蛋糕的质量与最大的蛋糕的质量的比值不小于一个值。但是applese的刀功并不是很好，所以他希望切尽量少的刀数使得所得到的蛋糕满足条件。由于applese为了保证每一块蛋糕的质量和期望的没有偏差，所以他一刀只能切下一块蛋糕，即将一块蛋糕分成两块，同时，他不能一刀同时切两块蛋糕，也就是说，applese一次只能将一块蛋糕分割成两块指定质量的蛋糕，这两块蛋糕的质量和应等于切割前的蛋糕的质量。Applese还急着准备各种派对用的饰品呢，于是他把这个问题交给了你，请你告诉他至少要切割几次蛋糕
 输入描述:
 第一行包括两个数T，n，表示有n个蛋糕，最小的蛋糕的质量与最大的蛋糕的质量的比值不小于T
 接下来n行，每行一个数wi，表示n个蛋糕的质量
 输出描述:
 输出包括一行，为最小切割的刀数
 数据保证切割次数不超过500
 示例1
 输入

 0.99 3
 2000 3000 4000
 输出

 6
 备注:
 0.5 < T < 1
 1 <= n <= 1000
 1 <= wi <= 1000000

 第一轮的思路：将最小的蛋糕 除以2、3、4……直到计算出的当前最大值curmax，最大的蛋糕切成curmax所需的刀数，切后大于curmin
 问题:curmin不是一直基于原先最小的蛋糕切得
 */

import java.util.Scanner;

import static java.lang.System.out;

public class Main_4 {
    public static int ceil(double a,double eps){
        if(a-((int) a)<eps) return (int)a;
        return (int) a +1;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        double T=scan.nextDouble();
        int n=scan.nextInt();
        double[] weight=new double[n];
        double[] cut=new double[n];
        for(int i=0;i<n;i++) weight[i]=scan.nextDouble();
        int sumcut=0;
        boolean continued=true;
        while(continued){
            double min=1e9,max=0;
            int index=-1;
            for(int i=0;i<n;i++){
                min=Math.min(min,weight[i]/(cut[i]+1.0));
                if(max<weight[i]/(cut[i]+1.0)){
                    index=i;
                    max=weight[i]/(cut[i]+1.0);
                }
            }
            if(min/max>=T){
                out.println(sumcut);
                break;
            }
            else{
                cut[index]+=1.0;
                sumcut++;
            }
        }
    }
}
