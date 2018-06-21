package wanna_13;

/**
 * 链接：https://www.nowcoder.com/acm/contest/80/C
 来源：牛客网

 题目描述
 一个8 * 8的棋盘，第一个格子放1个麦穗，第二个格子放2个麦穗，第三个格子放4个麦穗……那么最后，共要放几个麦穗呢？
 zzf表示这个问题实在太简单，于是重新规定了游戏的规则。
 初始的棋盘为空，棋盘大小为p*p，然后他要对棋盘进行若干次操作，可以被选择的操作如下：
 1、选择一行，每个格子再放一个麦穗
 2、选择一列，每个格子再放一个麦穗
 进行若干次操作后，如果得到的棋盘满足如下性质
 1、每个格子都有至少一个麦穗
 2、每个格子最多只能有p*p个麦穗
 3、任意两个格子的麦穗数不同
 如果满足以上三条，那么称这个棋盘是一个好棋盘，若只是构造一个好棋盘那就太没意思了，zzf想知道他能得到多少个不同的好矩阵
 定义不同的矩阵即只要存在一个位置不同即是不同的
 答案对998244353取模

 输入描述:
 第一行读入一个数p，表示这个棋盘的大小
 输出描述:
 输出一行包括一个数，表示好棋盘的个数
 示例1
 输入

 2
 输出

 8
 说明

 样例解释 :
 1 2
 3 4
 3 4
 1 2
 1 3
 2 4
 2 4
 1 3
 2 1
 4 3
 4 3
 2 1
 3 1
 4 2
 4 2
 3 1
 备注:
 2 <= p <= 1e6, 保证p是质数
 */

import java.util.Scanner;

import static java.lang.System.out;

public class Main_3 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int p= scan.nextInt();
        int m=998244353;
        long ans=1;
        for(int i=1;i<=p-1;i++){
            ans=((ans%m)*(i%m))%m;
        }
        ans=(ans*ans)%m;
        ans=(ans*2)%m;
        ans=(ans*p)%m;
        ans=(ans*p)%m;
        out.println(ans);
    }
}
